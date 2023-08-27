package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;


	public static int getrowCount(String file, int sheetNo) throws Exception {

		File filee = new File(file);
		fis = new FileInputStream(filee);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(sheetNo);
		int rowCountNo = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCountNo;	
	}

	public static int getCellCount(String file, int sheetNo, int rownum) throws Exception {

		File filee = new File(file);
		fis = new FileInputStream(filee);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(sheetNo);
		row = sheet.getRow(rownum);
		int cellCountNo = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCountNo;
	}

	public static String getcellData(String file, int sheetNo, int rownum, int cellnum) throws Exception {

		File filee = new File(file);
		fis = new FileInputStream(filee);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(sheetNo);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;

		try {

			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);

			return cellData;

		} catch (Exception e) {

			data="";	
		}
		wb.close();
		fis.close();
		return data; 
	}
}
