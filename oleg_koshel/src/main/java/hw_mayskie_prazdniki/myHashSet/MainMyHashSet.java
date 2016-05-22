package hw_mayskie_prazdniki.myHashSet;

import hw_mayskie_prazdniki.myHashSet.MyHashSet.Node;

public class MainMyHashSet {
	
	
	public static void main(String[] args) {
		
		
		MyHashSet<String> myHash = new MyHashSet<String>();

		String str = new String("1"); 
		
		myHash.add(str);
		//myHash.add(3);
		
		
		
		
//		System.out.println(myHash.size());
		
		System.out.println(myHash.contains(str));
		//System.out.println(myHash.contains(5));
		
		
		
	}
	

}
