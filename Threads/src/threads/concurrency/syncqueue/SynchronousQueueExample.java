package threads.concurrency.syncqueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {

	public static void main(String[] args) {
		
		SynchronousQueue<String> syncQueue = new SynchronousQueue<>();
		
		SynchrQueueProducer addRunnable = new SynchrQueueProducer(syncQueue);
		SynchrQueueConsumer removeRunnable =  new SynchrQueueConsumer(syncQueue);
		new Thread(removeRunnable).start();
		new Thread(addRunnable).start();		
		
	}

}
