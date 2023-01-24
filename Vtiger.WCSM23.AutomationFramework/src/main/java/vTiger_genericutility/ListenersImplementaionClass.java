package vTiger_genericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementaion to all the methods in ITestListener Interface of Testing
 * @author pakkira Reddy
 *
 */
public class ListenersImplementaionClass implements ITestListener{
ExtentReports reports;
ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test=reports.createTest(methodName);
		test.log(Status.INFO, "=====Execution started===="+methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,"==TestScript PASS=="+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		//Create Objects for required we can extend BaseClass
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
//		System.out.println("============"+methodName+"======TestScript Failed======");
//		System.out.println(result.getThrowable());
		test.log(Status.FAIL, "--test script Failed--"+methodName);
		test.log(Status.FAIL, result.getThrowable());
		
		String screenshotName = methodName+"-"+jUtil.getSystemDateformat();
		try 
		{
			String path = wUtil.takescreenshot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "--test script skipped--"+methodName);
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
//		System.out.println("======Suite Execution started======");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Rport-"+new JavaUtility().getSystemDateformat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setReportName("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base URL", "https://localhost:8888");
        reports.setSystemInfo("BaseBrowser", "Chrome");
        reports.setSystemInfo("Base platform", "windwos");
        reports.setSystemInfo("ReporterName", "Pakkira Reddy");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("====suite Execution finished======");
		reports.flush();//it will tell to extentreports ,,,execution completed ...you can generate report
	}
	

}
