package threads.synchronization;

import java.util.ArrayList;
import java.util.List;

public class SharedResource implements Runnable{

	List<String> resources= new ArrayList<>();
		
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			if(!maxNrOfResourcesReached()){
				sleepForAWhile();
				resources.add(Thread.currentThread().getName());
				System.out.println("Number of resources :" + resources.size() +
						              (resources.size()>5 ? "\t Oops!!!" : ""));
			}
			else{
				sleepForAWhile();
				resources.remove(0);
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished.");
	}
	
	private boolean maxNrOfResourcesReached(){
		if(resources.size()>=5){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void sleepForAWhile(){
		try{
			Thread.sleep(1000);     //using multiple threads and no locking, this could get nasty
		}
		catch(InterruptedException ie){	}
	}

}
