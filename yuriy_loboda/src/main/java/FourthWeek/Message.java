package FourthWeek;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String text="Hello";
	private String userName;
	private static Message msg=null;
	private User user;
	
	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Date date;

	public final static SimpleDateFormat formatDate1 = new SimpleDateFormat("dd.MM.yyyy");
	public final static SimpleDateFormat formatTime2 = new SimpleDateFormat("hh:mm:ss");
	
	public Message(String userName, String text){
		this.userName=userName;
		this.text=text;
		date = new Date();
	}

	@Override
	public String toString() {
		return "Message [text=" + text + ", userName=" + userName + "]";
	}
	
	
	
	
	
}
