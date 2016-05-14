package SecondWeek;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import SecondWeek.MyHashMap.MyEntry;

public class Test {

	public static void main(String[] args) {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer,Integer>();

		// map.put(null, 8);
		map.put(17,2);
		map.put(33,4);
		map.put(49,3);
		map.put(65,5);
		map.put(20, 20);
		/*
		 * 
		map.put(5,2);
		map.put(33,4);
		map.put(6,3);
		map.put(7,5);
		
		map.put(11,2);
		map.put(99,4);
		map.put(103,3);
		map.put(4,5);
	*/
		HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
	//MyEntry<String,String> myEn=new MyEntry<String,String>();
		
		/*
		map1.put(5,2);
		map1.put(33,4);
		map1.put(6,3);
		map1.put(7,5);
		
		map1.put(11,2);
		map1.put(99,4);
		map1.put(103,3);
		map1.put(4,5);
		
		*/
		Integer a=5;
		int b=a.hashCode()%16;
		
		Integer c=99;
		int d=c.hashCode()%16;
		System.out.println(b+" = "+d);
/*
	Iterator<Map.Entry<Integer, Integer>> iter=map1.entrySet().iterator();
	Iterator<MyHashMap<Integer, Integer>.MyEntry<Integer, Integer>> iter1=map.entrySet().iterator();
	//while(iter1.hasNext()!=null)
	*/
	for(MyHashMap<Integer, Integer>.MyEntry<Integer, Integer> en : map.entrySet()){
		System.out.println(en.getKey()+" - "+en.getValue());

	}

}
}
