package threads.concurrency.readwritelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource implements Runnable{

	List<String> resources= new ArrayList<>();
	private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
	

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			addResource();
			readResource();			
		}
	}
		
	
	public void addResource(){
		rwlock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() +  " adds a resource.. \t Total nr threads writing: "+
                                rwlock.getWriteHoldCount());
		resources.add(Thread.currentThread().getName() );
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
		rwlock.writeLock().unlock();
	}
	
	public void readResource(){
		Lock readLock = rwlock.readLock();
		readLock.lock();
		System.out.println(Thread.currentThread().getName() + " reading.. \tTotal nr of threads reading: "+
		                         rwlock.getReadLockCount());
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
		readLock.unlock(); 
	}
	

	
}
