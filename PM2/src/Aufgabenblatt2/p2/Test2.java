package Aufgabenblatt2.p2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void testStream(){
		Streams stream = new Streams();
		String[] veranderterArray;
		stream.addString("Eingabe");
		stream.addString("Äußeres");
		stream.addString(null);
		stream.addString("Strassen-Feger");
		stream.addString(" ein Haus");
		veranderterArray = stream.apply();
		String[] losung = {"EINGABE", "AEUSSERE", "STRASSEN", "EIN HAUS"};
		for(int i = 0;i<losung.length;i++){
			assertTrue(losung[i].equals(veranderterArray[i]));
		}
	}
	
}
