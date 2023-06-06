package listenerPack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerClass implements ITestListener {

	public void onFinish(ITestContext arg0) {

		Reporter.log("test is finished", true);
	}

	public void onStart(ITestContext arg0) {
		
		Reporter.log("test is starting", true);
	}

	public void onTestFailure(ITestResult arg0) {
		
		Reporter.log("test is failed", true);
	}

	public void onTestSkipped(ITestResult arg0) {
		
		Reporter.log("test is skipped", true);
	}

	public void onTestStart(ITestResult arg0) {
		
		Reporter.log("facebook test is started", true);
	}

	public void onTestSuccess(ITestResult arg0) {
		
		Reporter.log("facebook test is success", true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
