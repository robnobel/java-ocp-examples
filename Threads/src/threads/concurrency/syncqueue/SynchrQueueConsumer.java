package threads.concurrency.syncqueue;

import java.util.concurrent.SynchronousQueue;

public class SynchrQueueConsumer implements Runnable {

	SynchronousQueue<String> syncQueue ;
	
	public SynchrQueueConsumer(SynchronousQueue<String> syncQueue) {
		this.syncQueue = syncQueue;
	}
		
	@Override
	public void run(){
		for(int i=0;i<50;i++){
			String element;
			try {
				element = syncQueue.take();
				if(element!=null){
					System.out.println("Removed an element to queue : " + element);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}

