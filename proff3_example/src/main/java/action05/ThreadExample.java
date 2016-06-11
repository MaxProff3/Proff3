package action05;

public class ThreadExample {
	public static void main(String[] args) {
		MyThread obj1 = new MyThread();
		MyThread obj2 = new MyThread();

		obj1.start();
		//obj2.setDaemon(true);
		obj2.start();
		System.out.println("\t\tend");
		obj2.stop();
		obj2.interrupt();
		
	} 
}

class MyThread extends Thread {
	private static ThreadExample mutex = new ThreadExample();

	@Override
	public void run() {
		synchronized (mutex) {
			for (int i = 0; i < 2000; i++) {
				if(isInterrupted()){break;}
				System.out.println(getName() + "_" + i);
			}
		}
		System.out.println(getName() + "_end");

	}
}
