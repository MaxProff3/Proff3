package SecondWeek;



import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import SecondWeek.MyHashMap;

public class MyHashMapTest {
MyHashMap<Integer,Integer> map;


@Before
public void init(){
	map=new MyHashMap<>();
}
@Test
public void testPut(){
	map.put(4, 1);
	map.put(2, 3);
	assertEquals(2, map.size());
}
@Test
public void testPutWithSameKey(){
	map.put(null, 2);
	map.put(null, 4);
	map.put(4,3);
	map.put(4,5);
	assertEquals(2,map.size());
}
@Test
public void testGet(){
	map.put(null, 2);
	map.put(null, 4);
	map.put(4,3);
	map.put(4,5);
	int v=map.get(null);
	assertEquals(4, v);
}
@Test
public void testGet1(){
	map.put(null, 2);
	map.put(null, 4);
	map.put(4,3);
	map.put(4,5);
	int v=map.get(4);
	//assertEquals(5,map.get(4)); почему нельзя так передать ?
	assertEquals(5,v);
	
}
@Test
public void testProvod(){
	HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
	
	map.put(12,4);
	map.put(4,3);
	map.put(4,5);
	
	map.put(5,2);
	map.put(33,4);
	map.put(6,3);
	map.put(7,5);
	
	map.put(11,2);
	map.put(99,4);
	map.put(4,3);
	map.put(4,5);
	
	
	
	map1.put(12, 4);
	map1.put(4,3);
	map1.put(4,5);
	
	map1.put(5,2);
	map1.put(33,4);
	map1.put(6,3);
	map1.put(7,5);
	
	map1.put(11, 2);
	map1.put(99, 4);
	map1.put(4,3);
	map1.put(4,5);
	
	Iterator<Map.Entry<Integer, Integer>> itr=map1.entrySet().iterator();
	Iterator<MyHashMap<Integer, Integer>.MyEntry<Integer, Integer>> itr1=map.entrySet().iterator();
	while(itr1.hasNext()==true){
		System.out.println("Моя - "+itr1.next().getKey()+" Натуральная - "+itr.next().getKey());
		assertEquals(itr1.next().getKey(), itr.next().getKey());
	}
}
	
	

}
