package action04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(110, "Car");
		map.put(100, "Table");
		map.put(140, "PC");

		Set<Integer> keys = map.keySet();
		Collection<String> products = map.values();

		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("{" + entry.getKey() + "," + entry.getValue() + "},  ");
		}

	}
}