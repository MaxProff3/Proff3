package ThirdWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import FirstWeek.MyHashSet;
import SecondWeek.MyHashMap;

public class TestMain {
	public static void main(String[] args) {
		Client cl1= Client.getInstance();
		Client cl2= Client.getInstance();
		Client cl3= Client.getInstance();
		Client cl4= Client.getInstance();
		Client cl5 =Client.getInstance();
		Client cl6 =Client.getInstance();
		
	
	MyHashMap<Client,Integer> map=new MyHashMap<Client,Integer>();
	HashMap<Client,Integer> map1=new HashMap<Client,Integer>();
	MyHashSet<Client> set=new MyHashSet<Client>();
	set.add(cl1);
	set.add(cl2);
	set.add(cl3);
	set.add(cl4);
	set.add(cl5);
	set.add(cl6);
	map1.put(cl1, 1);
	map1.put(cl2, 1);
	map1.put(cl3, 1);
	map1.put(cl4, 1);
	map1.put(cl5, 1);
	map1.put(cl6, 1);
	System.out.println(set.size());
	}
	


}
