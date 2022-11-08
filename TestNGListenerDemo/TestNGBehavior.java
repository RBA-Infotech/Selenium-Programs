package TestNGListenerDemo;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@Listeners(ListenerFile.class)
public class TestNGBehavior {

	@BeforeTest
	public void setUp() {
		System.out.println("Launching Browser");
	}

	@AfterTest
	public void tearDown() {
		System.out.println("closing browser");
	}

	@Test(priority = 1)
	public void loginTest() {
		System.out.println("loginTest");
		Assert.assertEquals("Selenium", "Selenium");
	}

	@Test(priority = 2)
	public void searchProduct() {
		System.out.println("searchProduct");
		Assert.assertEquals("Selenium", "Sele");
	}

	@Test(priority = 3)
	public void selectProduct() {
		System.out.println("selectProduct");
		Assert.assertTrue(true);
	}

	@Test(priority = 4, dependsOnMethods = { "selectProduct", "searchProduct" })
	public void addToCart() {
		System.out.println("addToCart");
	}
}
