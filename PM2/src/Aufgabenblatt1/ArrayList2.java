package Aufgabenblatt1;

public class ArrayList2<T extends Comparable<T>> {

	private int anzahlElemente;
	private Object[] elemente;

	public ArrayList2() {
		elemente = new Object[1];
	}

	public void hinzufugen(T element) {

		if (elemente.length == anzahlElemente) {
			Object[] buffer = new Object[elemente.length * 2];
			System.arraycopy(elemente, 0, buffer, 0, anzahlElemente);
			elemente = buffer;
		}
		elemente[anzahlElemente] = element;
		anzahlElemente++;
	}

	public T get(int i) {
		if (i >= 0 && i < anzahlElemente) {
			return (T) elemente[i];
		}
		return null;
	}

	public void entferneElementAnIndex(int i) {
		if (i >= 0 && i < anzahlElemente) {
			for (int j = i; j < anzahlElemente - 1; j++) {
				elemente[j] = elemente[j + 1];
				anzahlElemente--;
			}
		}
	}

	public String toString() {
		String string = "[";
		for (int i = 0; i < anzahlElemente; i++) {
			string += elemente[i].toString() + ",";
		}
		string += "]";
		return string;
	}

	public T getKleinsesElement(){
		if(anzahlElemente > 0){
			Object min = elemente[0];
			for(int i = 0;i<anzahlElemente;i++){
					min.
				}
		}
		return null;
	}
}
