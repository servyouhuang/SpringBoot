package com.servyou.service.lmpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	/**
	 * @info 写出Excel标题和内容并且直接生成xls文件
	 * @param fos
	 * @return
	 */
	public static void writeExcel(String filePath,
			List<Map<Integer, String>> excelList,HSSFWorkbook workbook,String sheetName) throws IOException {
		OutputStream fos = new FileOutputStream(filePath);
		HSSFSheet sheet = workbook.createSheet(sheetName);
		sheet.setDefaultRowHeightInPoints(18);
		sheet.setDefaultColumnWidth(23);
		int rowNum = 0;
		for (Map<Integer, String> map : excelList) {
			HSSFRow rowTmp = sheet.createRow(rowNum);
			int cols = map.size();
			for (int i = 0; i < cols; i++) {
				HSSFCell cellTmp = rowTmp.createCell(i);
				cellTmp.setCellValue(map.get(i));
			}
			rowNum++;
		}
		workbook.write(fos);
		fos.close();
	}
}