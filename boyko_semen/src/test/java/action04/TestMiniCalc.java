package action04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import action03.MinCalc;





public class TestMiniCalc {

	private static MinCalc calc = null;
	@Before
	public void init(){
		 calc = new MinCalc();
	}
	@Test
	public void test() {
		
		//fail("Not yet implemented");
		int res = calc.multiply(0, 10);
		if(res != 0)fail("Error 0*X");}
		
		@Test
		public void test2() {
		int a = (int) (10*Math.random());
		int b = (int) (10*Math.random());
		
	
		int res = calc.multiply(a, b);
		if(res != a*b)fail("Error a*b");
	}

}
