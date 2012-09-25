package TweetClassification;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import App_Code.SqlConnectionClass;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelToDB
{
	public static void main(String[] args) throws SQLException, IOException, BiffException
	{
		System.out.println("Started Today Now ...");
		//new slanginsertion2("slang.txt");
		//new sportsinsertion("sports.txt");
		//new Dealwords("deal.txt");
		//new ExcelData();
		SqlConnectionClass sqlcc = new SqlConnectionClass();
		Workbook workbook = Workbook.getWorkbook(new File("twitterclassification_Train.xls")); 
		Sheet sheet = workbook.getSheet(0); 
		for(int i=1;i<30;i++)
		{
			Cell a1 = sheet.getCell(0,i);
			Cell a2 = sheet.getCell(1,i);
			Cell a3 = sheet.getCell(2,i);
			Cell a4 = sheet.getCell(3,i);
			Cell a5 = sheet.getCell(4,i);
			Cell a6 = sheet.getCell(5,i);
			Cell a7 = sheet.getCell(6,i);
			Cell a8 = sheet.getCell(7,i);
			Cell a9 = sheet.getCell(8,i);
			
			String stringa1 = a1.getContents();
			String stringa2 = a2.getContents();
			String stringa3 = a3.getContents(); 
			String stringa4 = a4.getContents();
			String stringa5 = a5.getContents();
			String stringa6 = a6.getContents(); 
			String stringa7 = a7.getContents();
			String stringa8 = a8.getContents(); 
			String stringa9 = a9.getContents(); 
			stringa3=stringa3.substring(1,stringa3.length());
			long a,b,c;
			//double e;
			a=(long)Double.parseDouble(stringa4);
			b=(long)Double.parseDouble(stringa5);
			c=(long)Double.parseDouble(stringa6);
			
			sqlcc.stmt.executeUpdate("insert into testing_tweets values("+(i)+",'"+stringa1+"','xxx',1,'"+stringa3+"','"+stringa2+"',"+a+",'"+stringa8+"','"+stringa7+"',"+b+","+c+",'"+stringa9+"')");
		}
			
		
		System.out.println("Ended Today Now ...");
	}
}
