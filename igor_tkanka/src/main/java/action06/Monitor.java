package action06;

public class Monitor {

	public static void main(String[] args) throws InterruptedException {
		Monitor mutex = new Monitor();
		
		TreadWriter writer = new TreadWriter();
		TreadCreator creator = new TreadCreator(writer);
		
		creator.start();

		writer.start();
		

		System.out.println("\t\tend");

	}

}

class TreadWriter extends Thread {

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				System.out.println("Поток 2(ThreadWriter), копирует nameFile1 в nameFile2 и засыпает." + i);
			}
		}
		System.out.println("TreadWriter_end");

	}

}

class TreadCreator extends Thread {

	private static TreadWriter mutex = new TreadWriter();
	
	public TreadCreator(TreadWriter mutex){
		this.mutex=mutex;
	}
	
	@Override
	public void run() {
		synchronized (mutex) {
			try {
				mutex.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 100; i++) {
				System.out.println(
						"Поток 1(ThreadCreator), считывает строку с консоли записывает в nameFile1, будит поток 2."
								+ i);
			}
			mutex.notify();
		}
		System.out.println("TreadCreator_end");
	}

}
