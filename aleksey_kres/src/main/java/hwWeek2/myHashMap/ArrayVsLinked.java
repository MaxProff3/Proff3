package hwWeek2.myHashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayVsLinked {
	public static void main(String[] args) {

		List<Integer> arList = new ArrayList<Integer>();
		List<Integer> linkList = new LinkedList<>();

		long time1 = System.nanoTime();

		for (int i = arList.size(); i < 10000; i++) {
			int a = (int) Math.random() * 10000;
			arList.add(a);
		}

		long time2 = System.nanoTime();
		long score = time2 - time1;

		System.out.println("������� � ������ ArrayList = " + score);

		long time3 = System.nanoTime();

		for (int i = linkList.size(); i < 10000; i++) {
			int a = (int) Math.random() * 10000;
			linkList.add(a);
		}

		long time4 = System.nanoTime();
		long score1 = time4 - time3;

		System.out.println("������� � ������ LinkedList = " + score1);

	}

}
