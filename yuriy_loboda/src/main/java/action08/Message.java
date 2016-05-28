package action08;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable{
	private String text;
	private Date date;
	private String userName;
	public final static SimpleDateFormat formatDate1 = new SimpleDateFormat("dd.MM.yyyy");
	public final static SimpleDateFormat formatTime2 = new SimpleDateFormat("hh:mm:ss");
	public Message(String userName, String text){
		date = new Date();
	}
	public void serialize(){
		// ?
	}
	public static Message deserialize(){
		// ?
		return null;
	}
}
