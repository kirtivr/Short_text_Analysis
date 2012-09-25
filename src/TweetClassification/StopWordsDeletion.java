package TweetClassification;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Scanner;

import App_Code.SqlConnectionClass;


public class StopWordsDeletion
{
	StringnLength RemoveStopWords(String from) throws SQLException
	{
		StringnLength obj=new StringnLength();
		obj.str="";
		obj.length=0;
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from stopwords");
		Hashtable<String, String> ht=new Hashtable<String, String>();
		
		while(sqlcc.rst.next())
		{
			ht.put(sqlcc.rst.getString("stopwordsID"), "1");
		}
		
		Scanner sc=new Scanner(from);
		while(sc.hasNext())
		{
			String a=sc.next();
			if(ht.get(a)==null)
			{
				obj.str+= a + " ";
				obj.length++;
			}
		}
		sqlcc.disposeAll();
		sc.close();
		ht.clear();
		return obj;
	}

}
