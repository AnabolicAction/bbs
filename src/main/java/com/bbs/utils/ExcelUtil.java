package com.bbs.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtil {

	public static String getStringCellValue(XSSFCell cell) {
		return getStringCellValue(null, cell);
	}

	public static String getStringCellValue(String key, XSSFCell cell) {
		if (cell == null) {
			return StringUtils.isBlank(key) ? null : key;
		}
		String result = null;
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			double cellValue = (double) cell.getNumericCellValue();
			if (cellValue % 1.0 > 0) {
				result = new Double((double) cellValue).toString();
			} else {
				result = Integer.toString((int) cellValue);
			}
		} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			result = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			result = Integer.toString((int) cell.getNumericCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			result = Boolean.toString(cell.getBooleanCellValue());
		}
		return result;
	}

}
