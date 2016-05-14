package FirstWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class MyArrayList<T> {
	private int size=0;
	private int capacity=10;
	private T[] elements;
	private int index;
	private T[] temp;
	 MyArrayList(int capacity) {
		elements =  (T[]) new Object[capacity];
	}
	 public MyArrayList() {
		elements=(T[]) new Object[capacity];
		//temp= new Object[capacity];
	}
	 
	public void add(T value){
		if(size<capacity){
			elements[size]=value;
			size+=1;
		}
		if(size==capacity){
			capacity= capacity+10;
			Object[] newElements=new Object[capacity];
			for(int i=0;i<size;i++){
				newElements[i]=elements[i];
			}
			newElements[size]=value;
			elements=(T[]) new Object[capacity];
			for(int i=0;i<=size;i++){
				elements[i]=(T) newElements[i];	
			}
		
			//size+=1;
		}
			
	}
	public int size(){
		return size;
	}
	
	public Object get(int index){
		return elements[index];
		
	}
	public <T> T[] toArray(){
		T[] array=(T[]) new Object[size];
		for(int i=0;i<size;i++){
			array[i]=(T) elements[i];
		}
		return array;
	}
	
	public void sort(Comparator<T> c){
		Arrays.sort(elements,c);
	}
	public void sort(T [] elements,Comparator<T>c){
		c.compare(elements[index],elements[index+1]);
		
	}
	
	public void ForEach (T el,Consumer<T> consumer){
		consumer.accept(el);
				}
	
	/*
	public <T> T[]()
	
	*/
		
}
	

	


	