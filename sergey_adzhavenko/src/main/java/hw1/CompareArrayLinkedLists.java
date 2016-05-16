package hw1;

import java.util.ArrayList;
import java.util.LinkedList;

/*1. Сравнить ArrayList vs LinkedList с помощью механизма System.nanoTime().
Вставка случайных чисел от 1 до 10000.
 - вставка вначало( в индекс 0)
 - вставка в середину ( в индекс size()/2)
 - вставка в конец ( в индекс size())
10000 элементов
какая разница в скорости ArrayList, если в конструкторе задавать capacity 11000 или не задавать.
кто быстрее и насколько при подсчете суммы чисел из ArrayList vs LinkedList.

  long time1 = System.nanoTime();
   //
  long time2 = System.nanoTime();
  long score = time2 - time1;*/
public class CompareArrayLinkedLists {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();
		LinkedList<Integer> linked = new LinkedList<>();
		for(int i = 0; i<10000; i++){
			array.add(i);
			linked.add(i);
		}
		//вставка ArrayList в начало(в индекс 0)
		long t1 = System.nanoTime();
		for(int i = 0; i<10000; i++){
			array.set(0, (int)(Math.random()*10000));
		}
		long t2 = System.nanoTime();
		long setArrayInStart = t2 - t1;

		//вставка LinkedList в начало(в индекс 0)
		long q1 = System.nanoTime();
		for(int i = 0; i<10000; i++){
			linked.set(0, (int)(Math.random()*10000));
		}
		long q2 = System.nanoTime();
		long setLinkedInStart = q2 - q1;
		
		System.out.println("- вставка в начало(в индекс 0):");
		System.out.println("ArrayList : " + setArrayInStart);
		System.out.println("LinkedList: " + setLinkedInStart);
		
		//вставка ArrayList в середину (в индекс size()/2)
		long w1 = System.nanoTime();
		for(int i = 0; i<10000; i++){
			array.set(array.size()/2, (int)(Math.random()*10000));
		}
		long w2 = System.nanoTime();
		long setArrayInMidle = w2 - w1;
		
		//вставка LinkedList в середину (в индекс size()/2)
		long a1 = System.nanoTime();
		for(int i = 0; i<10000; i++){
			linked.set(linked.size()/2, (int)(Math.random()*10000));
		}
		long a2 = System.nanoTime();
		long setLinkedInMidle = a2 - a1;
		System.out.println();
		System.out.println("- вставка в середину (в индекс size()/2):");
		System.out.println("ArrayList : " + setArrayInMidle);
		System.out.println("LinkedList: " + setLinkedInMidle);
		
		//вставка ArrayList в конец ( в индекс size())
		long e1 = System.nanoTime();
		for(int i = 0; i<10000; i++){
			array.set(array.size()-1, (int)(Math.random()*10000));
		}
		long e2 = System.nanoTime();
		long setArrayInEnd = e2 - e1;
		
		//вставка LinkedList в конец ( в индекс size())
		long s1 = System.nanoTime();
		for(int i = 0; i<10000; i++){
			linked.set(linked.size()-1, (int)(Math.random()*10000));
		}
		long s2 = System.nanoTime();
		long setLinkedInEnd = s2 - s1;
		
		System.out.println();
		System.out.println("- вставка в конец (в индекс size()):");
		System.out.println("ArrayList : " + setArrayInEnd);
		System.out.println("LinkedList: " + setLinkedInEnd);
		
		//подсчёт суммы
		int sumA=0;
		long d1 = System.nanoTime();
		for(int i = 0; i<array.size(); i++){
			sumA = sumA + array.get(i);
		}
		long d2 = System.nanoTime();
		long arraySum = d2 - d1;
		
		int sumL=0;
		long c1 = System.nanoTime();
		for(int i = 0; i<linked.size(); i++){
			sumL = sumL + linked.get(i);
		}
		long c2 = System.nanoTime();
		long linkedSum = c2 - c1;
		
		System.out.println();
		System.out.println("- подсчёт суммы:");
		System.out.println("ArrayList : " + arraySum);
		System.out.println("LinkedList: " + linkedSum);
	}

}
