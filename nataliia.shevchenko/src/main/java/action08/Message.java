package action08;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
	private String text;
	private Date date;
	private Date time;
	private String userName;
	public final static SimpleDateFormat formatDate1 = new SimpleDateFormat("dd.yy.mm");
	public final static SimpleDateFormat formatDate2 = new SimpleDateFormat("hh:mm:ss");

	public Message(String userName, String text) {
		date = new Date();
	}

	public void serialize() {
		//???

	}

	public static Message deserialize() {
		//possible it would not be here, that's we should decided where exactly it should be
		//??
		return null;

	}

}
