package App_Code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class SqlConnectionClass
{
	public Connection conn=null;
	public Statement stmt=null;
	public ResultSet rst=null;
	String url,dbName,driver,userName,password;
	
	public SqlConnectionClass() 
	{
		url = "jdbc:mysql://localhost:3306/";
	    dbName = "ttc_db";
	    driver = "com.mysql.jdbc.Driver";
	    userName = "root"; 
	    password = "virus";
	    try 
		  {
			  Class.forName(driver).newInstance();
			  conn = DriverManager.getConnection(url+dbName,userName,password);
			  stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
	}
	
	public void disposeAll()
	{
		try 
		{
			stmt.close();
			rst.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
