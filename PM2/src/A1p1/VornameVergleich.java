package A1p1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
 */

import java.util.Comparator;

public class VornameVergleich implements Comparator<Student> {

	/**
	 *  Vergleicht zwei Studenten objekte anhand ihrer Vornamen
	 */
	@Override
	public int compare(Student student1, Student student2) {
		
		String vorname1 = student1.getVorname();
		String vorname2 = student2.getVorname();
		
		return vorname1.compareTo(vorname2);
	}

}
