package SecondWeek;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

public class MyHashMap<K, V> {
	
	private int capacity = 16;
	private MyEntry<K,V>[] table;
	private double loadFactor = 0.75;
	private int size = 0;

	public MyHashMap() {
		table = new MyEntry[capacity];
	}

	public MyHashMap(int capacity) {
		table = new MyEntry[capacity];
	}

	public MyHashMap(int capacity, double loadFactor) {
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}

	public boolean put(K key, V value) {
		if (TheKeyIsNull(key, value)) {
			return false;
		}
		
		int indexGroup = (key.hashCode() % table.length);
		//System.out.println(indexGroup);
		MyEntry pointer = table[indexGroup];
		if (pointer == null) {
			table[indexGroup] = new MyEntry(key, value, null);
			size += 1;
			return true;
		}
		if (pointer != null) {
			while (pointer.getNext() != null) {
				if (!pointer.getKey().equals(key)) {
					pointer = pointer.getNext();
				}
				if (pointer.getKey().equals(key)) {
					pointer.setKey(key);
					return false;
				}
			}
			// Если вышли из цикла, то проверяем последний элемент
			if (!pointer.getKey().equals(key)) {
				pointer.setNext(new MyEntry(key, value, null));
				size += 1;
				return true;
			}
			if (pointer.getKey().equals(key)) {
				pointer.setValue(value);
				return false;
			}

		}

		return false;
	}

	public boolean TheKeyIsNull(K key, V value) {
		if (key == null) {
			if (table[0] == null) {
				table[0] = new MyEntry(key, value, null);
				size += 1;
				return true;
			}
			if (table[0] != null) {
				MyEntry pointer = table[0];
				while (pointer.getNext() != null) {
					if (pointer.getKey() != null) {
						pointer = pointer.getNext();
					}
					if (pointer.getKey() == null) {
						pointer.setValue(value);
						return false;
					}
				}
				// Если вышли из цикла, то проверяем последний элемент
				if (pointer.getKey() != null) {
					pointer.setNext(new MyEntry(key, value, null));
					size += 1;
					return true;
				}
				if (pointer.getKey() == null) {
					pointer.setValue(value);
					return true;
				}

			}

		}
		return false;
	}

	public V get(K key) {
		if (key == null) {
			MyEntry<K, V> pointer = table[0];
			if (pointer == null) {
				return null;
			}
			while (pointer.getNext() != null) {
				if (pointer.getKey() != null) {
					pointer = pointer.getNext();
				}
				if (pointer.getKey() == null) {
					return pointer.getValue();
				}
			}

			if (pointer.getKey() != null) {
				return null;
			}
			if (pointer.getKey() == null) {
				return pointer.getValue();
			}
			HashMap<Integer,String> m=new HashMap<Integer,String>();
			
		}
		int indexGroup = (key.hashCode() % table.length);
		if (table[indexGroup] == null) {
			System.out.println("Такого элемента нету");
			return null;
		}
		if (table[indexGroup] != null) {
			MyEntry<K, V> pointer = table[indexGroup];
			while (pointer.getNext() != null) {
				if (!pointer.getKey().equals(key)) {
					pointer = pointer.getNext();
				}
				if (pointer.getKey().equals(key)) {

					return pointer.getValue();
				}
			}
			if (!pointer.getKey().equals(key)) {
				return null;
			}
			if (pointer.getKey().equals(key)) {
				return pointer.getValue();
			}
		}
		return null;
	}

	public boolean remove(K key) {
		MyEntry<K, V> curr;
		if (key == null) {
			MyEntry<K, V> pointer = table[0];

			if (pointer == null) {
				return false;
			}
			if (pointer.getKey() == null) {
				pointer = pointer.getNext();
				table[0] = pointer;
				size -= 1;
				return true;
			}
			if (pointer.getNext().getKey() == null && pointer.getNext().getNext() != null) {
				curr = pointer.getNext().getNext();
				pointer.setNext(null);
				pointer = curr;
				size -= 1;
				return true;
			}
			if (pointer.getNext().getKey() == null) {
				pointer.setNext(null);
				size -= 1;
				return true;
			}
			if (pointer.getKey() != null) {
				if (pointer.getNext() != null) {

					while (pointer.getNext().getNext() != null) {
						if (pointer.getNext().getKey() != null) {
							pointer = pointer.getNext();
						}
						if (pointer.getNext().getKey() == null) {
							pointer.setNext(null);
							pointer = pointer.getNext().getNext();
							size -= 1;
							return true;
						}
					}
				}
				if (pointer.getNext().getKey() != null) {
					System.out.println("Нет удаляемого элемента");
					return false;
				}
				if (pointer.getNext().getKey() == null) {
					pointer.setNext(null);
					size -= 1;
					return true;
				}
			}
		}
		int indexGroup = key.hashCode() % table.length;
		if (table[indexGroup] == null) {
			return false;
		}
		if (table[indexGroup] != null) {
			MyEntry<K, V> pointer = table[indexGroup];
			if (pointer.getKey().equals(key)) {
				pointer = pointer.getNext();
				table[indexGroup] = pointer;
				size -= 1;
				return true;
			}
			if (pointer.getNext().getKey().equals(key)) {
				curr = pointer.getNext().getNext();
				pointer.setNext(null);
				pointer = curr;
				size -= 1;
				return true;
			}

			while (pointer.getNext().getNext() != null) {
				if (!pointer.getNext().getKey().equals(key)) {
					pointer = pointer.getNext();
				}
				if (pointer.getNext().getKey().equals(key)) {
					curr = pointer.getNext().getNext();
					pointer.setNext(null);
					pointer = curr;
					size -= 1;
					return true;
				}
			}
			if (!pointer.getNext().getKey().equals(key)) {
				System.out.println("Нет удаляемого элемента");
				return false;
			}
			if (pointer.getNext().getKey().equals(key)) {
				pointer.setNext(null);
				size -= 1;
				return true;
			}
		}

		return false;
	}
/*
	public Set<MyEntry<K,V>> MyEntrySet(){
		Set<MyEntry<K,V>>set=new HashSet<MyEntry<K,V>>() ;
	//   MyHashMap<K, V> myMap=new MyHashMap<K,V>();
		for(int i=0;i<table.length;i++){
		
			if(table[i]==null){
			//	System.out.println("Зашло");
				continue;
			}	
			MyEntry<K,V> pointer=table[i];
			if (pointer.getNext()!=null){
			
				while(pointer.getNext()!=null){		
					set.add(pointer);
					
					pointer=pointer.getNext();
				}
			}
			set.add(pointer);
			
		}
		
		return set;
	}
*/
	
	public Set<MyHashMap<K, V>.MyEntry<K, V>> entrySet(){
		Set<MyHashMap<K, V>.MyEntry<K, V>> set = new HashSet<MyHashMap<K, V>.MyEntry<K, V>>();
		for(int i=0;i<table.length;i++){
			if(table[i]==null){
				continue;
			}
			MyEntry<K,V> pointer=table[i];
			while(pointer.getNext()!=null){
				set.add(pointer);
				pointer=pointer.getNext();
			}
			set.add(pointer);
		}
		return set;
		
	}
	
	/*
	public MyHashMap<K, V>.MyEntry<K, V>  entrySet(){
		for(int i=0;i<table.length;i++){
			if(table[i]==null){
				continue;
			}
			return table[i];
		}
		return null;
		
		
	}
	*/
	public int size() {
		return size;
	}

	public  class MyEntry<K, V> {
		private K key;
		private V value;
		private MyEntry next;

		public MyEntry(K key, V value, MyEntry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public MyEntry() {

		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public MyEntry getNext() {
			return next;
		}

		public void setNext(MyEntry next) {
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
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
			MyEntry other = (MyEntry) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

	}
	
}

