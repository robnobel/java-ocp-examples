package ocp.threads.concurrency.readwritelocks;

import java.util.concurrent.locks.ReentrantLock;

public class LockingBehavior {
	
	public static void main(String[] args){
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
		lock.unlock();
		lock.unlock();
		lock.unlock();  // nr locks gets below zero > IllegalMonitorStateException
	}

}
