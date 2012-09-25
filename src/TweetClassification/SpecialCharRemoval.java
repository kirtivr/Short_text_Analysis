package TweetClassification;

public class SpecialCharRemoval
{
	String RemoveSpecialChars(String b)
	{
		b=b.replace('.',' ');
		b=b.replace(',',' ');
		b=b.replace(';',' ');
		b=b.replace('\"',' ');
		b=b.replace('?',' ');
		b=b.replace('>',' ');
		b=b.replace('<',' ');
		b=b.replace('#',' ');
		//b=b.replace(':',' ');
		b=b.replace('!',' ');
		b=b.replace('-', ' ');
		b=b.replace('\'', ' ');
		b=b.replaceAll("\\.{2}+", " ");
		//=b.replaceAll("\\s.\\s"," ");
		String a="";
		for(int i=0;i<b.length()-1;i++)
		{
			if(b.charAt(i)=='.' && b.charAt(i+1)==' ')
			{}
			else
			{
				a=a+b.charAt(i);
			}	
		}
		if(b.charAt(b.length()-1)!=' ')
			a=a+b.charAt(b.length()-1);
		b=a;
		b=b.replaceAll("\\s+"," ");
		return b;
	}

}
