package com.gangling.web;

import com.gangling.service.ExcelDownService;
import com.gangling.service.SqlSessionService;
import org.apache.log4j.lf5.util.StreamUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * created by liufeng
 * 2019/1/2
 */
@Controller
public class ExcelDownController {
    @Resource
    private ExcelDownService excelDownService;
    @Resource
    private SqlSessionService sqlSessionService;

    @RequestMapping("/downExcel")
    public void downExcel(HttpServletResponse response) throws Exception {
        byte[] fileNameByte = ("test.xlsx").getBytes("GBK");
        String filename = new String(fileNameByte, "ISO8859-1");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        try(ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet();
            String sheetRef = sheet.getPackagePart().getPartName().getName().substring(1);
            //创建一个临时文件
            File file = File.createTempFile("template", ".xlsx");
            //写入excel信息作为模板
            wb.write(new FileOutputStream(file));
            try(ZipFile templateZip = new ZipFile(file)){
                Enumeration<? extends ZipEntry> templateEntries = templateZip.entries();
                while (templateEntries.hasMoreElements()) {
                    //拷贝除了excel数据之外的所有压缩文件
                    ZipEntry entry = templateEntries.nextElement();
                    if (!entry.getName().equals(sheetRef)) {
                        zos.putNextEntry(new ZipEntry(entry.getName()));
                        templateZip.getInputStream(entry);
                        StreamUtils.copy(templateZip.getInputStream(entry), zos);
                    }
                }
                //开始写入excel数据
                zos.putNextEntry(new ZipEntry(sheetRef));
                try(OutputStreamWriter sheetOut = new OutputStreamWriter(zos, StandardCharsets.UTF_8)){
                    excelDownService.writeExceData(sheetOut);
                }
            }
        }
    }

    @RequestMapping("/findData")
    public void findData(){
        sqlSessionService.selectTest();
    }
}
