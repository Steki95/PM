package Aufgabenblatt6;

import java.util.Scanner;

/**
 * Die Simulation
 */
public class Simulation {

	public static void main(String[] args) {

		// Alle variabeln werden deklariert
		Scanner input = new Scanner(System.in);
		boolean simulationLauft = true; // variable die zeigt ob die Simulation
										// noch lauft
		String eingabe;
		int simulationsZeit = 0;

		SendungsListe sendungsListe = new SendungsListe(simulationsZeit, new OfflineSendungsdauerSchaetzer());

		while (simulationLauft) {
			System.out.println("Bitte kommando eingeben(ENDE,SCHRITT,HINZUFUGEN,UNGUELTIG):");
			eingabe = input.next().trim().toUpperCase();
			switch (eingabe) {
			case "ENDE":
				simulationLauft = false;
				break;
			case "SCHRITT":
				simulationsZeit += 15;
				sendungsListe.sendungenAustauschen(simulationsZeit);
				break;
			case "HINZUFUGEN":
				sendungsListe.personHinzufugen(input);
			default:
				System.out.println("Eingabe ist nicht korrekt versuchen sie es nochmall");
				break;
			}
		}
		input.close();
	}
}
