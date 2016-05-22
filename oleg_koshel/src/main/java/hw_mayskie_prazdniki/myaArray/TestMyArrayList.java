package hw_mayskie_prazdniki.myaArray;

import java.util.ArrayList;

public class TestMyArrayList {
	

	public static void main(String[] args){
		
		ArrayList<String> arr = new ArrayList(); 
		
		//arr.sort(c);
	 
		MyArrayList<String> myArray = new MyArrayList<String>();
		
		//System.out.println(myArray.size());
		//System.out.println(myArray.getFree());
		
		myArray.add("1");
		myArray.add("2");
		myArray.add("3");
		myArray.add("4");
		myArray.add("5");
		myArray.add("6");
		
		
//		myArray.add(7);
//		myArray.add(8);
//		myArray.add(9);
//		myArray.add(10);
//		myArray.add(11);
//		myArray.add(12);
//		myArray.add(13);
//		myArray.add(14);
//		myArray.add(15);
//		myArray.add(16);
		
		
		//System.out.println(myArray.size());
		

		
		
		myArray.remove(1);
		
		for (int i=1;i<=myArray.size();i++ )
		{
			
			System.out.println(myArray.get(i));
			
						
		}
		
			
		
	}
	
		

}
