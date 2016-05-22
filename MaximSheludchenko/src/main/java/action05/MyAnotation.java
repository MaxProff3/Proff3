package action05;

public @interface MyAnotation {

}
@MyAnotation
class MyClass{
	@MyAnotation
	public void f(){
		
	}
}