package FirstWeek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;



public class Compare {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(1100);
		LinkedList<Integer> list = new LinkedList<Integer>();
		array.ensureCapacity(11000);
		
		
		//1 ������� �������( � ������ 0)
		/*
	    long timeArraylist=InHeadArray(array);
	    long timeLinkedList=InHeadList(list);
		System.out.println("ArrayList insert in head :    "+timeArraylist);
		System.out.println("LinkedList insert in head :   "+timeLinkedList);
		//LinkedList ��������� ������ � ������ ������ ����������� �������
		//���� ������ capacity = 11000, �� ��������� ������������� ������� �� ���������
		System.out.println(Compare(timeArraylist,timeLinkedList));
		*/
		//2 ������� � �������� ( � ������ size()/2)
		
		long timeArraylistM=InMiddleArray(array);
	    long timeLinkedListM=InMiddleList(list);
		System.out.println("ArrayList insert in head :    "+timeArraylistM);
		System.out.println("LinkedList insert in head :   "+timeLinkedListM);
		//ArrayList ��������� ������ � �������� ������ ����������� �������
		System.out.println(Compare(timeArraylistM,timeLinkedListM));
		
		//3 ������� � ����� ( � ������ size())
		/*
		long timeArraylistL=InLastArray(array);
	    long timeLinkedListL=InLastList(list);
		System.out.println("ArrayList insert in head :    "+timeArraylistL);
		System.out.println("LinkedList insert in head :   "+timeLinkedListL);
		//LinkedList ��������� ������ � ����� ������ ������������� �������
		//���� ������ capacity = 11000, ��������� ������� ������� �� �������� .
		System.out.println(Compare(timeArraylistL,timeLinkedListL));
		*/
		//5 ��� ������� � ��������� ��� �������� ����� ����� �� ArrayList vs LinkedList.
		/*
			InHeadArray(array);
		    InHeadList(list);
		   long timeSumArray = SumArray(array);
		   long timeSumList=SumList(list);
		    System.out.println("ArrayList Sum:    "+timeSumArray);
			System.out.println("LinkedList   :   "+timeSumList);
			//ArrayList ����������� ������� ������� ����� ���� ��������� �������� ���������� �� 42 �� 82 ���
		   System.out.println(CompareSum(timeSumArray,timeSumList));
		*/
		
	}
	
	public static String CompareSum(long array,long list){
		long result;
		if(array<list){
			result=list/array;
			return "ArrayList  � "+ result+" ���(�) �������";
		}
		if(list<array){
			result=array/list;
			return "LinkedList  � "+ result+" ���(�) �������";
		}
		return "������������";
	}


	public static String Compare(long array,long list){
		long result;
		if(array<list){
			result = list-array;
			return "ArrayList  �� "+ result+" ���������� �������";
		}
		if (list<array){
			result=array-list;
			return "LinkedList �� "+ result+" ���������� �������";
		}
		if(list==array){
			return "��� �����";
		}
		return "��� ������";
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
