package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();

	public static void main(String[] args){
		ProductShop shop=new  ProductShop();
		shop.printContructor();
		System.out.println();
		//shop.contructors.
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
		
	}

	public void printContructor() {
		for(Entry<Product, String> entry: contructors.entrySet()){
			System.out.println("{"+entry.getKey()+","
					+entry.getValue()+"},  ");
		}
	}

	public void printReverseContructor() {
	
	}

	public void printNameProductByType(TypeProduct type) {
		
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

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", party=" + party + "]";
	}
}
