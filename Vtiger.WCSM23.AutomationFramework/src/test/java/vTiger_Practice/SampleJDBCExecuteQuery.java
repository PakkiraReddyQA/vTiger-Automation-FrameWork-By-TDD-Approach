package vTiger_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	@Test
	public void sampleJDBC() throws SQLException
	{
		Driver driverRef=new Driver();
		
		//Step1:Register the driver
	DriverManager.registerDriver(driverRef);
	
	//Step2:Get the connection with driver-database
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm23db", "root", "root");
	
	//Step3:create issue Statement
	Statement state = con.createStatement();
	
	//Step4:Execute Query
	ResultSet result = state.executeQuery("select * from EmployeesInfo;");
	while(result.next())
	{
		System.out.println(result.getNString(1)+" "+result.getInt(2)+" "+result.getNString(3)+" "+result.getInt(4));
	}
    //Step5:close db
	con.close();
	}
	@Test
	public void sampleJdbcPractice() throws SQLException
	{
		Driver driverRef=new Driver();
       //Step1:Register the Driver
		DriverManager.registerDriver(driverRef);
		//Step2:Establish the Connection with driver-database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm23db", "root", "root");
		
		//Step3:create an issue statment
		Statement state = con.createStatement();
		//step4:Execute the Query
		ResultSet result = state.executeQuery("select * from EmployeesInfo;");
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
		//step5:close the connection with db
		con.close();
		
	}
       @Test
        public void samplejdbc() throws SQLException
        {
    	   Driver driverRef=new Driver();
	     DriverManager.deregisterDriver(driverRef);
	     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm23db", "root", "root");   
	     Statement state = con.createStatement();
	     ResultSet result = state.executeQuery("select * from EmployeesInfo;");
	     while(result.next())
	     {
	    	 System.out.println(result.getString(1));
	     }
	     con.close();
	     
	     }
       }
