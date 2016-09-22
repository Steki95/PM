/**
* Praktikum TIPR1, SS 2016
* Gruppe: Stefan Belic (max.muster@haw-hamburg.de),
* Mia Meister (mia.meister@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 2, Aufgabe 2.1
* 
*/

package Aufgabenblatt2;

import java.util.Scanner;

/**
 * 
 * Verwandlung der Satellitenzeit aus reinen sekunden in minuten,stunden,tagen und sekunden
 * 
 */



public class Satellitenzeiten {
	
	
	public static void main(String[] args){
		
		//Deklaration der Variablen
		Scanner input = new Scanner(System.in);
		int tage,stunden,minuten,sekunden;
		
		//Declaration der Magischen Nummern
		final int SEKUNDEN_IN_MINUTEN = 60;//Anzahl der sekunden in minuten und minuten in stunden 
		final int STUNDEN_IN_TAGEN = 24;//Anzahl der stunden in tagen
		
		//Eingabe der Sekunden
		System.out.println("Bitte geben sie die zeit in sekunden an: ");
		sekunden = input.nextInt();
		
		//Berechnungen
		minuten = sekunden/SEKUNDEN_IN_MINUTEN;
		stunden = minuten/SEKUNDEN_IN_MINUTEN;
		tage = stunden/STUNDEN_IN_TAGEN;
		sekunden %=SEKUNDEN_IN_MINUTEN;
		minuten %=SEKUNDEN_IN_MINUTEN;
		stunden %=STUNDEN_IN_TAGEN; 
		
		//Ausgabe
		System.out.println(tage+" Tage "+stunden+":"+minuten+":"+sekunden);
		input.close();
	}
}
