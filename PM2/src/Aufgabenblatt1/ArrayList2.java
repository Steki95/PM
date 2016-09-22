package Aufgabenblatt1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de), Mia
 * Meister (mia.meister@haw-hamburg.de) Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
 * 
 */

public class ArrayList2<T extends Comparable<T>> {

	private int anzahlElemente;// Die anzahl der elemente in denn array
	private Object[] elemente;// Array mit allen elementen in der liste

	/**
	 * Setz elemente auf 1
	 */
	public ArrayList2() {
		elemente = new Object[1];
	}

	/**
	 * Fugt ein neues elemente in array hinzu und erhoht die grosse des array um
	 * das dopelte
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
	 * Gibt das element an position 0 wenn es ein element gibt sonst gibt es
	 * null zurucks
	 * 
	 * @param i
	 *            position des gewunchten elements
	 * @return das gewunchte elements
	 */
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if (i >= 0 && i < anzahlElemente) {
			return (T) elemente[i];
		}
		return null;
	}

	/**
	 * Entfernt das element an der stelle i und bewegt alle andere elemente
	 * danach eine position nach hinten
	 * 
	 * @param i
	 *            position des elemets
	 */
	public void entferneElementAnIndex(int i) {
		if (i >= 0 && i < anzahlElemente) {
			for (int j = i; j < anzahlElemente - 1; j++) {
				elemente[j] = elemente[j + 1];
			}
			anzahlElemente--;
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

	/**
	 * Nimmt das erste element als kleinste und dann durch eine for schleife und
	 * comparable interface speicher er in min das next kleinste immer
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getKleinsesElement() {
		if (anzahlElemente > 0) {
			T min = (T) elemente[0];
			for (int i = 0; i < anzahlElemente; i++) {
				if (min.compareTo((T) elemente[0]) > 0) {
					min = (T) elemente[0];
				}
			}
		}
		return null;
	}
}
