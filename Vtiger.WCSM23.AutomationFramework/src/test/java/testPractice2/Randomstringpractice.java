package testPractice2;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class Randomstringpractice {
	
	@Test
	void randomstring()
	{
		String randomstring = RandomStringUtils.randomAlphabetic(10);
		String randomalphanumeric = RandomStringUtils.randomAlphanumeric(8);
		System.out.println(randomalphanumeric);
		
		System.out.println(randomstring+"@gmail.com");
	}
	@Test
	void multiplication()
	{
		int i=10;
		System.out.println(i*i--);
	}

}
