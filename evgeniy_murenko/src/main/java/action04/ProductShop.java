package action04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();

	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();

		//shop.printReverseContructor();
		// shop.printNameProductByType(TypeProduct.Yogurt);

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
		// System.out.println(contructors.size());
	}

	public void printContructor() {
		for (Entry<Product, String> entry : contructors.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());

		}
	}

	public void printReverseContructor() {
		List list = new ArrayList(contructors.entrySet());
		Collections.sort(list, new Comparator<Entry<Product, String>>() {
			public int compare(Entry<Product, String> o1, Entry<Product, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		for (Entry<Product, String> entry : contructors.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());

		}

	}

	public void printNameProductByType(TypeProduct type) {
		for (Entry<Product, String> entry : contructors.entrySet()) {
			if (entry.getKey().getType().equals(type)) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}
}

class Product {
	private String name;
	private TypeProduct type;
	private int party;

	public Product(String name, TypeProduct type, int party) {
		this.name = name;
		this.type = type;
		this.party = party;
	}

	public TypeProduct getType() {
		return type;
	}

	public void setType(TypeProduct type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return name+" "+type;
	}

}
