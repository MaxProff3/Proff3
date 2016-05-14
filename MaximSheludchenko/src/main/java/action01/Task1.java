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
  long score = time2 - time1;
*/package action01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {
		System.out.println("ArrayList with capasity \nArrayList \nLiketList \n");
		// переменные для вставкаи в начало
		List<Integer> arrlistCap1 = new ArrayList<Integer>(10000);
		List<Integer> arrlist1 = new ArrayList<Integer>();
		List<Integer> linlist1 = new LinkedList<Integer>();
		// переменные для вставкаи в середину
		List<Integer> arrlistCap2 = new ArrayList<Integer>(10000);
		List<Integer> arrlist2 = new ArrayList<Integer>();
		List<Integer> linlist2 = new LinkedList<Integer>();
		// переменные для вставкаи в конец
		List<Integer> arrlistCap3 = new ArrayList<Integer>(10000);
		List<Integer> arrlist3 = new ArrayList<Integer>();
		List<Integer> linlist3 = new LinkedList<Integer>();
		// переменные обхода и подсчёта суммы
		List<Integer> arrlist4 = new ArrayList<Integer>();
		List<Integer> linlist4 = new LinkedList<Integer>();

		System.out.println("Вставка в начало: ");
		testTime(1, arrlistCap1);
		testTime(1, arrlist1);
		testTime(1, linlist1);
		System.out.println("Вставка в середину: ");
		testTime(2, arrlistCap2);
		testTime(2, arrlist2);
		testTime(2, linlist2);
		System.out.println("Вставка в конец: ");
		testTime(3, arrlistCap3);
		testTime(3, arrlist3);
		testTime(3, linlist3);
		
		// проверка на сумму
		System.out.println("//тест на сумму");
		// заполняем значениями
		for (int i = 0; i < 10000; i++) {
			int temp = (int)(Math.random()*10000);
			arrlist4.add(temp);
			linlist4.add(temp);
		}
		//тест для ArrayList
		int sumArr=0;
		long time1 = System.nanoTime();
		for(Integer arrlist: arrlist4 ){
			sumArr +=arrlist;
		}
		long time2 = System.nanoTime();
		long score = time2 - time1;
		System.out.println("Разница проц вермени: " + score + " Сумма ArrayList: " + sumArr);
		//тест для LinkedList
		int sumLink=0;
		long time3 = System.nanoTime();	
		for(Integer linlist: linlist4 ){
			sumLink +=linlist;
		}
		long time4 = System.nanoTime();
		long score2 = time2 - time1;
		System.out.println("Разница проц вермени: " + score2 + " Сумма LinkedList: " + sumLink);
	}

	public static void testTime(int i, List<Integer> list) {
		long time1 = System.nanoTime();
		if (i == 1) {
			index0(list);
		} else if (i == 2) {
			indexInsert(list);
		} else if (i == 3) {
			indexLast(list);
		}
		long time2 = System.nanoTime();
		long score = time2 - time1;
		System.out.println("Разница проц вермени: " + score);
	}

	public static void index0(List<Integer> list) {
		for (int i = 0; i < 10000; i++) {
			list.add(0, (int) (Math.random() * 10000));
		}
	}

	public static void indexInsert(List<Integer> list) {
		for (int i = 0; i < 10000; i++) {
			list.add(list.size() / 2, (int) (Math.random() * 10000));
		}
	}

	public static void indexLast(List<Integer> list) {
		for (int i = 0; i < 10000; i++) {
			list.add(list.size(), (int) (Math.random() * 10000));
		}
	}
}
