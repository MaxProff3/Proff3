package action06;

public class SynchronizedExample {
	
	public void f() {
		synchronized (this) {
			try{
				this.wait(); //
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
	
	public void g(){
		synchronized (this) {
			this.notify(); // будет спяший поток
		}
	}

}
