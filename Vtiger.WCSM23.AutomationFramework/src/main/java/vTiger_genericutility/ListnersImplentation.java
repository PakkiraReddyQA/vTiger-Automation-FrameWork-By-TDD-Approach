package vTiger_genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {

		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		test.log(Status.INFO, "test execution Started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
			}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,"Test Script Passed"+MethodName);
	}

	public void onTestFailure(ITestResult result)
	{
	
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, "test Script Failed"+MethodName);
		test.log(Status.FAIL, result.getThrowable());
		String ScreenShotName =MethodName+" "+ jUtil.getSystemDateformat();
		System.out.println(ScreenShotName);
		try {
			String path = wUtil.takescreenshot(	BaseClass.sdriver, ScreenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{

		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, "test Script is Skipped"+MethodName);
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) 
	{

		System.out.println("----Suite Execution Started----");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateformat()+".html");
       htmlReport.config().setDocumentTitle("FaceBook Execution Report");
       htmlReport.config().setReportName("execution Report");
       htmlReport.config().setTheme(Theme.DARK);
       
       report=new ExtentReports();
       report.attachReporter(htmlReport);
       report.setSystemInfo("Browser","Chrome");
       report.setSystemInfo("Base OS", "Windows");
       report.setSystemInfo("Base URL","https://www.facebook.com/");
       
	}

	public void onFinish(ITestContext context) {
		System.out.println("----Suite Execution Finished----");
		report.flush();
	}



}
