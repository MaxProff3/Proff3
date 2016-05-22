package calculator;

public abstract class AbstractCalc implements Calculator {
	protected String result = "0";
	protected int temp;
	protected char operation;

	@Override
	public void printResult() {
		System.out.println("Result = " + result);
	}

	public String getResult() {
		return result;
	}
}