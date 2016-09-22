/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

import java.util.ArrayList;
import java.util.List;

public class Haupt {
	public static void main(String[] args) {
		//Erstelle variabeln
		Nullstelle nullstelle = new Nullstelle(new QuadratischeFunktion(1, 0, -1));
		//Nullstelle nullstelle2 = new Nullstelle(new QuadratischeFunktion(1, -3, -4));
		List<Double> nullstellenListe = new ArrayList<Double>();
		//Finde alle nullstellen und stell sie in der liste
		nullstellenListe = nullstelle.findeNullstellenRandomisiert(-5, 5, 100);
		//Gibt die liste aus
		System.out.format(nullstellenListe.toString());
	}
}
