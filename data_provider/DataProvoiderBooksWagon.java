package data_provider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvoiderBooksWagon {

	WebDriver driver;

	@Test(dataProvider = "seleni1")
	public void displayBooks(String bookName, String sortOrderBy) {

		// enter the book name and click search button
		driver.findElement(By.id("inputbar")).sendKeys(bookName);
		wait(1000);
		driver.findElement(By.name("btnTopSearch")).click();
		wait(2000);

		// display books count
		String resultMsg = driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[1]/div/b"))
				.getText();
		System.out.println("\nTotal No of Books = " + resultMsg);
		wait(2000);
		
		// select drop down
		Select select = new Select(driver.findElement(By.id("ddlSort")));
		select.selectByVisibleText(sortOrderBy);
		System.out.println("The book " + bookName + " is sorted based on " + sortOrderBy);
		wait(2000);
		
		// display top 3 books
		for (int i = 1; i <= 3; i++) {

			System.out.print(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[1]/a")).getText() + " - ");

			List<WebElement> total = driver
					.findElements(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[4]/div[1]/div"));

			if (total.size() == 1)
				System.out.println(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[4]/div[1]/div"))
						.getText());
			else
				System.out.println(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[4]/div[1]/div[2]"))
						.getText());
		}
	}

	

	@DataProvider
	public Object[][] seleni1() {
		Object[][] data = new Object[][] { 
			{ "Selenium Webdriver", "Title - A to Z" },
			{ "TestNG", "Price - Low to High" } 
			};
		return data;
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/");
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

	public void wait(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
