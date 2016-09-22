/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3.3
 */
package Aufgabenblatt6;

/**
 * Klasse zuer Datenenhaltung der Personen
 */
public class Person {

	private Adresse adresse;

	public Person(Adresse adresse) {
		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}
}
