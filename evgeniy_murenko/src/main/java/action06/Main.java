package action06;

public class Main {

	public static void main(String[] args) {
		boolean flag = true;
		
		Monitor mon = new Monitor();

		mon.thread1.start();
		mon.thread2.start();
		//mon.thread2.setDaemon(false);
	}

}
