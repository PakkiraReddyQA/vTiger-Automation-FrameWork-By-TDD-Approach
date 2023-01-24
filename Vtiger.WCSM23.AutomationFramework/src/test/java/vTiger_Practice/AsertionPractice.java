package vTiger_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsertionPractice {
	@Test
	public void AssertTest1()
	{
		System.out.println("test1");
		System.out.println("test2");
		System.out.println("test3");
//		Assert.assertEquals(true, false);
		Assert.assertTrue(false);
		System.out.println("test4");
		System.out.println("test5");
		System.out.println("test6");
		
	}
	@Test
	public void AssertTest2()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("test1");
		System.out.println("test2");
		sa.assertEquals(true,false);//pass
		System.out.println("test3");
		sa.assertTrue(false);//fail
		System.out.println("test4");
		sa.assertEquals("a", "b");
		System.out.println("test5");
		System.out.println("test6");
		sa.assertAll();
		
	}

}
