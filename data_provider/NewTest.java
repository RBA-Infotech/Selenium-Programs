package data_provider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

	@DataProvider
	public Object[][] dp() {
	
		Object[][] data = {
				{"Selenium" , "Price Low - High"},
				{"TestNG" , "Title A - Z"}
		};
		
		return data;
	
	
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
