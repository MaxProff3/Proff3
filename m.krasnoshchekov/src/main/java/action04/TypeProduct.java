package action04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum TypeProduct {
	Bread, Yogurt, Milk;	
		
}
class Example{
	public void main(){
		TypeProduct[] arr = TypeProduct.values();
		TypeProduct temp = TypeProduct.valueOf("Bread");
		String str = temp.toString();
		
		System.out.println("Test");
	}
}
