package A1p3;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
 */

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Testet saemtliche Methoden der Klasse ArrayList2 
 */
public class Test3 {

	
	@Test
	public void testHinzufuegenGet(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufugen(2);
		Integer test = 2;
		assertEquals(test,arrayList.get(0));
	}
	@Test
	public void testGetAnzahlElemente(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufugen(2);
		arrayList.hinzufugen(2);
		arrayList.hinzufugen(2);
		int test = 3;
		assertEquals(test,arrayList.getAnzahlElemente());
	}
	@Test
	public void testEntfernen(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufugen(2);
		arrayList.hinzufugen(3);
		arrayList.hinzufugen(4);
		arrayList.hinzufugen(3);
		
		arrayList.entfernen(3);
		
		Integer test[] = {2,4};
		for(int i =0; i< arrayList.getAnzahlElemente();i++){
		assertEquals(test[i],arrayList.get(i));
		}
	}
	@Test
	public void testEntferneElementAnIndex(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufugen(1);
		arrayList.hinzufugen(2);
		arrayList.hinzufugen(3);
		arrayList.hinzufugen(4);
		
		arrayList.entferneElementAnIndex(2);
		
		Integer test[] = {1,2,4};
		for(int i =0; i< arrayList.getAnzahlElemente();i++){
		assertEquals(test[i],arrayList.get(i));
		}
		
	}
	@Test
	public void testGetKleinstesElement(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufugen(22);
		arrayList.hinzufugen(44);
		arrayList.hinzufugen(11);
		arrayList.hinzufugen(33);
		
		Integer test = 11;
		assertEquals(test,arrayList.getKleinsesElement());
	}
	@Test
	public void testStaticTest(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufugen(22);
		arrayList.hinzufugen(44);
		assertTrue(StaticTest.testErstesElementIstNummer(arrayList));
	}

}
