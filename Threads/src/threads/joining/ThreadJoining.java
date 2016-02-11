package threads.joining;


public class ThreadJoining {

	public static void main(String[] args) {
		ThreadJoining threadJoining = new ThreadJoining();
		threadJoining.joiningTwoThreads();
	}
	
	/**
	 * starts two threads, where the first thread joins the currently executing thread
	 * i.e. the Main-thread
	 */
	private void joiningTwoThreads(){
		CounterRunnable cr = new CounterRunnable();
		Thread thread1 = new Thread(cr, "First thread");
		Thread thread2 = new Thread(cr, "Second thread");
		thread1.start();
		try {
			thread1.join();                                 //beware ! throws InterruptedException
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();  
	}
	
	/**
	 * nested static class implementing Runnable
	 */
	private class CounterRunnable implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<=10;i++){
				System.out.println(Thread.currentThread().getName() 
						+ " is at value "+i);
			}
		}		
	}

}

