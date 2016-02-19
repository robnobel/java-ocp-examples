package collections.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
	
	public void someNonLegacyCode(){
		List<String> list = new ArrayList<String>();
		addToTheListUsingLegacyCode(list);
	}
	
	public void addToTheListUsingLegacyCode(List myList){
		myList.add(new Integer(1));		
	}

}
