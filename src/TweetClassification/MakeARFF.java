package TweetClassification;

import java.io.File;
import java.io.PrintWriter;
import java.sql.ResultSet;

import App_Code.SqlConnectionClass;

public class MakeARFF 
{
  public static void main(String[] args) throws Exception 
  {
	  System.out.println("File Creation Started");
      String str;
	  PrintWriter pw=new PrintWriter(new File("TweetARffData.arff"));
      pw.println("@RELATION TweetClassificationRelation");
      //pw.println("@ATTRIBUTE TweetID NUMERIC");
      pw.println("@ATTRIBUTE isSlang {0,1}");
      pw.println("@ATTRIBUTE isCorporate {0,1}");
      pw.println("@ATTRIBUTE isDeal {0,1}");
      pw.println("@ATTRIBUTE isPrivate {0,1}");
      pw.println("@ATTRIBUTE isSports {0,1}");
      pw.println("@ATTRIBUTE isEvent {0,1}");
      pw.println("@ATTRIBUTE isCurrency {0,1}");
      pw.println("@ATTRIBUTE class_name {news,events,sports,deals,private,unclassified}");
      pw.println("");
      pw.println("");
      pw.println("@DATA");
      
      SqlConnectionClass sqlcc=new SqlConnectionClass();
      sqlcc.rst=(ResultSet)sqlcc.stmt.executeQuery("Select * from classificationtweets");
      while(sqlcc.rst.next())
      {
    	  str="";
    	  str+=/*sqlcc.rst.getLong("TweetID") + "," + */sqlcc.rst.getLong("isSlang") + "," + 
    	  	   sqlcc.rst.getLong("isCorporate") + "," + sqlcc.rst.getLong("isDeal") + "," +
    	  	   sqlcc.rst.getLong("isPrivate") + "," + sqlcc.rst.getLong("isSports") + "," + 
    	  	   sqlcc.rst.getLong("isEvent") + "," + sqlcc.rst.getLong("isCurrency") + "," +
    	  	   sqlcc.rst.getString("class_name"); 
    	  pw.println(str);
      }
      System.out.println("File Created");
      pw.close();
  }
}
