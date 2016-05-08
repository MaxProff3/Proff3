package action04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class MyArrayList<T> {
	private T[] arr;
	private Object[] arr1 = new Object[10];

	public void sort(Comparator<T> c) {
		Arrays.sort(arr, c);
	}


	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});
		list.sort((str1,str2)->{return str1.compareTo(str2);});
	}
}
