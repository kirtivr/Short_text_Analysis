package TweetClassification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import App_Code.SqlConnectionClass;

public class FeatureExtract
{
	public static void main(String[] args) throws SQLException
	{
		System.out.println("Started the work");
		int i=0;
		String a="",classname="";
		int isCorporate,isCurrency,isDeal,isEvent,isSports,isSlang,isPrivate,tid;
		
		Tweet tw=new Tweet();
		TweetProcess tp=new TweetProcess();
		SqlConnectionClass sqlcc=new SqlConnectionClass();
		SqlConnectionClass sqlcins=new SqlConnectionClass();
		sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from tweets");
		while(sqlcc.rst.next())
		{
			tid=sqlcc.rst.getInt("TweetID");
			classname=sqlcc.rst.getString("class_name");
			i=0;isCorporate=0;isCurrency=0;isDeal=0;isEvent=0;isSports=0;isSlang=0;isPrivate=0;
			a=sqlcc.rst.getString("TweetStr");
			Scanner sc=new Scanner(a);
			while(sc.hasNext())
			{
				tw.tweetstr[i++]=sc.next();
			}
			tw.len=sqlcc.rst.getInt("len");
			tw.follower=sqlcc.rst.getLong("follower");
			tw.following=sqlcc.rst.getLong("following");
			if(tp.isCorporate(tw))
				isCorporate=1;
			if(tp.isCurrency(tw)>0)
				isCurrency=1;
			if(tp.isDeal(tw)>0)
				isDeal=1;
			if(tp.isEvent(tw)>0)
				isEvent=1;
			if(tp.isPrivate(tw)>0)
				isPrivate=1;
			if(tp.isSlang(tw)>0)
				isSlang=1;
			if(tp.isSports(tw)>0)
				isSports=1;
			sqlcins.stmt.executeUpdate("insert into classificationtweets values(" + tid + "," + isSlang
					+ "," + isCorporate + "," + isDeal + "," +isPrivate + "," + isSports + "," +
					isEvent + "," + isCurrency + ",'" + classname + "')");
					
			sc.close();
		}
		System.out.println("Finished My work");
	}

}

