package action05;

public class ThreadExample {
	public static void main(String[] args) {
		MyThread obj1 = new MyThread();
		MyThread obj2 = new MyThread();
		
		obj1.start();
		obj2.start();

		
		System.out.println("End");	
	}
}
class MyThread  extends Thread{
	@Override
	public void run(){
		
	}
}

class MyThread1 implements Runnable{ //

	@Override
	public void run() {
		
		
	}
	
}
