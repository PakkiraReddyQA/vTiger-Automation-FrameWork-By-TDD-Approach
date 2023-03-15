package vTiger_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sampleUpdate() throws SQLException
	{
	
		Driver driverRef=new Driver();
		//Register the Driver
		DriverManager.registerDriver(driverRef);
		//Get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm23db","root", "root");
		//create issue statement
		Statement state = con.createStatement();
		String Query = "insert into EmployeesInfo(name,empId,Designation,salaray) values('raghuram',18,'WatchMen',15000)";
		int result = state.executeUpdate(Query);
	    ResultSet re = state.executeQuery("select * from EmployeesInfo;");
	    while(re.next())
	    {
	    	System.out.println(re.getString(1)+" "+re.getInt(2)+" "+re.getString(3)+" "+re.getInt(4));
	    }
	    if(result==1)
	    {
	    	System.out.println("Data updated suceessfully");
	    }
	}
	@Test
	public void simpleUpdate() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Query for Updating");
		String updateQuery = sc.nextLine();
		Driver driverRef=new Driver();
		//Register the Driver 
		DriverManager.registerDriver(driverRef);
		//Get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm23db","root", "root");
		//create issue statement
		Statement state = con.createStatement();
		state.executeLargeUpdate(updateQuery);
//		String Query = "insert into EmployeesInfo values('raghuram',18,'WatchMen',15000)";
		int result = state.executeUpdate("insert into EmployeesInfo values('raghuram',18,'WatchMen',15000);");
	    ResultSet re = state.executeQuery("select * from EmployeesInfo;");
	    while(re.next())
	    {
	    	System.out.println(re.getString(1)+" "+re.getInt(2)+" "+re.getString(3)+" "+re.getInt(4));
	    }
	    if(result==1)
	    {
	    	System.out.println("Data updated suceessfully");
	    }
		sc.close();
	}
	

}
