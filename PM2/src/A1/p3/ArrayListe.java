package A1.p3;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
 */

public class ArrayListe<T extends Comparable<T>> {

	private int anzahlElemente;// Die anzahl der Elemente in dem Array
	private Object[] elemente;// Array mit allen Elementen in der Liste

	/**
	 * Setzt elemente Array auf die Laenge 1
	 */
	public ArrayListe() {
		elemente = new Object[1];
		anzahlElemente = 0;
	}

	/**
	 * Fuegt ein neues Element in zum Array hinzu und erhoeht die groesse des
	 * Arrays um das doppelte
	 * 
	 * @param element
	 *            neues element
	 */
	public void hinzufugen(T element) {
		if (elemente.length == anzahlElemente) {
			Object[] buffer = new Object[elemente.length * 2];
			System.arraycopy(elemente, 0, buffer, 0, anzahlElemente);
			elemente = buffer;
		}
		elemente[anzahlElemente] = element;
		anzahlElemente++;
	}

	/**
	 * Gibt das Element an Position 0, wenn es ein Element gibt sonst gibt es
	 * null zurueck
	 * 
	 * @param i
	 *            position des gewuenchten Elements
	 * @return das gewuenschte Element
	 */
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if (i >= 0 && i < anzahlElemente) {
			return (T) elemente[i];
		}
		return null;
	}

	/**
	 * Entfernt alle Elemente aus dem Array, die altes_element entsprechen
	 * 
	 * @param altes_element
	 *            Element welches man entfernen will
	 */
	public void entfernen(T altes_element) {
		for (int i = 0; i < anzahlElemente; i++) {
			if (elemente[i].equals(altes_element)) {
				entferneElementAnIndex(i);
			}
		}
	}

	/**
	 * Entfernt das Element an der Stelle i und bewegt alle andere Elemente
	 * danach eine Position nach hinten
	 * 
	 * @param i
	 *            Position des Elements
	 */
	public void entferneElementAnIndex(int i) {
		if (i >= 0 && i < anzahlElemente) {
			
			for (int j = i; j < anzahlElemente - 1; j++) {
				elemente[j] = elemente[j + 1];
			}
			anzahlElemente--;
			elemente[anzahlElemente] = null;
		}
	}

	public String toString() {
		String string = "[";
		for (int i = 0; i < anzahlElemente; i++) {
			if (i > 0) {
				string += ",";
			}
			string += elemente[i].toString();
		}
		string += "]";
		return string;
	}

	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	/**
	 * Setzt kleinstes_element gleich dem ersten Element des Arrays und
	 * vergleicht dann dies mit allen anderen Elementen, falls es ein kleineres
	 * Element gibt wird diese kleinste_element gleich diesem Element gesetzt
	 * 
	 * @return das kleinste Element im Array
	 */
	@SuppressWarnings("unchecked")
	public T getKleinsesElement() {
		T kleinstes_element = null;
		if (anzahlElemente > 0) {
			kleinstes_element = (T) elemente[0];
			for (int i = 1; i < anzahlElemente; i++) {
				if (kleinstes_element.compareTo((T) elemente[i]) > 0) {
					kleinstes_element = (T) elemente[i];
				}
			}
		}
		return kleinstes_element;
	}
}
