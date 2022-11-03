package SeleniumDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil2 {

	public static String[][] readData() {

		String fileName = "src\\SeleniumDemo\\InputData.xlsx";
		FileInputStream fis = null;
		XSSFWorkbook workBook = null;

		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFSheet sheet = workBook.getSheet("Sheet1"); // workBook.getSheetAt(0)

		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count: " + rowCount);

		String[][] data = new String[4][3];
		
		for (int rowNo = 0; rowNo < rowCount; rowNo++) {
			int cellCount = sheet.getRow(rowNo).getLastCellNum();
			
			for (int cellNo = 0; cellNo < cellCount; cellNo++) {
				Cell cell = sheet.getRow(rowNo).getCell(cellNo);

				if (cell.getCellType() == CellType.NUMERIC) {
					if (cellNo == 0)
						data[rowNo][cellNo] = String.valueOf((int) sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue());
					else
						data[rowNo][cellNo] = String.valueOf(sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue());
				} else
					data[rowNo][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			}
		}

		return data;

	}
}
