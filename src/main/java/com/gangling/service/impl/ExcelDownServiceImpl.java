package com.gangling.service.impl;

import com.gangling.service.ExcelDownService;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.DateUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/2
 */
@Service
public class ExcelDownServiceImpl implements ExcelDownService {
    @Resource
    private SqlSessionTemplate sqlSession;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void writeExceData(OutputStreamWriter sheetOut) throws Exception{
        Cursor<Map<String,String>> dataCursor = findData();
        SpreadsheetWriter sw = new SpreadsheetWriter(sheetOut);
        sw.beginSheet();
        //写入title
        sw.insertRow(0);
        int styleIndex = -1;
        sw.createCell(0, "id", styleIndex);
        sw.createCell(1, "enterprise_id", styleIndex);
        sw.createCell(2, "enterprise_name", styleIndex);
        sw.createCell(3, "province", styleIndex);
        sw.createCell(4, "city", styleIndex);

        sw.endRow();
        //写入具体数据
        int row = 1;
        for (Map<String, String> data : dataCursor) {
            sw.insertRow(row++);
            sw.createCell(0,data.get("enterprise_name"),styleIndex);
            sw.endRow();
        }
        sw.endSheet();
    }

    @Override
    public Cursor<Map<String,String>> findData(){
        return sqlSession.selectCursor("com.gangling.dao.UsermanageEnterpriseMapper.findAll");
    }

    public static class SpreadsheetWriter {
        private final Writer _out;
        private int _rownum;

        SpreadsheetWriter(Writer out){
            _out = out;
        }

        void beginSheet() throws IOException {
            _out.write("<?xml version=\"1.0\" encoding=\""+"UTF-8"+"\"?>" +
                    "<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">" );
            _out.write("<sheetData>\n");
        }

        void endSheet() throws IOException {
            _out.write("</sheetData>");
            _out.write("</worksheet>");
        }

        /**
         * Insert a new row
         *
         * @param rownum 0-based row number
         */
        void insertRow(int rownum) throws IOException {
            _out.write("<row r=\""+(rownum+1)+"\">\n");
            this._rownum = rownum;
        }

        /**
         * Insert row end marker
         */
        void endRow() throws IOException {
            _out.write("</row>\n");
        }

        public void createCell(int columnIndex, String value, int styleIndex) throws IOException {
            String ref = new CellReference(_rownum, columnIndex).formatAsString();
            _out.write("<c r=\""+ref+"\" t=\"inlineStr\"");
            if(styleIndex != -1) {
                _out.write(" s=\""+styleIndex+"\"");
            }
            _out.write(">");
            _out.write("<is><t>"+value+"</t></is>");
            _out.write("</c>");
        }

        public void createCell(int columnIndex, String value) throws IOException {
            createCell(columnIndex, value, -1);
        }

        public void createCell(int columnIndex, double value, int styleIndex) throws IOException {
            String ref = new CellReference(_rownum, columnIndex).formatAsString();
            _out.write("<c r=\""+ref+"\" t=\"n\"");
            if(styleIndex != -1) {
                _out.write(" s=\""+styleIndex+"\"");
            }
            _out.write(">");
            _out.write("<v>"+value+"</v>");
            _out.write("</c>");
        }

        public void createCell(int columnIndex, double value) throws IOException {
            createCell(columnIndex, value, -1);
        }

        public void createCell(int columnIndex, Calendar value, int styleIndex) throws IOException {
            createCell(columnIndex, DateUtil.getExcelDate(value, false), styleIndex);
        }
    }
}
