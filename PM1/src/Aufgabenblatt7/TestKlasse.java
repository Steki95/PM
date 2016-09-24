/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class TestKlasse {
	@Test
	public void testMethodeFindeNullstele() {
		Nullstelle nullstelle = new Nullstelle(new QuadratischeFunktion(1, 0, -1));
		double wunchWert = 1.0;
		try {
			assertEquals("Sind gleich", wunchWert, nullstelle.findeNullstele(2), DoubleWert.schwellwert);
		} catch (Exception e) {
			// Wird ignoriert
		}
	}

	@Test
	public void testExceptionDivisionDurchNull() {
		Nullstelle nullstelle = new Nullstelle(new QuadratischeFunktion(1, 0, -1));
		try {
			nullstelle.findeNullstele(0);
			fail();
		} catch (NullstellenException e) {

		}
	}

	@Test
	public void testExceptionKonvergenz() {
		Nullstelle nullstelle = new Nullstelle(new QuadratischeFunktion(1, 0, 1));
		try {
			nullstelle.findeNullstele(1);
			fail();
		} catch (NullstellenException e) {

		}
	}

	@Test
	public void testMethodeFindeNullstellenRandomisiert() {
		Nullstelle nullstelle = new Nullstelle(new QuadratischeFunktion(1, 0, -1));
		List<Double> wunchWertListe = new ArrayList<Double>();
		wunchWertListe.add(-1.0);
		wunchWertListe.add(1.0);
		List<Double> nullstellenListe = new ArrayList<Double>();
		nullstellenListe = nullstelle.findeNullstellenRandomisiert(-5, 5, 100);
		assertEquals(wunchWertListe.size(), nullstellenListe.size());
		for (int i = 0; i < wunchWertListe.size(); i++) {
			assertEquals("Gleich", wunchWertListe.get(i), nullstellenListe.get(i), DoubleWert.schwellwert);
		}
	}

}
