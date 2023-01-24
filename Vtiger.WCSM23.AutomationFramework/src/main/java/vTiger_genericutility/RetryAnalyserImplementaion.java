package vTiger_genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class will provide implementaion to the IRtryAnalyser Interface of TestNG
 * @author pakki
 *
 */

public class RetryAnalyserImplementaion implements IRetryAnalyzer {
int count=0,retryCount=3;
/**
 * this Retry until retryciunt met
 */
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
