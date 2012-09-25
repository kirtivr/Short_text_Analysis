package TweetClassification;

public class Tweet
{
	public String[] tweetstr;
	public long len;
	public String userID;
	public 	String userName;
	public long tweetcount;
	public long following;
	public long follower;
	public String date;
	public String time;
	public String class_name;
	public Tweet()
	{
		tweetstr = new String[70];
		len=0;
		tweetcount=0;
		follower=0;
		following=0;
		date="";
		time="";
		class_name="";
	}
}
