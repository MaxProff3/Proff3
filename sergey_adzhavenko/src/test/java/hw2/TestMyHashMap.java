package hw2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestMyHashMap {

	@Test
	public void test() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(3, "value3");
		map.put(12, "value12");
		map.put(5, "value5");
		map.put(66, "value66");
		map.put(66, "ertertert");
		map.put(-23, "value-23");
		map.put(9999, "value9999");
		map.put(800000, "value800000");
		map.put(0, "value0");
		map.put(467, "value467");
		map.put(444, "value444");
		
		MyHashMap<Integer,String> myMap = new MyHashMap<>();
		myMap.put(3, "value3");
		myMap.put(12, "value12");
		myMap.put(5, "value5");
		myMap.put(66, "value66");
		myMap.put(66, "ertertert");
		myMap.put(-23, "value-23");
		myMap.put(9999, "value9999");
		myMap.put(800000, "value800000");
		myMap.put(0, "value0");
		myMap.put(467, "value467");
		myMap.put(444, "value444");
		
		String s1 = map.entrySet().toString();
		String s2 = myMap.entrySet().toString();
		if(!s1.equals(s2))fail("Not equals!");
		
	}

}
