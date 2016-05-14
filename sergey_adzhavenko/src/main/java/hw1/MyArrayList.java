package hw1;

import java.util.Comparator;
import java.util.function.Consumer;

public class MyArrayList<T> {
	
	private T[] arr;
	private int size = 0;
	private int capacity=10;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {	
		arr = (T[]) new Object[capacity];
	}
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
		this.capacity=capacity;
		arr = (T[]) new Object[capacity];
	}

	public void add(T value){
		if(size+1>arr.length) rebuild();
		arr[size]=value;
		size++;
	}
	public void add(int index, T value){
		if(size+1>arr.length) rebuild();
		int i = index;
		while(arr[i]!=null){
			T memory = arr[i];
			arr[i]=value;
			value=memory;
			i++;
		}
		arr[i]=value;
		size++;
	}
	
	private void rebuild(){
		capacity=(capacity*3)/2;
		@SuppressWarnings("unchecked")
		T[] newArr=(T[]) new Object[capacity];
		for(int i=0;i<arr.length;i++)newArr[i]=arr[i];
		arr=newArr;
	}
	
	public T get(int index){return arr[index];	}
	
	public int size(){return size;}
	
	public T[] toArray(T[] array){
		int length=array.length<size ? array.length : size;
		for(int i=0;i<length;i++)array[i]=arr[i];
		return array;
	}
	
	public void forEach(Consumer<? super T> action) {
		for(int i=0;i<size;i++)action.accept(arr[i]);      
	}
	
	public void sort(Comparator<? super T> c){
		T min;
		for(int i=0;i<size;i++){
			for(int k=0;k<size;k++){
				int result = c.compare(arr[k], arr[i]);
				if(result>0){
					min=arr[k];
					T y=arr[i];
					arr[i]=min;
					arr[k]=y;
				}
			}
		}
	}
}

