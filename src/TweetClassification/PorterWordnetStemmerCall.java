package TweetClassification;
import java.io.IOException;
import java.util.Scanner;
@SuppressWarnings("all")
public class PorterWordnetStemmerCall
{
	public String PorterWordnetStemmerCall1(String from,String to) throws IOException
	   {
	      char[] w = new char[501];
	      String v="";
	      //String str;
	      //System.out.println("Enter the file name to apply Potter Algorithm : ");
	      //Scanner input=new Scanner(System.in);
	      //str=input.nextLine();
	      PorterWordnetStemmer s = new PorterWordnetStemmer(to);
	      System.setProperty("wordnet.database.dir", "C:\\Program Files\\WordNet\\2.1\\dict");
	     
	      //for (int i = 0; i < args.length; i++)
	      
	      
	    	  Scanner sc=new Scanner(from);
	  		 
	    	  //PrintWriter pw=new PrintWriter(new FileWriter(to));
	 		
	         while(sc.hasNext())
	 		  {
	 			  String u,t;
	 			  u=sc.next();
	 			  u=u.toLowerCase();
	 			  //System.out.print(u+" ");
	 			  //s.add(u,u.length());
	 			  if((u.length()>4) &&((u.substring(0,4)=="http")||(u.substring(0,4)=="www.")))
	 			  {	   
	 				  //System.out.print(u+"hihihihi ");
	 				  //pw.println(u);
	 			  
	 			  }
	 			  for(int i=0;i<u.length();i++)
	 				  s.add(u.charAt(i));
	 			  t=s.stem();
	 			  if(t.length()>0)
	 				  v=v+" "+t;
	 			  else
	 				  v=v+" "+u;
	                /* and now, to test toString() : */
	             //u = s.toString();
	             //u=u.replaceAll("\\s", "");
	             //System.out.println(u);
	             /* to test getResultBuffer(), getResultLength() : */
	              /* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */
	             //pw.println(u);
	             //System.out.println(u);
	 		  }
	        
	         
	         //pw.close();
	      
	      
	      return v;
	   }
}
