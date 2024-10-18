package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutility {

	public File file;
	public FileInputStream fis;
	public XSSFWorkbook wb;

	public XLutility() {

		try {
			file = new File ("C:/Users/jawad/OneDrive/Documents/ Bank_data.xlsx");
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println("Exception message : "+e.getMessage());
			System.out.println("Exception cause : "+e.getCause());
		}
	}

	public String getStringData(int SheetNo, int rowNo, int cellNo) {
		return wb.getSheetAt(SheetNo).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}	

	public String getStringData(String SheetName, int rowNo, int cellNo) {
		return wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}	

	public double getNumericData(int SheetNo, int rowNo, int cellNo) {
		return wb.getSheetAt(SheetNo).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}	

	public double getNumericData(String SheetName, int rowNo, int cellNo) {
		return wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}



}
