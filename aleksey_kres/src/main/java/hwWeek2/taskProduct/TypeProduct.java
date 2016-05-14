package hwWeek2.taskProduct;

public enum TypeProduct {
	Bread, Yogurt, Milk;	
		
}
class Example{
	public void main(){
		TypeProduct[] arr = TypeProduct.values();
		TypeProduct temp = TypeProduct.valueOf("Bread");
		String str = temp.toString();
	}
}
