package com.gangling.service;

import org.apache.ibatis.cursor.Cursor;

import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/2
 */
public interface ExcelDownService {

    void writeExceData(OutputStreamWriter sheetOut) throws Exception;
    Cursor<Map<String,String>> findData();
}
