package action05;

public @interface MyAnnotation {

}

@MyAnnotation
class MyClass {
	@MyAnnotation
	public void f() {
		
	}
}