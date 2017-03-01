package javaCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListPractice {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("Madhu");
		list.add("Ravi");
		list.add("Mohan");
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(3);
		
		Iterator<Integer> itr2 = list2.iterator();
		while(itr2.hasNext()){
			System.out.println(itr2.next());
		}
		
		ListIterator<Integer> itr3 = list2.listIterator();
		while(itr3.hasPrevious()){
			System.out.println(itr3.previous());
		}
		
		}
	}

