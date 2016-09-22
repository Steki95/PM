/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3.3
 */
package Aufgabenblatt6;

public class Brief extends Sendung {

	boolean einschreiben;

	/**
	 * Konstruktor der alle variabeln eingebt
	 * 
	 * @param sender
	 * @param empfaenger
	 * @param startZeitpunkt
	 * @param transportDauer
	 * @param einschreiben
	 */

	public Brief(Person sender, Person empfaenger, int startZeitpunkt, int transportDauer, boolean einschreiben) {
		super(sender, empfaenger, startZeitpunkt, transportDauer);
		this.einschreiben = einschreiben;
	}

	public boolean istEinEischreiben() {
		return einschreiben;
	}

	public String toString() {
		return "Brief " + super.toString();
	}

//	public boolean istAusgeliefert() {
//		if (Math.random() * 20 < 15) {
//			if (startZeitpunkt + transportDauer < momentanZeitpunkt) {
//				return true;
//			}
//		}
//		return false;
//	}
	//KAS Varainte mit einem return
	public boolean istAusgeliefert() {
		boolean ausgeliefert = false;
		
		if (Math.random() * 20 < 15) {
			if (startZeitpunkt + transportDauer < momentanZeitpunkt) {
				ausgeliefert = true;
			}
		}
		return ausgeliefert;
	}

	public void aktualisiereZeitpunk(int momentanZeitpunkt) {
		this.momentanZeitpunkt = momentanZeitpunkt;
	}
}
