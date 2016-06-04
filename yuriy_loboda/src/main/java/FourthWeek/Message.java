package FourthWeek;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String text;
	@Override
	public String toString() {
		return "Message [text=" + text + ", date=" + date + ", userName=" + userName + "]";
	}
	private Date date;
	private String userName;
	public final static SimpleDateFormat formatDate1 = new SimpleDateFormat("dd.MM.yyyy");
	public final static SimpleDateFormat formatTime2 = new SimpleDateFormat("hh:mm:ss");
	public Message(String userName, String text){
		this.userName=userName;
		this.text=text;
		date = new Date();
	}
	
	
	
	
}
