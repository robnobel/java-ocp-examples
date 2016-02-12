package threads.concurreny.readwritelocks;

public class ReadWriteLocksDemo {

	public static void main(String[] args) {
		SharedResource rsc = new SharedResource();
		Thread t1 = new Thread(rsc);
        t1.start();
        Thread t2 = new Thread(rsc);
        t2.start();
        Thread t3 = new Thread(rsc);
        t3.start();
	}

}
