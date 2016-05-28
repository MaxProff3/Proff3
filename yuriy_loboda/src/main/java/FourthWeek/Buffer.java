package FourthWeek;

public class Buffer {
	private Message msg = null;

	
	
	public synchronized void put(Message msg) throws InterruptedException{
		if(msg!=null){
			this.wait();
		}
		this.msg=msg;
		this.notifyAll();
	}
	
	
	public synchronized Message get() throws InterruptedException{
		if(msg==null){
			this.wait();
		}
		Message result = this.msg;
	//	this.msg=null;
		this.notifyAll();
		return result;
		
	}

}
