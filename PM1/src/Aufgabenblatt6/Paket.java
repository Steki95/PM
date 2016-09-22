/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3.3
 */
package Aufgabenblatt6;

public class Paket extends Sendung {

	private int gewicht;

	/**
	 * @param sender
	 * @param empfaenger
	 * @param startZeitpunkt
	 * @param transportDauer
	 * @param gewicht
	 */
	public Paket(Person sender, Person empfaenger, int startZeitpunkt, int transportDauer, int gewicht) {
		super(sender, empfaenger, startZeitpunkt, transportDauer);
		this.gewicht = gewicht;
	}

	public int getGewicht() {
		return gewicht;
	}

	public String toString() {
		return "Paket " + super.toString();
	}

	public boolean istAusgeliefert() {
		if (startZeitpunkt + transportDauer < momentanZeitpunkt) {
			return true;
		}
		return false;
	}

	public void aktualisiereZeitpunk(int momentanZeitpunkt) {
		this.momentanZeitpunkt = momentanZeitpunkt;
	}
}
