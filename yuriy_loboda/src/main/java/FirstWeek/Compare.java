package FirstWeek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;



public class Compare {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(1100);
		LinkedList<Integer> list = new LinkedList<Integer>();
		array.ensureCapacity(11000);
		
		
		//1 вставка вначало( в индекс 0)
		/*
	    long timeArraylist=InHeadArray(array);
	    long timeLinkedList=InHeadList(list);
		System.out.println("ArrayList insert in head :    "+timeArraylist);
		System.out.println("LinkedList insert in head :   "+timeLinkedList);
		//LinkedList вставляет данные в начало списка значительно быстрее
		//Если задать capacity = 11000, то результат координальным образом не изменится
		System.out.println(Compare(timeArraylist,timeLinkedList));
		*/
		//2 вставка в середину ( в индекс size()/2)
		
		long timeArraylistM=InMiddleArray(array);
	    long timeLinkedListM=InMiddleList(list);
		System.out.println("ArrayList insert in head :    "+timeArraylistM);
		System.out.println("LinkedList insert in head :   "+timeLinkedListM);
		//ArrayList вставляет данные в середину списка значительно быстрее
		System.out.println(Compare(timeArraylistM,timeLinkedListM));
		
		//3 вставка в конец ( в индекс size())
		/*
		long timeArraylistL=InLastArray(array);
	    long timeLinkedListL=InLastList(list);
		System.out.println("ArrayList insert in head :    "+timeArraylistL);
		System.out.println("LinkedList insert in head :   "+timeLinkedListL);
		//LinkedList вставляет данные в конец списка незначительно быстрее
		//Если задать capacity = 11000, результат координ образом не меняется .
		System.out.println(Compare(timeArraylistL,timeLinkedListL));
		*/
		//5 кто быстрее и насколько при подсчете суммы чисел из ArrayList vs LinkedList.
		/*
			InHeadArray(array);
		    InHeadList(list);
		   long timeSumArray = SumArray(array);
		   long timeSumList=SumList(list);
		    System.out.println("ArrayList Sum:    "+timeSumArray);
			System.out.println("LinkedList   :   "+timeSumList);
			//ArrayList значительно быстрее считает сумму всех елементов значения колеблятся от 42 до 82 раз
		   System.out.println(CompareSum(timeSumArray,timeSumList));
		*/
		
	}
	
	public static String CompareSum(long array,long list){
		long result;
		if(array<list){
			result=list/array;
			return "ArrayList  в "+ result+" раз(а) быстрее";
		}
		if(list<array){
			result=array/list;
			return "LinkedList  в "+ result+" раз(а) быстрее";
		}
		return "Замечательно";
	}


	public static String Compare(long array,long list){
		long result;
		if(array<list){
			result = list-array;
			return "ArrayList  на "+ result+" наносекунд быстрее";
		}
		if (list<array){
			result=array-list;
			return "LinkedList на "+ result+" наносекунд быстрее";
		}
		if(list==array){
			return "Они равны";
		}
		return "Все хорошо";
	}
	
public static long InHeadArray(ArrayList<Integer> array){
	long time1=System.nanoTime();
	for(int i=0;i<10000;i++){
		array.add(0,i);
	}
	long time2=System.nanoTime();
	long result =time2-time1;

	return	result;
}
public static long InHeadList(LinkedList<Integer> list){
	long time1=System.nanoTime();
	for(int i=0;i<10000;i++){
		list.add(0,i);
	}
	long time2=System.nanoTime();
	long result = time2-time1;
	return result;
}
public static long InMiddleArray(ArrayList<Integer> array){
	long time1=System.nanoTime();
	for(int i=0;i<10000;i++){
		array.add(array.size()/2,i);
	}
	long time2=System.nanoTime();
	long result =time2-time1;

	return	result;
}
public static long InMiddleList(LinkedList<Integer> list){
	long time1=System.nanoTime();
	for(int i=0;i<10000;i++){
		list.add(list.size()/2,i);
	}
	long time2=System.nanoTime();
	long result = time2-time1;
	return result;
}
public static long InLastArray(ArrayList<Integer> array){
	long time1=System.nanoTime();
	for(int i=0;i<10000;i++){
		array.add(array.size(),i);
	}
	long time2=System.nanoTime();
	long result =time2-time1;

	return	result;
}
public static long InLastList(LinkedList<Integer> list){
	long time1=System.nanoTime();
	for(int i=0;i<10000;i++){
		list.add(list.size(),i);
	}
	long time2=System.nanoTime();
	long result = time2-time1;
	return result;
}

public static long SumArray(ArrayList<Integer>array){
	int sum=0;
	long time1=System.nanoTime();
	for(int i=0;i<array.size();i++){
		sum+=array.get(i);
	}
	long time2=System.nanoTime();
	long result=time2-time1;
	
	return result;
}
public static long SumList(LinkedList<Integer>list){
	int sum=0;
	long time1=System.nanoTime();
	for(int i=0;i<list.size();i++){
		sum+=list.get(i);
	}
	long time2=System.nanoTime();
	long result=time2-time1;
	
	return result;
}

	
}
