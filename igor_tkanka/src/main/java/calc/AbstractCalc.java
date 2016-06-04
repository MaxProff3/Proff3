package calc;

public abstract class AbstractCalc implements Calculator {
	
	protected String result;
	protected int temp;
	protected char operation;

	@Override
	public String printResult() {
		System.out.println("Result = " + result);
		return result;
	}

	public String getResult() {
		return result;
	}
}
