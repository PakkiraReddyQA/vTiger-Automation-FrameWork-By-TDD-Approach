package vTiger_contacts_TestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vTiger_genericutility.BaseClass;
@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)
public class DemoTest extends BaseClass {
	@Test
	public void demo() throws InterruptedException
	{
		System.out.println("demo");
		Thread.sleep(2000);
			
	}
	@Test
	public void sample() throws InterruptedException
	{
		System.out.println("sample");
		Thread.sleep(2000);
	}

}
