package action04;
import java.util.HashMap;
import java.util.Map;

/*Написать программу:
Enum TypeProduct{Bread, Yogurt, Milk}
class Product{name, TypeProduct type, int numberParty}
ProductShop{Map<Product, String> shop(Product, NameOfContructor)}
Добавить в Карту по паре продуктов каждого типа.
Сделать:
1) Вывести список фирм в алфавитном порядке
2) Вывести список фирм в обратном порядке
3) Вывести уникальные наименования товаров по типу продуктов*/

public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();
	
	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		System.out.println(shop.contructors.size());
		System.out.println(shop.contructors.entrySet());
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
		
		
		//дополнительные
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");

	}

}

class Product {
	private String name;
	private TypeProduct type;
	private int party;

	@Override
	public String toString() {
		return "name=" + name + ", type=" + type.name() + ", party=" + party;
	}

	public Product(String name, TypeProduct type, int party) {
		this.name = name;
		this.type = type;
		this.party = party;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

}
