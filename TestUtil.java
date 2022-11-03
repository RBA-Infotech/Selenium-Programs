package DataDrivernConcept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	static String[] data;
	static FileInputStream fis = null;
	static XSSFWorkbook workBook = null;
	static String fileName = ".\\src\\DataDrivernConcept\\InputData.xlsx";
	
	public static String[] readExcelData(int rowNo) {
	
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
		XSSFSheet sheet = workBook.getSheet("Input");  //workBook.getSheetAt(0)
				
		int cellCount = sheet.getRow(rowNo).getLastCellNum();
		data = new String[cellCount];
		
		for(int cellNo=0; cellNo<cellCount; cellNo++) {
			
			data[cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		}
		
		return data;
			}
	
	
	public static int getRowCount() {
		
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
		XSSFSheet sheet = workBook.getSheet("Input");  //workBook.getSheetAt(0)
		
		int rowCount = sheet.getLastRowNum();
		
		return rowCount;
		
	}

}
