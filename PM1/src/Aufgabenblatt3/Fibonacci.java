/**
* Praktikum TIPR1, SS 2016
* Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
* Remzi Goekoglu (remzi.goekoglu@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe 3.2
* 
*/
package Aufgabenblatt3;

import java.util.Scanner;

/**
 * 
 * Berechnung der gewunchten fibonacci zahl
 *
 */

public class Fibonacci {

	final static int ERSTE_FIBONNACI_ZAHL = 0;
	final static int ZWEITE_FIBONNACI_ZAHL = 1;

	public static int fibonacci(int x) {
		if (x == 1 || x == 2) {

			return 1;

		}
		return fibonacci(x - 1) + fibonacci(x - 2);
	}

	public static void main(String[] args) {

		// Deklaration der variablen
		Scanner input = new Scanner(System.in);
		int index, folgende_zahl, leitende_zahl, nexte_zahl, zahler;

		// Eingabe der position der gewunchten fibonacci zahl
		System.out.println("Geben sie welche in reihe folgende fibonacci zahl sie finden wohlen: ");
		index = input.nextInt();
		if (index>=48 || index<0 ) {
			System.out.println("Die eingegebene Zahl ist zu groß für den Darstellungsbereich von Int");
		
		}
		// Deklaration der ersten zwei fibonacci zahlen und andere variablen
		folgende_zahl = ERSTE_FIBONNACI_ZAHL;
		leitende_zahl = ZWEITE_FIBONNACI_ZAHL;
		zahler = index;

		// Finden der fibonacci zahlen mit hilfe der while schleife
		while (zahler > 1) {
			nexte_zahl = folgende_zahl + leitende_zahl;
			folgende_zahl = leitende_zahl;
			leitende_zahl = nexte_zahl;
			zahler--;
		}

		// Ausgabe der fibonacci zahlen
		System.out.println("Die " + index + " Zahl ist " + folgende_zahl);
		input.close();
	}
}
