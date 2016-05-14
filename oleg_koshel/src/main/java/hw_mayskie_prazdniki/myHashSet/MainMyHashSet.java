package hw_mayskie_prazdniki.myHashSet;

import hw_mayskie_prazdniki.myHashSet.MyHashSet.Node;

public class MainMyHashSet {
	
	
	public static void main(String[] args) {
		
		
		MyHashSet<Test> myHash = new MyHashSet<Test>();

		Test str = new Test(); 
		
		myHash.add(str);
		//myHash.add(3);
		
		
		
		
//		System.out.println(myHash.size());
		
		System.out.println(myHash.contains(str));
		//System.out.println(myHash.contains(5));
		
		
		
	}
	

}
