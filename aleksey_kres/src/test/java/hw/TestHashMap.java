package hw;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import hwWeek2.myCalc.MyCalc;
import hwWeek2.myHashMap.*;

public class TestHashMap {
	MyHashMap<Integer, String> map = new MyHashMap<>();
	Map<Integer, String> map1 = new HashMap<>();
 	@Before
	public void init() {
		map = new MyHashMap<>();
		map1 = new HashMap<>();
	}
		
	@Test 
	public void test1() {
		map.put(1, "dog");
		map.put(2, "cat");
		map.put(3, "frog");	
		
		
		
		}
	
	@Test
	public void test2() {
		map1.put(1, "dog");
		map1.put(2, "cat");
		map1.put(3, "frog");
		
	}
	
	
}
