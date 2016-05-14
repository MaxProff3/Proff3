package action04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();

	public ProductShop() {
		contructors.put(new Product("Bread White", TypeProduct.Bread, 10), "AAA");
		contructors.put(new Product("Super Yogurt", TypeProduct.Yogurt, 10), "AAA");

		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 12), "AAA");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 12), "AAA");

		contructors.put(new Product("Milk with Shokolate", TypeProduct.Milk, 14), "BBB");
		contructors.put(new Product("Simple Yogurt", TypeProduct.Yogurt, 14), "BBB");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 16), "BBB");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 16), "BBB");
		contructors.put(new Product("Milk with Shokolate", TypeProduct.Milk, 14), "BBB");
		contructors.put(new Product("Simple Yogurt", TypeProduct.Yogurt, 14), "BBB");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 16), "BBB");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 18), "BBB");

		contructors.put(new Product("Bread White", TypeProduct.Bread, 20), "CCC");
		contructors.put(new Product("Super Yogurt", TypeProduct.Yogurt, 20), "CCC");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 20), "CCC");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "CCC");

	}
	TreeSet<String> tree= new TreeSet<String>();
	public void printContructor() {
		for (Map.Entry<Product, String> entry : contructors.entrySet()) {
		tree.add(entry.getValue());
		}
		for(String firms:tree){
			System.out.println(firms);
		}
	}

	public void printReverseContructor() {
		NavigableSet<String> nav=tree.descendingSet();
			System.out.println(nav);
		
	}

	public void printNameProductByType(TypeProduct type) {
		//contructors.get(TypeProduct.valueOf(type.toString()));
		HashMap<String,TypeProduct> map=new HashMap<String,TypeProduct>();
		for(Map.Entry<Product, String> pr:contructors.entrySet()){
			map.put( pr.getKey().getName(),pr.getKey().getType());
		}
		for(Map.Entry<String, TypeProduct> t:map.entrySet()){
			if(t.getValue().equals(type)){
				System.out.println(t.getKey());
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeProduct getType() {
		return type;
	}

	public void setType(TypeProduct type) {
		this.type = type;
	}

	public int getParty() {
		return party;
	}

	public void setParty(int party) {
		this.party = party;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + party;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (party != other.party)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
