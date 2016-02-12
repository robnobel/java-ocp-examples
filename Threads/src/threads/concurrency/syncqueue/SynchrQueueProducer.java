package threads.concurrency.syncqueue;

import java.util.concurrent.SynchronousQueue;

public class SynchrQueueProducer implements Runnable{

    SynchronousQueue<String> syncQueue ;
	
	public SynchrQueueProducer(SynchronousQueue<String> syncQueue) {
		this.syncQueue = syncQueue;
	}
		
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try{
				String newElement = Thread.currentThread().getName()+"-"+i;
				syncQueue.put(newElement);
				System.out.println("Added an element to queue : " + newElement);
			}
			catch(InterruptedException e){
				System.out.println("InterruptedException");
			}
		}
	}
}