package testPractice2;

import java.util.Scanner;

public class runTime {
	public static void main(String[] args) {
		
		   
		    	Scanner sc=new Scanner(System.in);
		    	System.out.println("Enter value");
		        int x = 5;
		        if (x == 5) 
		        {
		        	
		            int x1 = sc.nextInt();
		            x=x1;// Changing the value of x based on a condition
		        }
		        System.out.println("The value of x is: " + x);
		    }
		
	
}
