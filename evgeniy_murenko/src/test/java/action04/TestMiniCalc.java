import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestMiniCalc {
	MiniCalc calc;
	@Before
	public void init(){
		calc = new MiniCalc();
	}
	@Test
	public void test_0_10() {
		//fail("Not yet implemented");
		int res = calc.multiply(0, 10);
		if(res != 0)fail("Error 0*X");
	}
	@Ignore
	@Test
	public void test_10_0() {
		//fail("Not yet implemented");
		int res = calc.multiply(10, 0);
		if(res != 0)fail("Error 0*X");
	}
	@Test
	public void test_a_b() {
		int a = (int)(10*Math.random());
		int b = (int)(10*Math.random());
		int res = calc.multiply(a, b);
		if(res != a*b)fail("Error "+a+"*"+b);
	}
	@Test
	public void test_3_b() {
		int a = 3;
		int b = (int)(10*Math.random());
		int res = calc.multiply(a, b);
		if(res != a*b)fail("Error "+a+"*"+b);
	}
	//assertTrue(res1==expected);
	//assertTrue("name error",res1==expected);
	//assertEquals(res.equals(expected))
	//assertNull(res)
	
}
