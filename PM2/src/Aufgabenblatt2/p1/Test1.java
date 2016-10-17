package Aufgabenblatt2.p1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test1 {

	@Test
	public void testOperationPlus(){
		Rechner plus = new Rechner();
		double losung = 5;
		double x = 2;
		double y = 3;
		assertEquals(plus.berechne(Operation.ADDITION, x, y),losung,1);
	}
	@Test
	public void testOperationMinus(){
		Rechner minus = new Rechner();
		double losung = 2;
		double x = 5;
		double y = 3;
		assertEquals(minus.berechne(Operation.SUBTRAKTION,x,y),losung,1);
	}
	@Test
	public void testOperationDivision(){
		Rechner division = new Rechner();
		double losung = 2;
		double x = 6;
		double y = 3;
		assertEquals(division.berechne(Operation.DIVISION, x, y),losung,1);
	}
	@Test
	public void testOperationMultiplikation(){
		Rechner multiplikation = new Rechner();
		double losung = 6;
		double x = 3;
		double y = 2;
		assertEquals(multiplikation.berechne(Operation.MULTIPLIKATION, x, y),losung,1);
	}
	@Test
	public void testDoubleDoublezuDouble(){
		DoubleDoubleZuDouble testOperation = (x,y) -> x*2+y; 
		double x = 2;
		double y = 3;
		double losung = 7;
		assertEquals(testOperation.operation(x, y),losung,1);
	}
}
