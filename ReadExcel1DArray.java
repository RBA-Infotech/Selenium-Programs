package SeleniumDemo;

public class ReadExcel1DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int rowNo = 1; rowNo <= 3; rowNo++) {
			String[] data = ExcelUtil.readData(rowNo);

			for (int i = 0; i < data.length; i++)
				System.out.print(data[i] + "\t");
			System.out.println();
		}

	}

}
