package action06;

public class WaitNotifyExample {
	public static void main(String[] args) {
		MyThread obj1 = new MyThread();
		obj1.start();
		
		MyThread obj2 = new MyThread();
		obj2.start();		
	}
}
class MyThread implements Runnable{
	private static Object mutex = new Object();
	private Thread thread;
	public MyThread(){
		thread = new Thread(this);
	}
	public void run(){
		int k =0;
		synchronized(mutex){
			try {
				mutex.wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(true)System.out.println(thread.getName()+"_"+(k++));
		}
	}
	
	public void start(){
		thread.start();
	}
}
