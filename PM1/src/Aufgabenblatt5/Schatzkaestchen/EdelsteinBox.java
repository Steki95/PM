package Aufgabenblatt5.Schatzkaestchen;

public class EdelsteinBox {

	public enum Edelstein {
		DIAMANT {
			@Override
			public String toString() {
				return "D";
			}
		},
		RUBIN {
			@Override
			public String toString() {
				return "R";
			}
		},
		SMARAGD {
			@Override
			public String toString() {
				return "S";
			}
		}
		
		
	}

	/**
	 * Die Edelsteine die sich in der box befinden
	 */
	private Edelstein[] edelsteine;
	private int edelsteinAnzahl;

	/**
	 * @param edelsteine
	 *            ein array von edelsteine die man von anfang an in der
	 *            edelsteinbox haben will
	 */
	public EdelsteinBox(Edelstein... edelsteine) {
		this.edelsteine = edelsteine;
		edelsteinAnzahl = edelsteine.length;
	}

	// KAS Parameter vom Typ Edelstein => ANZALL DER ENTSPRECHENDEN sORTE
	// ZURÜCKGEBEN
	int getAnzahl(Edelstein sorte) {
		int anzahl = 0;
		for (int i = 0; i < edelsteinAnzahl; i++) {
			if (edelsteine[i] == sorte) {
				anzahl++;
			}
		}
		return anzahl;
	}

	/**
	 * Kreiert ein string die alle Edelsteine sortierend zeigt in der Reinfolge
	 * D,R,S
	 */
	// KAS mit element.values den entsprechenden String aufbauen
	public String toString() {
		String string = "";
		for (int i = 0; i < edelsteinAnzahl; i++) {
			if (edelsteine[i] != null)
				string += edelsteine[i].toString();
		}
		return string;
	}

	/**
	 * Gibt den string der durch toString() kreiert wurde aus
	 */
	public EdelsteinBox ausgeben() {
		System.out.println("(" + toString() + ")");
		return this;
	}

	/**
	 * Legt eine gewehlte sorte Edelsteine der menge n in die Box rein und
	 * erhoht denn array fuer soviel
	 * 
	 * @param sorte
	 *            welche sorte man hinzufugen will
	 * @param anzahl
	 *            die anzahl der Edelsteine die man hinzufuegt
	 */
	// KAS Edelsteinbox zurückgeben
	public EdelsteinBox hineinlegen(Edelstein sorte, int anzahl) {
		if (anzahl > 0) {
			if (edelsteinAnzahl + anzahl >= edelsteine.length) {
				Edelstein[] neueEdelsteine = new Edelstein[(edelsteine.length + anzahl) * 2];
				System.arraycopy(edelsteine, 0, neueEdelsteine, 0, edelsteine.length);
				edelsteine = neueEdelsteine;
			}
			// Alle Steine der übergebenen Sorte werden hinten an das Array
			// kopiert
			for (int i = edelsteinAnzahl; i < edelsteinAnzahl + anzahl; i++) {
				edelsteine[i] = sorte;
			}
			edelsteinAnzahl += anzahl;
		}
		return this;
	}

	/**
	 * Nimmt aus die box eine gewahlte Edelstein sorte raus der menge n
	 * gleichzeitig schrinkt sie denn array um diese zahl
	 * 
	 * @param sorte
	 *            die sorte die man entfernen will
	 * @param anzahl
	 *            die menge die man entfernt
	 */
	public EdelsteinBox herausnehmen(Edelstein sorte, int anzahl) {
		if (anzahl > 0) {
			int zumEntfernen = anzahl;
			for (int i = 0; i < edelsteinAnzahl; i++) {
				if (edelsteine[i] == sorte && zumEntfernen > 0) {
					for (int j = i; j < edelsteinAnzahl - 1; j++) {
						edelsteine[j] = edelsteine[j + 1];
					}
					edelsteine[edelsteinAnzahl] = null;
					zumEntfernen--;
					i--;
				}
			}

			edelsteinAnzahl = edelsteinAnzahl - (anzahl - zumEntfernen);
		}
		return this;
	}

	/**
	 * Wandelt alle Edelsteine eine gewaehlten sorte in eine andere gewaehlte
	 * sorte
	 * 
	 * @param vonSorte
	 *            die sorte Edelsteine die man wechselt
	 * @param zuSorte
	 *            die sorte Edelsteine zu der man wechselt
	 */
	public EdelsteinBox umwandeln(Edelstein vonSorte, Edelstein zuSorte) {
		for (int i = 0; i < edelsteinAnzahl; i++) {
			if (edelsteine[i] == vonSorte) {
				edelsteine[i] = zuSorte;
			}
		}
		return this;
	}

	/**
	 * Leert die Box
	 */
	public EdelsteinBox leeren() {
		edelsteine = new Edelstein[1];
		edelsteinAnzahl = 0;
		return this;
	}

	public static void main(String[] args) {
		EdelsteinBox box;
		box = new EdelsteinBox(Edelstein.DIAMANT, Edelstein.SMARAGD, Edelstein.SMARAGD);
		box.hineinlegen(Edelstein.RUBIN, 4).herausnehmen(Edelstein.SMARAGD, 1)
				.umwandeln(Edelstein.SMARAGD, Edelstein.DIAMANT).ausgeben();
		box.leeren();
		box.hineinlegen(Edelstein.SMARAGD, 2).ausgeben();
		System.out.println(box.getAnzahl(Edelstein.SMARAGD));
	}
}
