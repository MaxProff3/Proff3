package action06;

public class SynchronizedExample {
	public void f() {
		synchronized (this) {
			try {
				this.wait(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void g() {
		synchronized (this) {
			this.notify();
		}
	}
} 
