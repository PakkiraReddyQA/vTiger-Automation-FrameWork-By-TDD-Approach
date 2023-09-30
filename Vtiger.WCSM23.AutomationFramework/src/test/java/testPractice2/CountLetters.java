package testPractice2;

public class CountLetters {
	public static void main(String[] args) {
		String str="pakkira";
		char chars[]=str.toCharArray();
		for(char ch='a';ch<='z';ch++)
		{
			int count =0;
			for(int i=0;i<chars.length;i++)
			{
				if(chars[i]==ch)
				count++;
			}
		if(count>0)
		{
			System.out.println(ch+"-"+count);
		}
		}
	}
}
	
	


