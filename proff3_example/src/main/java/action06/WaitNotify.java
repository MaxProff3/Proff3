package action06;

public class WaitNotify {
	public void f(){
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void g(){
		synchronized (this) {
			this.notify();
		}
	}
}
