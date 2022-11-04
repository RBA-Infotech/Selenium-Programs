package SeleniumDemo;

public class ReadExcel2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			String[][] data = ExcelUtil2.readData();

			for(int rowNo = 0; rowNo < 4; rowNo++) {
				for(int cellNo = 0; cellNo < 3; cellNo++) {
					System.out.print(data[rowNo][cellNo] + "\t");
				}
				System.out.println();
			}
	}

}
