/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4, Aufgabe 4.3
 */
package Aufgabenblatt4;

public class Wettbuero {
	/**
	 * Deklaration der Eigenschaften
	 */
	Rennen rennen;
	Wette[] wettenListe;
	double faktor;

	/**
	 * @param rennen
	 * @param faktor
	 */
	public Wettbuero(Rennen rennen, double faktor) {
		this.rennen = rennen;
		this.faktor = faktor;
		wettenListe = new Wette[0];
	}

	/**
	 * Nimmt eine neue Wette in der Liste ein und erhort die liste um 1 platz
	 * 
	 * @param fahrerin
	 * @param wettEinsatz
	 * @param spieler
	 */
	public void wetteAnnehmen(String fahrerin, int wettEinsatz, String spieler) {
		Wette[] neueListe = new Wette[wettenListe.length + 1];
		System.arraycopy(wettenListe, 0, neueListe, 0, wettenListe.length);
		neueListe[wettenListe.length] = new Wette(fahrerin, spieler, wettEinsatz);
		wettenListe = neueListe;
	}

	/**
	 * Gibt alle spieler an die die Wette gewonnen haben
	 */
	public void auswerten() {
		Rennauto sieger = rennen.ermittleSieger();
		if (sieger == null) {
			System.out.println("Das Rennen wuerde nicht durchefuehrt");
		} else {
			String siegerName = sieger.getName();
			for (int i = 0; i < wettenListe.length; i++) {
				if (wettenListe[i].getFahrerin().equals(siegerName)) {
					System.out.println(wettenListe[i].getSpieler() + " hatt die Wette gewonnen und gewint "
							+ wettenListe[i].getWettEinsatz() * faktor);
				}
			}
		}
	}
}
