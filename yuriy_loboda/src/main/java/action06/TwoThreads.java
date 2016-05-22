package action06;

public class TwoThreads {
	public static void main(String[] args) {
		TreadCreator tc= new TreadCreator();
		ThreadWriter tw = new ThreadWriter();
		tc.start();
		tc.interrupt();
	}
	
	

	

}
