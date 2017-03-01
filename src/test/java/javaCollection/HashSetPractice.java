package javaCollection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetPractice {

	public static void main(String[] args) {
	
		
		HashSet<String> set = new HashSet<String>();
		set.add("Ravi");
		set.add("Madhu");
		set.add("Ram");
		set.add("Ravi");
		
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			
			System.out.println(itr.next());
		}

	}

}
