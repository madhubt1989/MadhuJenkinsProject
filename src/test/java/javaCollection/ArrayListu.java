package javaCollection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListu {

	public static void main(String[] args) {
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("Ravi");
		lst.add("Madhu");
		lst.add("Ram");
		
		
		Iterator<String> itr = lst.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
