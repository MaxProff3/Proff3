package hwWeek2.myHashMap;

interface Map<K,V> {
	
	boolean put ( K key, V value);
	V get (K key);
	int size();
	boolean remove(K key);
	MyEntry<K, V> entrySet();
	
	
		
	

}
