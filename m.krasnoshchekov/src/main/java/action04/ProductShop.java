package action04;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;

public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();
	
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

	}

	public void printContructor() {
		TreeSet<String> firm = new TreeSet<>();
		for (Entry<Product, String> entry : contructors.entrySet()) {
			firm.add(entry.getValue());
		}
		System.out.println(firm);
	}

	public void printReverseContructor() {
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2.hashCode() - o1.hashCode());
			}
		});
		for (Entry<Product, String> entry : contructors.entrySet()) {
			ts.add(entry.getValue());
		}
		System.out.println(ts);

	}

	public void printNameProductByType(TypeProduct type) {
		TreeSet<String> tree = new TreeSet<>();
		for (Entry<Product, String> entry : contructors.entrySet()) {
			if (entry.getKey().getType().equals(type)) {
				tree.add(entry.getKey().getName());
			}
		}
		System.out.println(tree);
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
	
//	@Override
//	public int hashCode() {
//		int hash = new Random().nextInt(255);
//        hash = hash*255+ name.hashCode();
//        return hash;
//	}

	public String getName() {
		return name;
	}

	public TypeProduct getType() {
		return type;
	}
}
