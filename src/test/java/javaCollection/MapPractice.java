package javaCollection;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

	public static void main(String[] args) {


		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100,"Madhu");
		map.put(99, "Ravi");
		
		for(Map.Entry m:map.entrySet()){
			
			System.out.println(m.getKey()+" "+m.getValue());
		}

	}

}
