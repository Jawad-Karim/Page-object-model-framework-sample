package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLdataProvider {

	XSSFWorkbook wb;

	@Test
	public void XLdataProvider1 () throws Exception {

		File file = new File("C:/Users/jawad/OneDrive/Documents/Bank_data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		String data1 = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
		System.out.println("first Row, first Column data : "+data1);

		int row = wb.getSheetAt(0).getLastRowNum();
		System.out.println("total row number : "+ row);

		int col = wb.getSheetAt(0).getRow(row).getLastCellNum();
		System.out.println("total column : "+col);

		for(int i=0; i<row; i++) {

			String data2 = wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();
			System.out.println("all rows of first column data : "+data2);
		}


		for(int j=0; j<col; j++) {

			String data3 = wb.getSheetAt(0).getRow(4).getCell(j).getStringCellValue();
			System.out.println("4th row and all columns data : "+data3);
		}

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {

				String data4 = wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
				System.out.println("all rows and all column's data : "+data4);
			}
		}

		//**************** declare two dimensional array *******************************
		String[][] data5 = new String[row][col];
		String[][] data6 = new String[row][col];
		
		//**************** store Excel datas into two dimensional arrays ***************
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {

				data5[i][j] = wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();			
			}
		}

		//************ print the datas of two dimensional arrays *********************** 
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++)				
				System.out.println("data5 : "+ data5[i][j]);
		}


	}



}
