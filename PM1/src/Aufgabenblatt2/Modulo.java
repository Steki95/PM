/**
* Praktikum TIPR1, SS 2016
* Gruppe: Stefan Belic (max.muster@haw-hamburg.de),
* Mia Meister (mia.meister@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 2, Aufgabe 3
* 
*/

package Aufgabenblatt2;

import java.util.Scanner;

/**
 *
 * Modulo zweier nummer mit hilfe der operators % und der formel
 *
 */

public class Modulo {

	public static void main(String[] args) {

		// Declaration der Variablen
		Scanner input = new Scanner(System.in);
		int variable1, variable2, formel, modul;

		// Eingabe der ersten Variable
		System.out.println("Bitte geben sie die erste Variable ein: ");
		variable1 = input.nextInt();
		// Eingabe der zweiten Variable
		System.out.println("Bitte geben sie die zweite Variable ein: ");
		variable2 = input.nextInt();

		// Berechnung der Losungen
		modul = variable1 % variable2;// Mit modul
		formel = variable1 - (variable1 / variable2) * variable2;// Mit der
																	// Formel

		// Ausgabe der Losungen
		System.out.println("Die formel Losung ist : " + formel + ", die modul Losung ist: " + modul);
		input.close();
	}
}
