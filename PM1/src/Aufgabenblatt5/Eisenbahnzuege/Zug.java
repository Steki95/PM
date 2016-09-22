/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 5
 */
package Aufgabenblatt5.Eisenbahnzuege;

public class Zug {
	/**
	 * Lokomotive die an denn Zug angehangt ist
	 */
	private Lokomotive lokomotive;

	/**
	 * @param lange
	 *            die lange der angehangten Lokomotive
	 * @param typ
	 *            typ der angehangten Lokomotive
	 */
	public Zug(int lange, int typ) {
		lokomotive = new Lokomotive(lange, typ);
	}

	/**
	 * Hangt ein neuen Wagen an denn letzten Wagen oder sonst Lokomotive hinzu
	 * 
	 * @param neuWagen
	 *            neuer Wagen denn man am Zug hinzufugt
	 */
	public void wagenHinzufugen(Wagen neuWagen) {
		Wagen nexterWagen;
		Wagen vorherigerWagen = null;
		nexterWagen = lokomotive.getErstenWagen();
		// Alle Wagen bis zum Ende durchgehen
		while (nexterWagen != null) {
			vorherigerWagen = nexterWagen;
			nexterWagen = vorherigerWagen.getNaechsterWagen();
		}

		// neuWagen entsprechend anhaengen
		if (vorherigerWagen != null) {
			vorherigerWagen.setNaechsterWagen(neuWagen);
		} else {
			lokomotive.setErstenWagen(neuWagen);
		}
	}

	/**
	 * Entfernt denn ersten Wagen von zug und hangt denn danach folgenden an die
	 * Lokomotive
	 * 
	 * @return denn ersten Wagen des zuges wenn es einen gibt sonst null
	 */
	public Wagen erstenWagenEntfernen() {
		Wagen ersterWagen;
		ersterWagen = lokomotive.getErstenWagen();
		if (ersterWagen != null) {
			lokomotive.setErstenWagen(ersterWagen.getNaechsterWagen());
		}
		ersterWagen.setNaechsterWagen(null);
		return ersterWagen;
	}

	/**
	 * Hangt einen Zug2 an diesen Zug an und entfernt alle Wagen von denn Zug2
	 * mit hilfe schon gegebener methoden
	 */
	public void zugAnhaengen(Zug zug2) {
		// KAS mit getErsterWagen arbeiten ....
		Wagen ersterWagenZug2 = zug2.getLokomotive().getErstenWagen();
		wagenHinzufugen(ersterWagenZug2);
		zug2.leeren();
	}

	/**
	 * Hangt alle Wagen von der Lokomotive ab
	 */
	public void leeren() {
		lokomotive.setErstenWagen(null);
	}

	public int getWagenAnzahl() {
		int wagenAnzahl = 0;
		Wagen wagen = lokomotive.getErstenWagen();
		while (wagen != null) {
			wagenAnzahl++;
			wagen = wagen.getNaechsterWagen();
		}
		return wagenAnzahl;
	}

	public Lokomotive getLokomotive() {
		return lokomotive;
	}

	/**
	 * 
	 * @return gibt die passagier kapazitat des ganzen zuges zuruck
	 */
	public int getPassagierKapazitat() {
		int passagierKapazitat = 0;
		Wagen wagen = lokomotive.getErstenWagen();
		while (wagen != null) {
			passagierKapazitat += wagen.getPassagierKapazitaet();
			wagen = wagen.getNaechsterWagen();
		}
		return passagierKapazitat;
	}

	/**
	 * 
	 * @return gibt die lange des ganzen zuges zuruck
	 */
	public int getLange() {
		int lange = lokomotive.getLange();
		Wagen wagen = lokomotive.getErstenWagen();
		while (wagen != null) {
			lange += wagen.getLange();
			wagen = wagen.getNaechsterWagen();
		}
		return lange;
	}

	/**
	 * Kreiert ein string die alle daten des zuges,seiner lokomotive und die
	 * wagen zuruckgibt
	 */
	public String toString() {
		String string = "";
		Wagen nexterWagen = lokomotive.getErstenWagen();
		// hier mit toString von Wagen arbeiten
		while (nexterWagen != null) {
			string += nexterWagen.toString();
			nexterWagen = nexterWagen.getNaechsterWagen();
		}
		// KAS hier mit toString der Lok arbeiten
		string = "Die maximal Lange des Zuges ist:" + getLange() + ". Die maximal Passagierzahl des Zuges ist:"
				+ getPassagierKapazitat() + ". Die wagen anzahl des Zuges ist: " + getWagenAnzahl()
				+ lokomotive.toString() + string;

		return string;
	}

	public static void main(String[] args) {
		Zug zug1, zug2;
		zug1 = new Zug(20, 1);
		zug2 = new Zug(30, 2);
		zug1.wagenHinzufugen(new Wagen(20, 10));
		zug1.wagenHinzufugen(new Wagen(10, 5));
		zug1.wagenHinzufugen(new Wagen(10, 5));
		zug2.wagenHinzufugen(new Wagen(20, 10));
		zug2.wagenHinzufugen(new Wagen(10, 5));
		zug2.wagenHinzufugen(new Wagen(10, 5));
		zug1.zugAnhaengen(zug2);
		System.out.println(zug1.toString());
		System.out.println("\n" + zug2.toString());
	}
}
