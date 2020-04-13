package com.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;



public class ReportGeneration implements ITestListener{
	
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
 
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        ExtentTestManager.startTest(iTestContext.getName(), "Starting Method");
    }
 
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
       
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        //ExtentReports log operation for passed tests.
        
        System.out.println(ExtentTestManager.getTest());
        
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }
 
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        
        System.out.println(ExtentTestManager.getTest());
     
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
    }
 
    
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
      
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
	
	

	/*
	 * public void onFinish(ITestContext Result) {
	 * 
	 * }
	 * 
	 * public void onStart(ITestContext Result) {
	 * 
	 * }
	 * 
	 * public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
	 * 
	 * }
	 * 
	 * // When Test case get failed, this method is called. public void
	 * onTestFailure(ITestResult Result) {
	 * System.out.println("The name of the testcase failed is :"+Result.getName());
	 * 
	 * }
	 * 
	 * // When Test case get Skipped, this method is called. public void
	 * onTestSkipped(ITestResult Result) {
	 * System.out.println("The name of the testcase Skipped is :"+Result.getName());
	 * }
	 * 
	 * // When Test case get Started, this method is called. public void
	 * onTestStart(ITestResult Result) {
	 * System.out.println(Result.getName()+" test case started"); }
	 * 
	 * // When Test case get passed, this method is called. public void
	 * onTestSuccess(ITestResult Result) {
	 * System.out.println("The name of the testcase passed is :"+Result.getName());
	 * }
	 */	


}
