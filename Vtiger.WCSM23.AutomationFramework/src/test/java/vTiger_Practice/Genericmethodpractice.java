package vTiger_Practice;

public class Genericmethodpractice {
	public static void main(String[] args) {
		int c=add(10,20);
		System.out.println(c);
		int c1=add(20,30);
		System.out.println(c1);
		int m=add(4,5);
		System.out.println(m);
	}
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}
	public static int sub(int a,int b)
	{
		int c1=a-b;
		return c1;
	}
	public static int multi(int a,int b)
	{
		int m=a*b;
		return m;
	}

}
