package data_provider_with_excel;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class DataProviderRedBus {
	WebDriver driver;
	
	@Test(dataProvider = "dp")
  public void searchBusesWithMultipleRoute(String src, String des) throws InterruptedException {
  
		//Enter source location
		driver.findElement(By.xpath("//*[@id=\"src\"]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"src\"]")).sendKeys(src);
		Thread.sleep(2000);
		
		//Enter destination location
		driver.findElement(By.xpath("//input[@id='dest']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(des);
		Thread.sleep(2000);
		
		//Enter Date
		driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[7]/td[6]")).click();
		Thread.sleep(2000);
		
		// click search button
		driver.findElement(By.xpath("//*[@id=\"search_btn\"]")).click();
		
		System.out.println(src + " -> " + des + " = "+driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/span[1]/span")).getText());
		Thread.sleep(4000);
		
		driver.navigate().back();
	}

  @DataProvider
  public Object[][] dp() throws IOException{
	  Object[][] obj = new Object[3][2];
	  //String fileName = ".\\TestData\\testdata.xlsx";
	  obj = ReadExcel.readData();
	  return obj;
	 }
 
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(ops);
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Maximing the Window
		driver.manage().window().maximize();
		
		// Loading the website 
		driver.get("https://www.redbus.in/");
		//To pause the program for mentioned msec

  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
