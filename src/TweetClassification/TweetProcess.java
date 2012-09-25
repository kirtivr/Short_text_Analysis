package TweetClassification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import App_Code.*;

public class TweetProcess
{
	public int isEvent(Tweet tw) throws SQLException
	{
		int i,count=0;
		
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		try
		{
			sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from events");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		Hashtable<String,String> ht=new Hashtable<String,String>();
		while(sqlcc.rst.next())
		{
			ht.put(sqlcc.rst.getString("term"),"yes");
		}
		

		
		//considering only 24 hr format and dd/mm/yyyy or dd/mm or dd/mm/yy dormats
		String time_regex="([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
		String date_regex1="(0[1-9]|[1-9]|[12][0-9]|3[01])[/-](0[1-9]|1[012]|[1-9])([/-](18|19|20)?\\d{2})?";
		String ampm="[0-9]+([Aa][Mm]|[Pp][Mm])";
		for(i=0;i<tw.len;i++)		
			if( tw.tweetstr[i].matches(time_regex) || tw.tweetstr[i].matches(date_regex1) || tw.tweetstr[i].matches(ampm))
				count++;
						
			for(i=0;i<tw.len;i++)
				if(ht.get(tw.tweetstr[i])!=null)
					count+=1;
		return count;
	}
	
	public int isCurrency(Tweet tw)
	{
		int i,count=0;
		//String currency[] = {"$","Rupee","Rupees","Rs","Re"};
		for(i=0;i<tw.len-1;i++)
			if(tw.tweetstr[i].matches("([$]|([Rr]s)|([Rr]e)|([Rr]upees)|([Rr]upee))\\d+(.\\d)?\\d*") || (tw.tweetstr[i].matches("([$]|([Rr]s)|([Rr]e)|([Rr]upees)|([Rr]upee))") && tw.tweetstr[i+1].matches("\\d+(.\\d)?\\d*")))
				count++;				
		
		return count;
	}
	
	public int isPrivate(Tweet tw)
	{
		int i,count=0;
		for(i=0;i<tw.len;i++)
			if(tw.tweetstr[i].matches("@[a-zA-Z0-9_].*"))
				count++;
			else if( tw.tweetstr[i].matches(".*@.*") && !tw.tweetstr[i].matches("[A-Z0-9._%-]+@[A-Z0-9.-]+.[A-Z]{2,4}"))
				count++;
				
		
		return count;
	}

	public int isSlang(Tweet tw) throws SQLException
	{
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		try
		{
			sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from slangwords");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		Hashtable<String,String> ht=new Hashtable<String,String>();
		while(sqlcc.rst.next())
		{
			ht.put(sqlcc.rst.getString("slangw"),"yes");
		}
		
		int i,count=0;
		for(i=0;i<tw.len;i++)
			if(ht.get(tw.tweetstr[i])!=null)
				count++;
		
		return count;
		
	}
	
	public int isSports(Tweet tw) throws SQLException
	{
		int count=0;
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		try
		{
			sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from sports");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		Hashtable<String,String> ht=new Hashtable<String,String>();
		while(sqlcc.rst.next())
		{
			ht.put(sqlcc.rst.getString("term"),"yes");
		}
		
		int i;
		for(i=0;i<tw.len;i++)
			if(ht.get(tw.tweetstr[i])!=null)
				count+=1;
		
		return count;
		
	}
	
	public int isDeal(Tweet tw) throws SQLException
	{
		int count=0;
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		try
		{
			sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from deals");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		Hashtable<String,String> ht=new Hashtable<String,String>();
		while(sqlcc.rst.next())
		{
			ht.put(sqlcc.rst.getString("deals"),"yes");
		}
		
		int i;
		for(i=0;i<tw.len;i++)
			if(ht.get(tw.tweetstr[i])!=null)
				count+=1;
		
		return count;
		
	}

	public Boolean isCorporate(Tweet tw)
	{
		if(tw.follower>10000 && tw.following<500)
			return true;
		return false;
	}

}
