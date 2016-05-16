package hwWeek2.myHashMap;

public class Main {

	public static void main(String[] args) {
	MyHashMap<Integer, String> map = new MyHashMap<>();
	map.put(1, "a");
	map.put(2, "b");
	map.put(3, "c");
	map.put(4, "м");
	map.put(5, "c");
	map.put(2323, "c");
	map.put(55, "n");
	map.get(2);
	System.out.println(	map.get(3));
	map.remove(3);
	System.out.println(map.get(3));
	System.out.println(map.size());
	
	
	
	
	}

}
