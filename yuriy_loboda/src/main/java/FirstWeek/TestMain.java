package FirstWeek;

import java.util.ArrayList;
import java.util.Comparator;

public class TestMain {

	public static void main(String[] args) {
		MyArrayList<Integer>list=new MyArrayList<Integer>();
		MyArrayList<User>list1=new MyArrayList<User>();
		list.add(10);
		list.add(5);
		list.add(10);
		list.add(5);
		list.add(10);
		list.add(6);
		list.add(10);
		list.add(5);
		list.add(10);
		list.add(6);
		list.add(7);
		
		User user=new User("yuriy","123");
		User user1=new User("yuriy1","123");
		list1.add(user);
		list1.add(user1);
		System.out.println(list1.size());
	    System.out.println(list1.get(0));
	    int h=Math.abs(list.hashCode()%1);
	   // System.out.println(h);
	    /*
	    MyHashSet<Integer> set=new MyHashSet<Integer>();
	   // Node n=new Node(null,7);
	  //  System.out.println(n.getValue());
	    set.add(6);
	    set.add(12);
	    set.add(6);
	    set.add(12);
	    System.out.println(set.size());
	    
	    set.contains(6);
	    set.contains(9);
	  //  System.out.println(set.size());
	  //  set.add(8);
	//    System.out.println(set.size());
		/*for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			
		}
		*/
	//MyCalc mC= new MyCalc();
	
	}

}
