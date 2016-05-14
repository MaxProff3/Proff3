package Calc;

public abstract class AbstractCalc implements Calculator {
	protected String result;
	protected int temp;
	protected char operation;

	@Override
	public void printResult() {
		System.out.println("Result = " + result + "   Temp = " + temp + "   Operat: " + operation);
	}

	public String getResult() {
		return result;
	}
}
