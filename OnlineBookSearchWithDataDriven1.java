package DataDrivernConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineBookSearchWithDataDriven1 {
	static WebDriver driver;
	static WebElement element;

	public void setUpDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/");
	}

	public WebDriver searchBook(String bookName) {
		driver.findElement(By.id("inputbar")).sendKeys(bookName);
		driver.findElement(By.name("btnTopSearch")).click();
		wait(2000);

		return driver;
	}

	public void displayTotalNoOfBooks() {
		String resultMsg = driver.findElement(By.className("preferences-show")).getText();
		// System.out.println("Total books: " + resultMsg);

		String totalNoOfBooks = resultMsg.replaceAll("[^0-9]", "");
		System.out.println("\nTotal No of Books: " + totalNoOfBooks);
	}
	
	public void setSortOrder(String sortOrderBy) {
		Select select = new Select(driver.findElement(By.id("ddlSort")));
		select.selectByVisibleText(sortOrderBy);
		System.out.println("sorted");
		wait(2000);
	}

	public void displayItems() {

		for (int i = 1; i <= 2; i++) {

			System.out
					.print(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[1]/a"))
							.getText() + " - ");

			List<WebElement> total = driver
					.findElements(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[4]/div[1]/div"));

			// displaying book price
			if (total.size() == 1)
				System.out.println(
						driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[4]/div[1]/div"))
								.getText());
			else
				System.out.println(
						driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[4]/div[1]/div[2]"))
								.getText());

		}
	}

	public void closeDriver() {
		driver.close();
	}

	public void wait(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OnlineBookSearchWithDataDriven1 obs = new OnlineBookSearchWithDataDriven1();
		obs.setUpDriver();

		String[] data;

		int rowCount = TestUtil.getRowCount();

		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			data = TestUtil.readExcelData(rowNo);
			obs.searchBook(data[0]);
			obs.displayTotalNoOfBooks();
			obs.setSortOrder(data[1]);
			obs.displayItems();
		}
		obs.closeDriver();
	}

}
