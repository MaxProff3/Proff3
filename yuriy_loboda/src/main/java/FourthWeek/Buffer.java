package FourthWeek;

public class Buffer {
	private Message msg=null;
	private String text="Hi";

	public synchronized  Message getMsg() throws InterruptedException {
		if(this.msg==null){
			wait();
		}
		notifyAll();
		return msg;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public  synchronized void setMsg(Message msg2) throws InterruptedException {
	  if (this.msg!=null){
		wait();
	}
	this.msg = msg2;
	notifyAll();
	}
}
