/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4, Aufgabe 4.3
 */
package Aufgabenblatt4;

public class Wette {
	/**
	 * Deklaration der Eigenschaften
	 */
	private String fahrerin, spieler;
	private int wettEinsatz;

	/**
	 * @param fahrerin
	 * @param spieler
	 * @param wettEinsatz
	 */
	Wette(String fahrerin, String spieler, int wettEinsatz) {
		this.fahrerin = fahrerin;
		this.spieler = spieler;
		this.wettEinsatz = wettEinsatz;
	}

	public String getFahrerin() {
		return fahrerin;
	}

	public String getSpieler() {
		return spieler;
	}

	public int getWettEinsatz() {
		return wettEinsatz;
	}
}
