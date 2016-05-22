package action06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListsSynchronized {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = Collections.synchronizedList(list);
	}

}
