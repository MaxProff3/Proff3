package hwWeek2.taskProduct;

public class MainProduct {
	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();
		System.out.println("****************************************************************************");
		shop.printReverseContructor();
		System.out.println("****************************************************************************");
		shop.printNameProductByType(TypeProduct.Yogurt);

}}
