package action06;

public class Synchrinized {
	private ThreadWriter tw = new ThreadWriter();
	public void  waitMy(){
		synchronized(tw){
			try {
				tw.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void nitifyMy(){
		synchronized (tw) {
			tw.notify();
			
		}
	}
}
