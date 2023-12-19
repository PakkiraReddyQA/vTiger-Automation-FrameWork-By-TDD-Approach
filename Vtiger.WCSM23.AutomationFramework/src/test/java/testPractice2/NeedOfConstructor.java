package testPractice2;

import org.testng.annotations.Test;

public class NeedOfConstructor {
	String[] s;
	Object[] s1;
	
	NeedOfConstructor(String s[])
	{
		this.s=s;
	}
	
	
	
	NeedOfConstructor(Object s1[])
	{
		this.s1=s1;
	}
	
@Test
void needOfConst()
{
	
		NeedOfConstructor[] n1=new NeedOfConstructor[] 
				{(new NeedOfConstructor(new String[]{"chandu","lb"})),
				new NeedOfConstructor (new String[]{"sapp","jublie"}),
				new NeedOfConstructor (new String[]{"veera","kl","jujju","samosa",})
				};
		for (NeedOfConstructor n : n1) {
            System.out.println("Values in n1:");
            for (String value : n.s) {
                System.out.println(value);
            }
        }	
	}
@Test
void diffdataTypes()
{
NeedOfConstructor[] n2=new NeedOfConstructor[]
		{new NeedOfConstructor (new Object[] {45,85,"Ram","veera"}),
		new NeedOfConstructor (new Object[] {45,7,"veera","veera","yyy"}),
		new NeedOfConstructor (new Object[] {45,85,"Ram"}),
		new NeedOfConstructor (new Object[] {45,85})
				};
for (NeedOfConstructor n : n2) {
System.out.println("Values in:");
for (Object value : n.s1) {
    System.out.println(value);
 }
}
 }
}



