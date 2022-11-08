package TestNGListenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerFile implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("Test is started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test is completed");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Executing starting for Method: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Successful for Method: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failure for Method: " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped for Method: " + result.getName());
	}

}
