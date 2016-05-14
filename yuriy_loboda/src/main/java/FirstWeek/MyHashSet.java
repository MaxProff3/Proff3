package FirstWeek;

import java.util.Arrays;

public class MyHashSet<T> {
	private static int size=0;
	private int capacity=128;
	Node<T>[] arr;
	
	MyHashSet(){
		arr=new Node[capacity];
	}
	
	
	public boolean add(T o){
		T value = o;
		//System.out.println(arr.length);
		int index = Math.abs(o.hashCode()%arr.length);
		for(int i=0;i<arr.length;i++){
			if(i==index){
				if(arr[i]==null){
					arr[i]=new Node(null,value);
					System.out.println("Добавлен "+ arr[i].getValue());
					size+=1;
					return true;
				}
				if(arr[i].getValue().equals(value)){
					System.out.println("Одинаковые объекты");
					return false;
				}
				
				if(arr[i].getNext()==null){
					arr[i].setNext(new Node(null,value));
					size+=1;
					return true;
				}
				if(arr[i].getNext()!=null){
					Node pointer=arr[i].getNext();
					try{
					while(pointer.getValue()!=null){
						if(pointer.getValue().equals(value)){
							return false;
							}
						if(!pointer.getValue().equals(value)){	
							pointer=pointer.getNext();	
							}
						}
					}catch(NullPointerException e){
						break;
					}
					if (pointer.getNext()==null){
						pointer.setNext(new Node(null,value));
						size+=1;
						return true;
					}
					
					}
				}
			}
		return false;
		}
	
	public boolean contains(T obj){
		int indexGr = Math.abs(obj.hashCode()%arr.length);
		if(arr[indexGr]==null){
			System.out.println("Группы с таким индексом не существует");
			return false;
		}
		if(arr[indexGr]!=null){
			Node pointer = arr[indexGr];
			
				while(pointer.getValue()!=null){
					try{
					if(pointer.getValue().equals(obj)){
						System.out.println("Объект найден");
						return true;
					}
					if(!pointer.getValue().equals(obj)){
						pointer=pointer.getNext();
					}
				}
				catch(NullPointerException e){
					break;
				}
		}		
		}
		System.out.println("Объект не найден");
		return false;
	}
	
		
		
	
	
	public int size(){
		return size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		result = prime * result + capacity;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyHashSet other = (MyHashSet) obj;
		if (!Arrays.equals(arr, other.arr))
			return false;
		if (capacity != other.capacity)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
	
	

}
