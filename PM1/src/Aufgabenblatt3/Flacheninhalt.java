/**
* Praktikum TIPR1, SS 2016
* Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
Remzi Goekoglu (remzi.goekoglu@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe 3.1
* 
*/

package Aufgabenblatt3;

import java.util.Scanner;

/**
 * 
 * Berechnung des Flacheninhalts einer variable, welchen flacheninhalt wahlen
 * wir zwischen kreis,quadrat und sechsek mit hilfe des index
 *
 */

public class Flacheninhalt {

	public static double kreis(double x) {
		return Math.pow(x, 2) * Math.PI;
	}

	public static double quadrat(double x) {
		return x * x;
	}

	public static double sechsek(double x) {
		return 6 * (Math.pow(x, 2) * Math.sqrt(3) / 4);
	}

	public static void main(String[] args) {
		// Deklaration der variablen
		Scanner input = new Scanner(System.in);
		int index = 0;
		double x, flacheninhalt = 0;
		// Wiederholung des programms bis die
		// richtigen zahlen eingeben worden
		// sind
		while (index < 1 || index > 3) {
			// Eingabe des index
			System.out.println(
					"Geben Sie ein zahl ein um zu wahlen welchen Flacheinhalt sie berechnen wollen(1-Kreis,2-Quadrat,3-Sechseck): ");
			index = input.nextInt();
			if (index >= 1 && index <= 3) { // Fehler check
				// Eingabe der variable mit der wie die flache berechnen
				switch (index) {
				case 1:
					System.out.println("Geben Sie den radius ein: ");
					break;
				default:
					System.out.println("Geben Sie die lange der ecken ein: ");
					break;
				}
				x = input.nextDouble();

				// Berechnung der Flache
				// switch (index) {
				//
				// case 1:
				// flacheninhalt = kreis(x);
				// break;
				// case 2:
				// flacheninhalt = quadrat(x);
				// break;
				// case 3:
				// flacheninhalt = sechsek(x);
				// break;
				// }

				if (index == 1) {
					flacheninhalt = kreis(x);
				} else if (index == 2) {
					flacheninhalt = quadrat(x);
				} else {
					flacheninhalt = sechsek(x);
				}

				// Ausgabe der Flache
				System.out.println("Die Flache ist: " + flacheninhalt);
				input.close();
			}

			else {
				System.out.println("Die flache die sie berechnen wollten exestiert nicht bitte verscuhen sie nochmall");
			} // Fehler anzeigen

		}
	}
}
