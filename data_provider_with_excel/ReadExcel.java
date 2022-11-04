package data_provider_with_excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] readData() {

		FileInputStream fis;
		Object[][] data = new Object[3][2];
		String fileName = ".\\src\\data_provider_with_excel\\InputData.xlsx";

		try {
			fis = new FileInputStream(fileName);

			XSSFWorkbook workbook = new XSSFWorkbook(fis); // XSSF -> xlsx- after 2013, xls - older version
			XSSFSheet sheet = workbook.getSheetAt(0); // workbook.getSheet("Sheet1")

			int rowCount = sheet.getLastRowNum();

			for (int rowNo = 1; rowNo <= rowCount; rowNo++) { // i =1 means selection 2nd row in xl sheet

				int cellCount = sheet.getRow(rowNo).getLastCellNum(); // getting total no of cell in the row

				for (int cellNo = 0; cellNo < cellCount; cellNo++) { // this loop is to traverse each cell in row
					data[rowNo - 1][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
				}
			}
			workbook.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("File name is not correct");
		} catch (IOException ioe) {
			System.out.println("Not able to read or write, pls check");
		}
		return data;
	}
}
