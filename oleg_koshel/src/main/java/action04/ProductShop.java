package action04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
		
		
		
		Collection<String> arrFirms = contructors.values();
		
		Set treeSet = new TreeSet();
		
		for (String el: arrFirms){
			
			treeSet.add(el.toString());
		}
		
		
		Iterator iterator = treeSet.iterator();
		
		while (iterator.hasNext()){
			
			System.out.println(iterator.next());
			
		}
		
	}

	public void printReverseContructor() {
		
		Collection<String> arrFirms = contructors.values();
		
		Set treeSet = new TreeSet();
		
		for (String el: arrFirms){
			
			treeSet.add(el.toString());
		}
		
			
		Iterator iterator = treeSet.iterator();
		
		String[] arr = new String[treeSet.size()]; 
		
		
		int n=0;
		while (iterator.hasNext()){
			
			arr[arr.length-1-n] = (String) iterator.next();
		
			n++;
		}
		
		
		for (int i=0;i<arr.length;i++){
			
			System.out.println(arr[i]);
			
		}
		
		
	}

	public void printNameProductByType(TypeProduct type) {
		
		HashSet prSet = new HashSet<>(); 
		
		Collection<Product> arrProducts = contructors.keySet();
		
		Iterator iterator = arrProducts.iterator();
		
		
		while (iterator.hasNext()){
			
			Product pr = (Product) iterator.next();
			
			if (pr.getTypeProduct() == type){
				
				prSet.add(pr);
			}
			
			
			
		}
		
		
		
		Iterator iterHashSet = prSet.iterator();
		
		while (iterHashSet.hasNext()){
			
			System.out.println(iterHashSet.next());
			
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
	
	@Override
	public int hashCode(){
		
		return name.hashCode()*30 +type.hashCode() ;
		
	}
	
	@Override
	public boolean equals(Object o){
		
		Product pr = (Product)o;
		
		if (this.type == pr.type && this.name.equals(pr.name)) return true;
		else return false;
		
	}
	
	public TypeProduct getTypeProduct(){
		
		return type;
		
	}
	
	@Override
	public String toString(){
		
		return "Name: "+name+"  TypeProduct: "+getTypeProduct();
		
	}
	

}
