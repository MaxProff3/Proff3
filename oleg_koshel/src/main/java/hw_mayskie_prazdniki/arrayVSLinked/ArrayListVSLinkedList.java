package hw_mayskie_prazdniki.arrayVSLinked;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVSLinkedList {
	
public static void main(String[] args) {
		
		TestNoCapacity();
		
		System.out.println();
		
		TestNoCapacity11000();
		
		System.out.println();
		
		Sum();
		
	}
	
public static void TestNoCapacity(){
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		LinkedList<Integer> link = new LinkedList<>();
		
		int rand=0;
		
		for (int i=0;i<10000;i++){
			
			rand = (int)(Math.random()*10000);	
			
			arr.add(rand);
			link.add(rand);
			
			
		}
		
		
		long time1,time2;
		
		
	      time1 = System.nanoTime();
	      arr.add(0, rand);
	      time2 = System.nanoTime();

	      long scoreArrADD0 = time2 - time1;
	      
	      
	      
	      time1 = System.nanoTime();
	      arr.add(arr.size(), rand);
	      time2 = System.nanoTime();

	      long scoreArrADDLast = time2 - time1;
	      
	      
	      time1 = System.nanoTime();
	      arr.add(arr.size()/2, rand);
	      time2 = System.nanoTime();

	      long scoreArrADDSred = time2 - time1;
	      
	      
	      
	      
	      
	      	
	      time1 = System.nanoTime();
	      link.add(0, rand);
	      time2 = System.nanoTime();

	      long scoreLink0 = time2 - time1;
	      
	      
	      time1 = System.nanoTime();
	      link.add(link.size(), rand);
	      time2 = System.nanoTime();

	      long scoreLinkLast = time2 - time1;
	      
	      
	      time1 = System.nanoTime();
	      link.add(link.size()/2, rand);
	      time2 = System.nanoTime();

	      long scoreLinkLastSred = time2 - time1;
		
		
	      System.out.println("NoCapacity ������� � ������: ArrayList= "+scoreArrADD0+"    LinkedList= "+scoreLink0);
	      System.out.println("NoCapacity ������� � ��������: ArrayList= "+scoreArrADDSred+"    LinkedList= "+scoreLinkLastSred);
	      System.out.println("NoCapacity ������� � �����: ArrayList= "+scoreArrADDLast+"    LinkedList= "+scoreLinkLast);
		
		
	}
	
public static void TestNoCapacity11000(){
		
	ArrayList<Integer> arr = new ArrayList<>(11000);
	
	LinkedList<Integer> link = new LinkedList<>();
	
	int rand=0;
	
	for (int i=0;i<10000;i++){
		
		rand = (int)(Math.random()*10000);	
		
		arr.add(rand);
		link.add(rand);
		
		
	}
	
	
	long time1,time2;
	
	
      time1 = System.nanoTime();
      arr.add(0, rand);
      time2 = System.nanoTime();

      long scoreArrADD0 = time2 - time1;
      
      
      
      time1 = System.nanoTime();
      arr.add(arr.size(), rand);
      time2 = System.nanoTime();

      long scoreArrADDLast = time2 - time1;
      
      
      time1 = System.nanoTime();
      arr.add(arr.size()/2, rand);
      time2 = System.nanoTime();

      long scoreArrADDSred = time2 - time1;
      
      
      
      
      
      	
      time1 = System.nanoTime();
      link.add(0, rand);
      time2 = System.nanoTime();

      long scoreLink0 = time2 - time1;
      
      
      time1 = System.nanoTime();
      link.add(link.size(), rand);
      time2 = System.nanoTime();

      long scoreLinkLast = time2 - time1;
      
      
      time1 = System.nanoTime();
      link.add(link.size()/2, rand);
      time2 = System.nanoTime();

      long scoreLinkLastSred = time2 - time1;
	
	
      System.out.println("Capacity11000 ������� � ������: ArrayList= "+scoreArrADD0+"    LinkedList= "+scoreLink0);
      System.out.println("Capacity11000 ������� � ��������: ArrayList= "+scoreArrADDSred+"    LinkedList= "+scoreLinkLastSred);
      System.out.println("Capacity11000 ������� � �����: ArrayList= "+scoreArrADDLast+"    LinkedList= "+scoreLinkLast);
	
	      
	}

public static void Sum(){
	
	ArrayList<Integer> arr = new ArrayList<>(11000);
	
	LinkedList<Integer> link = new LinkedList<>();
	
	int rand=0;
	
	for (int i=0;i<10000;i++){
		
		rand = (int)(Math.random()*10000);	
		
		arr.add(rand);
		link.add(rand);
		
		
	}
	
	int sumArr=0;
	int sumLink=0;

	
	long time1,time2;
	
	
      time1 = System.nanoTime();
   
      for(int el:arr){
    	  sumArr+=el;
      }
      time2 = System.nanoTime();

      long scoreSumArr = time2 - time1;
      
      
      
      
      
      
      
      time1 = System.nanoTime();
      
      for(int el:link){
    	  sumArr+=el;
      }
      time2 = System.nanoTime();

      long scoreSumLink = time2 - time1;
      
      System.out.println("����������� ���� ��   ArrayList "+scoreSumArr+"   LinkedList "+scoreSumLink);
  
}

}
