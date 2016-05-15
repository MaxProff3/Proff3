package calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalc {
	
	MyCalc calc;
	
	@Before
	public void init(){
		calc = new MyCalc();
	}
	
	@Test
	public void test() {
		calc.inChar('1');
		String res = calc.getResult();
		System.out.println(res);
		if (!res.equals("1")) fail("Not yet implemented");
	}

}
