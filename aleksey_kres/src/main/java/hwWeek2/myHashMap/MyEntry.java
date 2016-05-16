package hwWeek2.myHashMap;

public class MyEntry<K, V> {
	private K key;
	private V value;	
	private MyEntry<K,V> next;
	
	
	public MyEntry<K, V> getNext() {
		return next;
	}
	public void setNext(MyEntry<K, V> next) {
		this.next = next;
	}
	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	
	
	
	

	
	

}
