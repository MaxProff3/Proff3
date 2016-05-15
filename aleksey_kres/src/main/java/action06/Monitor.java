package action06;

public class Monitor {
	public static void main(String[] args) {
		
	}
	
	class MyThread extends Thread {
		private Monitor mutex = new Monitor();
		
		@Override
		public void run() {
		}
	}
	
}
