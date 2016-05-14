package SecondWeek;

public abstract class AbstractCalc implements Calculator {
	protected String result = "";
	protected int temp = 0;
	protected char operation = ' ';

	@Override
	public void printResult() {

		System.out.println("Result = " + result);

	}

	public String getResult() {
		return result;
	}

}
