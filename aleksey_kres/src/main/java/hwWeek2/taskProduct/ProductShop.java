package hwWeek2.taskProduct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();

	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();
		shop.printReverseContructor();
		shop.printNameProductByType(TypeProduct.Yogurt);

	}

	public ProductShop() {
		contructors.put(new Product("Bread White", TypeProduct.Bread, 10), "Firma 3");
		contructors.put(new Product("Super Yogurt", TypeProduct.Yogurt, 10), "Firma 3");

		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 12), "Firma 3");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 12), "Firma 3");

		contructors.put(new Product("Milk with Shokolate", TypeProduct.Milk, 14), "Firma 1");
		contructors.put(new Product("Simple Yogurt", TypeProduct.Yogurt, 14), "Firma 1");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 16), "Firma 1");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 16), "Firma 1");
		contructors.put(new Product("Milk with Shokolate", TypeProduct.Milk, 14), "Firma 1");
		contructors.put(new Product("Simple Yogurt", TypeProduct.Yogurt, 14), "Firma 1");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 16), "Firma 1");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 18), "Firma 1");

		contructors.put(new Product("Bread White", TypeProduct.Bread, 20), "Firma 2");
		contructors.put(new Product("Super Yogurt", TypeProduct.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");

		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");
		/* System.out.println(contructors.size()); */
	}

	public void printContructor() {
		List<Map.Entry<Product, String>> list = new ArrayList<>(contructors.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Product, String>>() {

			@Override
			public int compare(Entry<Product, String> arg0, Entry<Product, String> arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});
		for (Entry<Product, String> entry : list) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}

	public void printReverseContructor() {
		List<Map.Entry<Product, String>> list = new ArrayList<>(contructors.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Product, String>>() {

			@Override
			public int compare(Entry<Product, String> arg0, Entry<Product, String> arg1) {
				return arg1.getValue().compareTo(arg0.getValue());
			}
		});
		for (Entry<Product, String> entry : list) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}

	public void printNameProductByType(TypeProduct type) {
		Map<String, TypeProduct> map = new TreeMap<>();
		for (Entry<Product, String> entry : contructors.entrySet()) {
			map.put(entry.getKey().getName(), entry.getKey().getType());
		}
		
		for (Entry<String, TypeProduct> entry : map.entrySet()) {
			if (entry.getValue().equals(type)) {
				System.out.println("name " + entry.getKey() + " type " + entry.getValue());
			}
			
			
		}
	}
}
