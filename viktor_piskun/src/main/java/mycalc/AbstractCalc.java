package mycalc;

public abstract class AbstractCalc implements Calculator {
	protected String result = "0";
	protected int temp = 0;
	protected char operation = ' ';
	
	@Override
	public String printResult() {
		System.out.println("Result = " + result);
		return result;
	}
	
	public int getIntRes(){
		return Integer.parseInt(result);
	}
	
	public String getResult() {
		return result;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}
}

interface Calculator {
	public final static String ByZero = "Error";

	public String printResult();

	public String getResult();

	public void inChar(char p);
}