package com.listerner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.BaseClass;
import com.Utility.DriverUtils;
import com.aventstack.extentreports.Status;

public class MyListener extends BaseClass implements ITestListener {

	public void onFinish(ITestContext context) {

		log.info("test suite is successfully executed");
		report.flush();

	}

	public void onStart(ITestContext context) {
		log.info("test suite is ready for the execution");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		try {
			path = DriverUtils.getScreenshot(result.getName());
		} catch (Exception e) {

			e.printStackTrace();
		}
		test.log(Status.FAIL, "Testcase failed with name" + result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skipped with name" + result.getName());

	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase passed with name" + result.getName());

	}

}
