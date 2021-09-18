package com.crm.genericUtils;

import java.time.LocalDateTime;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {

	ExtentTest test;
	ExtentReports reports;

	public void onTestStart(ITestResult result) {
	test=	reports.createTest(result.getMethod().getMethodName());

	}

	public void onStart(ITestContext context) {
		JavaUtility jv= new JavaUtility();
		String date = jv.getDateAndTime();
		ExtentHtmlReporter reporter;
		reporter=new ExtentHtmlReporter(IPathConstant.extentReportPath+"report"+date+".html");
		reporter.config().setDocumentTitle("sdet21");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("batch");

		reports=new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("AppUrl", "http://localhost:8888");
		reports.setSystemInfo("Env", "Test QA");
		reports.setSystemInfo("Build", "2.1");
		reports.setSystemInfo("Reporter name", "B P Sahoo");


	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub


	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());

		BaseClass bc=new BaseClass();
		try {
			String path = bc.getScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");

	}




	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		reports.flush();

	}

}
