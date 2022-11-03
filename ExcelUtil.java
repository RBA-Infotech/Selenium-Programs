package SeleniumDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String[] readData(int rowNo) {

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

		int cellCount = sheet.getRow(rowNo).getLastCellNum();
		String[] data = new String[cellCount];

		for (int cellNo = 0; cellNo < cellCount; cellNo++) {
			Cell cell = sheet.getRow(rowNo).getCell(cellNo);

			if (cell.getCellType() == CellType.NUMERIC) {
				if (cellNo == 0)
					data[cellNo] = String.valueOf((int) sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue());
				else
					data[cellNo] = String.valueOf(sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue());
			} else
				data[cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		}

		return data;

	}
}
