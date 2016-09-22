/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4, Aufgabe 4.2
 */
package Aufgabenblatt4;

public class Rennen {
	/**
	 * Deklaration der Eigenschaften
	 */
	private int autoAnzahl;
	private Rennauto rennautoListe[];
	private double streckenLange;

	public Rennen(double streckenLange) {
		rennautoListe = new Rennauto[1];
		autoAnzahl = 0;
		this.streckenLange = streckenLange;
	}

	/**
	 * Gibt ein neues Rennauto in der liste ein, und wenn die liste zu klein ist
	 * dupliert es die Groesse
	 * 
	 * @param neuesRennauto
	 */
	public void addRennauto(Rennauto neuesRennauto) {
		if (autoAnzahl == rennautoListe.length) {
			Rennauto[] neueListe = new Rennauto[autoAnzahl * 2];
			System.arraycopy(rennautoListe, 0, neueListe, 0, autoAnzahl);
			rennautoListe = neueListe;
		}
		rennautoListe[autoAnzahl] = neuesRennauto;
		autoAnzahl++;
	}

	/**
	 * Geht durch die Liste und findet denn Sieger(wenn es zwei gibt waehlt er
	 * denn mit eine groessere strecke) wenn es einen gibt
	 * 
	 * @return
	 */
	public Rennauto ermittleSieger() {
		Rennauto sieger = null;
		for (int i = 0; i < autoAnzahl; i++) {
			if (rennautoListe[i].getGefahreneStrecke() >= streckenLange) {
				if (sieger != null) {
					if (sieger.getGefahreneStrecke() < rennautoListe[i].getGefahreneStrecke()) {
						sieger = rennautoListe[i];
					}
				} else {
					sieger = rennautoListe[i];
				}
			}
		}
		return sieger;
	}

	/**
	 * Fuehrt die Methode fahren() durch fuehr alle Rennautos in der Liste
	 */
	private void schritt() {
		for (int i = 0; i < autoAnzahl; i++) {
			rennautoListe[i].fahren();
		}
	}

	/**
	 * Wiederhohlt die methoden schritt() und ermitleSieger() bis ein sieger
	 * nicht gefunden woerde
	 */
	public void durchfuhren() {
		Rennauto sieger;
		do{
			schritt();
			sieger = ermittleSieger();
			if (sieger != null) {
				sieger.ausgeben();
			}
		}while(sieger == null);
	}
}
