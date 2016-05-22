package hw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hwWeek2.myCalc.MyCalc;

public class TestCalcHw {
	MyCalc calc;
	
	@Before
	public void init() {
		calc = new MyCalc();

	}
	@Test
	public void test1() {
	calc.inChar('0');
	calc.inChar('+');
	if(!calc.getResult().equals(" ")) fail(calc.getResult());
	}
	
	@Test
	public void test2() {
		calc.inChar('2');
		calc.inChar('*');
	if(!calc.getResult().equals(String.valueOf("2"))) fail("Operation is not correct");
	}
	
	@Test
	public void test3() {
		calc.inChar('1');
		calc.inChar('+');
		calc.inChar('0');
	if(!calc.getResult().equals(String.valueOf("1"))) fail("Second number is not correct");
	}
	
	@Test
	public void test4() {
		calc.inChar('1');
		calc.inChar('3');
		calc.inChar('+');
		calc.inChar('1');
		calc.inChar('0');
		calc.inChar('=');
	if(!calc.getResult().equals(String.valueOf(23))) fail("Result is not correct");
	}
}
