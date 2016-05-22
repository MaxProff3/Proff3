package hwWeek2.myHashMap;

import java.util.Arrays;

public class MyHashMap<K, V> implements Map<K, V> {
	private int size = 16;
	private MyEntry[] table = new MyEntry[size];

	private int getIndex(int hash) {
		return hash & (size - 1);
	}

	@Override
	public boolean put(K key, V value) {
		int bucket = getIndex(key.hashCode());
		MyEntry<K, V> current = table[bucket];
		for (; current != null; current = current.getNext()) {

			if (current.getKey().equals(key)) {
				System.out.println("duplicate key value pair, replacing existing key " + key + ", with value " + value);
				current.setValue(value);
				return true;
			} else {
				System.out.println("Collision detected for key " + key + ", adding element to the existing bucket");
			}
		}
		System.out.println("PUT adding key:" + key + ", value:" + value + " to the list");
		MyEntry entryInOldBucket = new MyEntry(key, value);
		entryInOldBucket.setNext(table[bucket]);
		table[bucket] = entryInOldBucket;
		return true;
	}

	@Override
	public boolean remove(K key) {
		int hash = (key == null) ? 0 : key.hashCode();
		MyEntry<K, V> prev = table[hash];
		MyEntry<K, V> e = prev;
		while (e != null) {
			MyEntry<K, V> next = e.getNext();
			Object k;
			if (e.getKey().hashCode() == hash && ((k = e.getKey()) == key || (key != null && key.equals(k)))) {
				size--;
				if (prev == e) {
					table[hash] = next;
				} else {
					prev.setNext(next);
				}
				return true;
			}
			prev = e;
			e = next;
		}
		return false;

	}

	@Override
	public V get(K key) {
		int bucket = key.hashCode();
		MyEntry<K, V> existingElement = table[bucket];
		while (existingElement != null) {
			if (existingElement.getKey().equals(key)) {
				return existingElement.getValue();
			}
			existingElement = existingElement.getNext();
		}
		return null;

	}

	@Override
	public int size() {
	
		return size;
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % size;
	}

	@Override
	public MyEntry<K, V> entrySet() {

		return null;
	}

}
