package TweetClassification;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import App_Code.SqlConnectionClass;

public class TweetAct_Str
{
	public static void main(String[] args) throws SQLException, IOException
	{
		System.out.println("Started the work");
		StringnLength o=new StringnLength();
		String TweetMod="";
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from tweets");
		while(sqlcc.rst.next())
		{
			TweetMod=sqlcc.rst.getString("TweetAct");
			SpecialCharRemoval scr =new SpecialCharRemoval();
			TweetMod=scr.RemoveSpecialChars(TweetMod);
			StopWordsDeletion swr =new StopWordsDeletion();
			o=swr.RemoveStopWords(TweetMod);
			PorterWordnetStemmerCall pot=new PorterWordnetStemmerCall();
			o.str=pot.PorterWordnetStemmerCall1(o.str,"x");
			sqlcc.rst.updateString("TweetStr", o.str);
			sqlcc.rst.updateInt("len",o.length);
			sqlcc.rst.updateRow();
		}
		System.out.println("Finished My work");
	}
}
