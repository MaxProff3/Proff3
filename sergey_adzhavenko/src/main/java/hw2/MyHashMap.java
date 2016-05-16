package hw2;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K,V> {
	
	private MyEntry<K,V>[] array;
	private int capacity = 16;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public MyHashMap(){array = new MyEntry[capacity];}

	@SuppressWarnings("unchecked")
	public MyHashMap(int ownCapacity){array = new MyEntry[ownCapacity];}
	
	public boolean put(K k, V v){
		if(isKeyExist(k,v))return true;
		if(size+1>capacity*5) rebuild();
		MyEntry<K,V> obj = new MyEntry<K,V>(k,v);
		int num = Math.abs(obj.key.hashCode())%capacity;
		if(array[num]==null){
			array[num]=obj;
			size++;
			return true;
		}
		MyEntry<K,V> current = array[num];
		while(current.next!=null){current=current.next;}
		current.next=obj;
		size++;
		return true;
	}
	
	public Set<MyEntry<K, V>> entrySet(){	
		Set<MyEntry<K, V>> set = new HashSet<>();
		for(int i=0;i<array.length;i++){
			MyEntry<K, V> each = new MyEntry<>(null,null);
			if(array[i]!=null){
				each=array[i];
				set.add(each);
				while(each.next!=null){
					each=each.next;
					if(each!=null)set.add(each);
				}
			}
		}
		return set;
	}
	
	@SuppressWarnings("unchecked")
	private void rebuild(){
		capacity=capacity*2;
		MyEntry<K,V>[] temp = (MyEntry<K,V>[]) new MyEntry[capacity];
		for(int i=0;i<array.length;i++){temp[i]=array[i];}
		array=temp;
	}
	public boolean remove(K k){
		for(int i=0;i<array.length;i++){
			if(array[i]!=null){
				MyEntry<K,V> obj = array[i];
				if(obj.key.hashCode()==k.hashCode()){
					if(obj.next==null)obj=null;
					else array[i]=obj.next;
					size--;
					return true;
				}
				MyEntry<K,V> prev = obj;
				while(obj.next!=null){
					if(obj.key.hashCode()==k.hashCode()){
						prev.next=obj.next;
						obj=null;
						size--;
						return true;
					}
					prev = obj;
					obj=obj.next;
				}
			}
		}
		return false;
	}
	private boolean isKeyExist(K k, V v){
		for(int i=0;i<array.length;i++){
			if(array[i]!=null){
				MyEntry<K,V> obj = array[i];
				if(obj.key.equals(k)){
					obj.value=v;
					return true;
				}
				while(obj.next!=null){
					if(obj.key.equals(k)){
						obj.value=v;
						return true;
					}
					obj=obj.next;
				}
			}
		}
		return false;
	}
	public V get(K k){
		for(int i=0;i<array.length;i++){
			if(array[i]!=null){
				MyEntry<K,V> obj = array[i];
				if(obj.key.hashCode()==k.hashCode())return obj.value;
				while(obj.next!=null){
					if(obj.key.hashCode()==k.hashCode())return obj.value;
					obj=obj.next;
				}
			}
		}
		return null;	
	}
	public int size(){
		return size;
	}

	@SuppressWarnings("hiding")
	class MyEntry<K,V> {
		K key;
		V value;
		MyEntry<K,V> next;
		
		@Override
		public String toString() {
			return key + "=" + value;
		}

		public MyEntry(K key,V value){
			this.key = key;
			this.value = value;
		}
	}
}
