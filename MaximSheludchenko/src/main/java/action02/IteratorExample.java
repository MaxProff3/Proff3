package action02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorExample {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(
		Arrays.asList(new Integer[]{12,4,8,3})//возвращает фиксированый набор данных
		);
		Iterator<Integer> iter = list.iterator();//итератор / удалить все чётные
		while(iter.hasNext()){
			//int i =iter.next();
			if(iter.next()%2==0)iter.remove();;
		}
		iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
