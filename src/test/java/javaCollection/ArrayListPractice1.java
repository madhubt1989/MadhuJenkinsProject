package javaCollection;

import java.util.ArrayList;

public class ArrayListPractice1 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Madhu");
		list.add("Ravi");
		list.add("Ram");
		list.remove("Ram");
		list.add("Ravi");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list.add("Hrishi");
		list.add("Madhu");
		list.addAll(list2);
		for(String lst:list){
			System.out.println(lst);
		}

	}

}
