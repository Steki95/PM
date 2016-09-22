/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 6, Aufgabe 6
 */
package Aufgabenblatt6;

/**
 * Klasse um die Adressen als objekte darzustellen fuer leichteres management
 */

public class Adresse {

	/**
	 * Die Stadt der Adresse
	 */
	private Staedte ort;
	/**
	 * Strassenname der Adresse
	 */
	private String strasse;
	/**
	 * Hausnummer der Adresse
	 */
	private int hausnummer;
	/**
	 * Postleitzahl der Adresse
	 */
	private int posleitzahl;

	/**
	 * @param strasse
	 * @param hausnummer
	 * @param posleitzahl
	 * @param ort
	 */
	public Adresse(String strasse, int hausnummer, int posleitzahl, Staedte ort) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.posleitzahl = posleitzahl;
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public int getPosleitzahl() {
		return posleitzahl;
	}

	public Staedte getOrt() {
		return ort;
	}
}
