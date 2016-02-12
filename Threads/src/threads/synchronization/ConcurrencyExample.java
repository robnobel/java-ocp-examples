package threads.synchronization;

public class ConcurrencyExample {

	public static void main(String[] args) {
		ConcurrencyExample concExample = new ConcurrencyExample();
		concExample.sharingNonThreadsafeResource();
		//concExample.sharingThreadsafeResource();
	}
	
	private void sharingNonThreadsafeResource(){
		//Runnable with resource (not thread safe)
		SharedResource rsc = new SharedResource();
		Thread t1 = new Thread(rsc, "Thread A");
		t1.start();
		Thread t2 = new Thread(rsc, "Thread B");
		t2.start();
	}
	
	private void sharingThreadsafeResource(){
		//Runnable with resource (not thread safe)
		ThreadSafeSharedResource rsc = new ThreadSafeSharedResource();
		Thread t1 = new Thread(rsc, "Thread A");
		t1.start();
		Thread t2 = new Thread(rsc, "Thread B");
		t2.start();
	}

}
