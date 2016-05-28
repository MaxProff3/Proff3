package action06;

public class TwoThreads  {
	public static void main(String[] args) {
		ThreadCreator tc = new ThreadCreator();
		ThreadWriter tw=new ThreadWriter();
			   tc.start();
			   tw.start();
			   
	}

}
