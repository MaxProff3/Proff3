package SecondWeek;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainCalcTest {
	MyCalc calc;

	@Before
	public void init() {
		calc = new MyCalc();
	}

	@Test
	public void testFirstValue_0() {
		calc.inChar('0');
		assertEquals("", calc.getResult());
	}

	@Test
	public void testFirstValueNot_0() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('1');
		assertEquals("621", calc.getResult());
	}

	@Test
	public void testOperationIsFirst() {
		calc.inChar('+');
		assertEquals("", calc.getResult());
	}

	@Test
	public void testOperationNotFirst() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('*');
		assertEquals("62", calc.getResult());
	}

	@Test
	public void testSecondValue_0() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('*');
		calc.inChar('0');
		assertEquals("", calc.getResult());
	}

	@Test
	public void testSecondValueNot_0() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('*');
		calc.inChar('8');
		assertEquals("8", calc.getResult());
	}

	@Test
	public void testEquellyFirst() {
		calc.inChar('=');
		assertEquals("", calc.getResult());
	}

	@Test
	public void testEquellyNotFirst() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('+');
		calc.inChar('8');
		calc.inChar('=');
		assertEquals("70", calc.getResult());

	}

	@Test
	public void testDivByZero() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('/');
		calc.inChar('0');
		calc.inChar('=');
		assertEquals("Error", calc.getResult());
	}

	@Test
	public void testDivChangeZero() {
		calc.inChar('6');
		calc.inChar('2');
		calc.inChar('/');
		calc.inChar('0');
		calc.inChar('2');
		calc.inChar('=');
		assertEquals("31", calc.getResult());
	}
}
