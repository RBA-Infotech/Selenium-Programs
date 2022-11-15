package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon_3_Browsers {
	WebDriver driver;
	String nodeURL;

	@Parameters({ "Port" })
	@BeforeClass
	public void setUp(String portNo) {
		if (portNo.equalsIgnoreCase("4545")) {
			nodeURL = "http://localhost:4444/wd/hub";
			System.out.println("Chrome Browser Initiated");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName("chrome");
			desiredCapabilities.setPlatform(Platform.WINDOWS);

			try {
				driver = new RemoteWebDriver(new URL(nodeURL), desiredCapabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if (portNo.equalsIgnoreCase("4546")) {
			nodeURL = "http://localhost:4444/wd/hub";
			System.out.println("Firefox Browser Initiated");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName("firefox");
			desiredCapabilities.setPlatform(Platform.WINDOWS);

			try {
				driver = new RemoteWebDriver(new URL(nodeURL), desiredCapabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if (portNo.equalsIgnoreCase("4547")) {
			nodeURL = "http://localhost:4444/wd/hub";
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setBrowserName("MicrosoftEdge");
			desiredCapabilities.setPlatform(Platform.WINDOWS);

			try {
				driver = new RemoteWebDriver(new URL(nodeURL), desiredCapabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

	}

	@Test
	public void launchAmazon() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
	}
}
