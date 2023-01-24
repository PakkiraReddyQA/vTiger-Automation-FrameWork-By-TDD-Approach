package vTiger_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPeactice {
	@Test(dataProvider ="getData" )
	public void addproductToCart(String phone,int price,String model)
	{
		System.out.println(phone+" "+price+" "+model);
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		 
		data[0][0]="samsung";
		data[0][1]=12000;
		data[0][2]="a17";
		
		data[1][0]="Iphone";
		data[1][1]=15000;
		data[1][2]="I11";
		
		return data;
		
				
	}

}
