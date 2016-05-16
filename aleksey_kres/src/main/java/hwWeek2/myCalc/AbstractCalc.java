package hwWeek2.myCalc;

public abstract class AbstractCalc implements Calculator {
	protected String result = "0";
	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public void setResult(String result) {
		this.result = result;
	}

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
