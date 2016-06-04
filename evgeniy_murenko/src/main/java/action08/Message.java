package action08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String text;
	private Date date = new Date();
	private String userName;

	public final static SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy hh:mm");


	public Message(String text, String userName) {
		this.text = text;
		this.userName = userName;
	}


	@Override
	public String toString() {
		return ">>> "+userName +" ("+ formatDate.format(date)+") "+"\n"+text;
	}


}
