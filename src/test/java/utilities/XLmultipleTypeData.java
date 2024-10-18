package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

// dependencies: apache poi, poi-ooxml and poi-ooxml-schemas
public class XLmultipleTypeData {

	@Test
	public void readExcelData() throws Exception {

		File file = new File("C:\\Users\\jawad\\eclipse-workspace\\TestNG_Framework_oct-15-24\\testData\\userData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheetAt(1);

		//identify the Cell Type
		XSSFCell cell;
		CellType cellType;

		int rowNo = s.getLastRowNum();				
		int colNo = s.getRow(0).getLastCellNum();		
		//total rows size = rowNO+1 (0 based index)
		//total columns size = conNo (1 based index)
		
		Object[][] data = new Object[rowNo+1][colNo];
		//String[][] data = new String[rowNo+1][colNo];

		for(int i=0; i<=rowNo; i++) {
			for(int j=0; j<colNo; j++) {

				cell = s.getRow(i).getCell(j);
				cellType = cell.getCellType();
				System.out.println(cellType);

				switch(cellType) {			
				case STRING: 
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:	//type casting double to int then convert to String
					data[i][j] = String.valueOf((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					//data[i][j] = String.valueOf(cell.getBooleanCellValue());
					data[i][j] = cell.getBooleanCellValue();
				}			
			}
		}

		System.out.println("value: "+ data[0][0]);
		for(int i=0; i<=rowNo; i++) {
			for(int j=0; j<colNo; j++) {
				System.out.println("data: "+data[i][j]);
			}
		}
	}
}
