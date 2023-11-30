package com.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
	String MethodName=result.getMethod().getMethodName();
	test=report.createTest(MethodName);
	Reporter.log(MethodName +"---------TestScript execution starts from here");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName +"--->PASSED");
		Reporter.log(MethodName+"------TestScript Excecuted Successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String FS = result.getMethod().getMethodName();
		String Fscript=FS + new JavaUtils().systemDateInFormat();
		try {
			WebDriverUtils1.getScreenShot(AdminBaseClass.sdriver, Fscript);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(Fscript);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, Fscript+"----->FAILED");
		Reporter.log(Fscript+"----------->Test Execution failed");
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		String method=MethodName +new JavaUtils().systemDateInFormat();
		try {
			WebDriverUtils1.getScreenShot(AdminBaseClass.sdriver,method );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(method);
		test.log(Status.SKIP, MethodName+"--->SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(method+"------->TestScript Execution SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("Batch-52");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("HungerMantra");
		
	 report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://");
		report.setSystemInfo("Reporter Name", "Abhijith DN");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	report.flush();	

	}

	
	
}
