package action04;

public class MainMap {

	public static void main(String[] args) {
		ProductShop ps = new ProductShop();
		
		//ps.printContructor();
		//ps.printReverseContructor();
		ps.printNameProductByType(TypeProduct.valueOf("Bread"));
	}

}
