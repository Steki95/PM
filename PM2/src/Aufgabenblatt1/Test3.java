package Aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test3 {

	/**
	 * Testet ob hinzufugen,get,entfernen und toString methoden funktionieren
	 */
	@Test
	public void testHinzufugenGetEntfernenUndPrint() {
		ArrayList2<Integer> arrayList = new ArrayList2<Integer>();
		arrayList.hinzufugen(2);
		Integer test = 2;
		assertEquals(test, arrayList.get(0));
		arrayList.hinzufugen(3);
		arrayList.hinzufugen(4);
		test = 4;
		arrayList.entferneElementAnIndex(0);
		arrayList.entferneElementAnIndex(3);
		assertEquals(test, arrayList.get(1));
		System.out.println(arrayList.toString());
	}

}
