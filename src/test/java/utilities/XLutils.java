package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLutils {
	
	//******************** Approach By Jawad Karim *********************************
	public String[][] XLdataProvider () throws Exception {

		File file = new File("C:/Users/jawad/OneDrive/Documents/Bank_data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int row = wb.getSheetAt(0).getLastRowNum();
		int col = wb.getSheetAt(0).getRow(row).getLastCellNum();
		
		String[][] data = new String[row][col]; //declare array & store datas from XL
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {

				data[i][j] = wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();			
			}
		}
		return data;

	}
	
	//************************ Approach By Pavan **********************************
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
