package action04;
import action04.TypeProduct;;

public class MainShop {
	
	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		
		shop.printContructor();
		shop.printReverseContructor();
		shop.printNameProductByType(TypeProduct.Bread);
		
	}
}
