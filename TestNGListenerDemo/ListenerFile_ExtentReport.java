package TestNGListenerDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListenerFile_ExtentReport implements ITestListener {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		System.out.println("Test is started");
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test is completed");
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Executing starting for Method: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Successful for Method: " + result.getName());
		test = extent.createTest(result.getName());
		test.pass(result.getName() + " is Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failure for Method: " + result.getName());
		
		String fileName = "screenshot_14-09-2022_16_07_13.png";  //captureScreenshot(result.getName());

		test = extent.createTest(result.getName());
		try {
			test.fail(result.getName() + " is Failed",
					MediaEntityBuilder.createScreenCaptureFromPath("Screenshots\\" + fileName).build());
			test.addScreenCaptureFromPath(".\\Screenshots\\" + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped for Method: " + result.getName());
		test = extent.createTest(result.getName());
		test.skip(result.getName() + " is Skipped");
	}
	
	public String captureScreenshot(String errorName) {
		System.out.println("Screenshot for error: " + errorName);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); // yyyy-MM-dd
		String dateTime = sdf.format(date);
		String fileName = "screenshot_" + dateTime + ".png";

		WebDriver driver = null;
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\" + fileName);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileName;
	}

}
