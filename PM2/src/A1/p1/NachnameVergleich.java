package A1.p1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
 */

import java.util.Comparator;

public class NachnameVergleich implements Comparator<Student> {
	
	/**
	 * Vergleicht zwei Studenten objekte anhand ihrer Nachnamen
	 */
	@Override
	public int compare(Student student1, Student student2) {
		String nachname1 = student1.getNachname();
		String nachname2 = student2.getNachname();

		return nachname1.compareTo(nachname2);
	}

}
