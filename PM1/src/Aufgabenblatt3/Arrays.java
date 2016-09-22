/**
* Praktikum TIPR1, SS 2016
* Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
* Remzi Goekoglu (remzi.goekoglu@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe 3.3
* 
*/

package Aufgabenblatt3;

public class Arrays {

	public static void main(String[] args) {

		// Deklaration des arrays
		int[][] array = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
				{ 12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 8, 15, 12 } };

		/**
		 * 
		 * Aufgabe b, berechnung der Durchsnittstemperatur
		 * 
		 */

		// Deklaration der variabeln fuer diese Aufgabe
		double durchsnittstemperatur = 0;

		// erstmall addieren aller temperaturen und dann teilen durch die anzahl
		// der tage
		for (int element : array[1]) {
			durchsnittstemperatur += element;
		}
		durchsnittstemperatur /= array[1].length;

		// Ausgabe der Durchsnittstemperatur
		System.out.println("Die Durchsnittstemperatur aller tage ist: " + durchsnittstemperatur);

		/**
		 * 
		 * Aufgabe c, finden der maximal und minimal Temperatur
		 * 
		 */

		// Deklaration der variabeln fuer diese Aufgabe
		int maximal, minimal;

		// Deklaration der maximal und minimal Temperatur als die Temperatur am
		// Tag 1
		maximal = array[1][0];
		minimal = array[1][0];

		// Testen der Temperatur aller anderen Tage um eine hohere oder tiefere
		// zu finden
		for (int element : array[1]) {
			if (maximal < element) {
				maximal = element;
			}
			if (minimal > element) {
				minimal = element;
			}
		}

		// Ausgabe der minimal und maximal Temperatur
		System.out.println("Die maximal temperatur ist " + maximal + " und die minimal Temperatur ist " + minimal);

		/**
		 * 
		 * Aufgabe d, Suche die zwei Tage mit dem größten Temperaturumschwung
		 * 
		 */

		// Deklaration der variabeln fuer diese Aufgabe
		int temperaturumschwung = 0, tag_zahler = 1;
		int tag1[], tag2[];
		tag1 = new int[tag_zahler];
		tag2 = new int[tag_zahler];
		int umschwung;

		for (int i = 1; i < array[0].length; i++) {

			umschwung = array[1][i] - array[1][i - 1];// speichern des umschwunges in
													// einer variable

			if (umschwung < 0)
				umschwung = -umschwung;// negation wenn der umschwung negativ ist

			/*
			 * Wenn der umschwung groesser ist als der momentan groesste dann
			 * Array auf 1 setzen und die tage in der Liste einfuegen
			 */
			if (umschwung > temperaturumschwung) {
				temperaturumschwung = umschwung;
				tag1 = new int[1];
				tag2 = new int[1];
				tag_zahler = 1;
				tag1[tag_zahler - 1] = array[0][i];
				tag2[tag_zahler - 1] = array[0][i - 1];
			}

			// Wenn der umschwung gleich dem momentan grosten ist
			// Array um 1 erhohen und die tage in der liste schreiben
			else if (umschwung == temperaturumschwung) {
				tag_zahler += 1;
				int[] swap = new int[tag_zahler];
				System.arraycopy(tag1, 0, swap, 0, tag1.length);
				tag1 = swap;
				swap = new int[tag_zahler];
				System.arraycopy(tag2, 0, swap, 0, tag2.length);
				tag2 = swap;
				tag1[tag_zahler - 1] = array[0][i];
				tag2[tag_zahler - 1] = array[0][i - 1];
			}
		}

		// Ausgabe von allem Tagen mit dem größten Temperaturumschwung
		System.out.println("Der größten Temperaturumschwung ist zwischen den Tagen ");
		for (int i = 0; i < tag_zahler; i++) {
			System.out.println(tag2[i] + " und " + tag1[i]);
		}

		/**
		 * 
		 * Aufgabe e, Ausgabe Tabelarisch
		 * 
		 */

		for (int[] reihe : array) {
			System.out.println();
			for (int element : reihe) {
				System.out.print(element + "\t");
			}
		}

	}
}
