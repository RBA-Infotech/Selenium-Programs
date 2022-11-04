package data_provider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DataProviderRedBus {

	WebDriver driver;

	@Test(dataProvider = "dp")
	public void displayBusDetails(String src, String des) throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"src\"]")).sendKeys(src);
		Thread.sleep(2000);

		// Enter destination location
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(des);
		Thread.sleep(1000);

		// to know total no of rows in the month
		int noOfWeeks = driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr")).size();

		// Enter Date
		driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).click();

		if (noOfWeeks == 8)
			driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[7]/td[6]")).click();
		else
			driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[6]")).click();
		Thread.sleep(1000);

		// click search button
		driver.findElement(By.xpath("//*[@id=\"search_btn\"]")).click();
		
		Thread.sleep(3000);
		
		String busName = driver.findElement(By.xpath("//*[@id=\"17505419\"]/div/div[1]/div[1]/div[1]/div[1]")).getText();
		String busFare = driver.findElement(By.xpath("//*[@id=\"17505419\"]/div/div[1]/div[1]/div[6]/div/div[2]/span")).getText();

		System.out.println("Bus Name: " + busName + "\t" + "Bus Fare: " + busFare);
		
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"src\"]")).clear();
		driver.findElement(By.xpath("//input[@id='dest']")).clear();
	}

	@DataProvider
	public Object[][] dp() {

		Object[][] inputData = new Object[][] { 
			{ "Chennai", "Bangalore" }, 
			{ "Bangalore", "Hyderabad" } 
			};
		return inputData;
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Maximing the Window
		driver.manage().window().maximize();

		// Loading the website
		driver.get("https://www.redbus.in/");
	}

	@AfterClass
	public void afterClass() {
	}

}
