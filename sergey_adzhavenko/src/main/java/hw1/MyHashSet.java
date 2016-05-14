package hw1;

public class MyHashSet<T> {

	private Node<T>[] arr;
	private int size = 0;
	private int capacity=16;
	
	@SuppressWarnings("unchecked")
	public MyHashSet(){arr = new Node[capacity];}
	
	public boolean add(T data){
		if(contains(data)) return false;
		if(size+1>capacity*5) rebuild();
		size++;
		int n = Math.abs(data.hashCode())%capacity;
		if(arr[n]==null){
			arr[n]=new Node<T>(data);	
			return true;
		}
		Node<T> current=arr[n];
	
		while(current.next!=null)current=current.next;
		current.next=new Node<T>(data);
		return true;	
	}

	@SuppressWarnings("unchecked")
	private void rebuild(){
		capacity=capacity*2;
		Node<T>[] temp = new Node[capacity];
		for(int i=0;i<arr.length;i++)temp[i]=arr[i];
		arr=temp;
	}
	
	public boolean contains(T data){
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){
				if(arr[i].value.hashCode()==data.hashCode() || arr[i].value.equals(data)){
					return true;
				}
			Node<T> current = arr[i];
			while(current.next!=null){
				if(current.value.hashCode()==data.hashCode() || current.value.equals(data)){
					return true;
				}
				current=current.next;
			}
			}
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	
	@SuppressWarnings("hiding")
	class Node<T> {
		Node<T> next;
		T value;	
		public Node(T value){
			this.value = value;
		}
	}
}
