package A1p1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Test1 {

	/**
	 * Testet hash und equals Methoden
	 */
	@Test
	public void testMethodeHashUndEquals() {

		// Kreirung der prufungsleistungen nur fuer testen
		List<Pruefungsleistung> leistungen = new ArrayList<Pruefungsleistung>();
		leistungen.add(new Pruefungsleistung("Mathe", 2.2));
		// Kreirung der studenten
		Student student1 = new Student("Belic", "Stefan", 22, leistungen);
		Student student2 = new Student("Bopp", "Dennis", 23, leistungen);
		Student student3 = new Student("Student", "Drei", 23, leistungen);
		// Sicherstellen ob student1 und student2 verschiedene martikelnummern
		// haben
		assertFalse(student1.equals(student2));
		// Sicherstellen ob student3 und student2 gleiche martikelnummern haben
		assertTrue(student2.equals(student3));

	}

	/**
	 * Testet Comparable
	 */
	@Test
	public void testMethodeComparable() {

		// Kreirung der prufungsleistungen nur fuer testen
		List<Pruefungsleistung> leistungen = new ArrayList<Pruefungsleistung>();
		leistungen.add(new Pruefungsleistung("Mathe", 2.2));
		// Kreirung einer liste von alle studenten mit martikel nummer von der
		// hochsten bis zur kleinsten
		List<Student> studentenliste = new ArrayList<Student>();
		studentenliste.add(new Student("Belic", "Stefan", 3, leistungen));
		studentenliste.add(new Student("Belic", "Stefan", 2, leistungen));
		studentenliste.add(new Student("Belic", "Stefan", 1, leistungen));
		studentenliste.add(new Student("Belic", "Stefan", 0, leistungen));
		// Kreirung des loeesungs arrays fuer vergleich
		int loesungen[] = { 0, 1, 2, 3, 4 };
		// Sortieren der studenten von der kleinsten bis zur hochste
		// martikelnummer
		Collections.sort(studentenliste);
		// testen ob sich die liste gedreht hat
		for (int i = 0; i < studentenliste.size(); i++) {
			assertEquals(studentenliste.get(i).getMartikelnummer(), loesungen[i]);
		}
	}

	@Test
	public void testComparator() {
		// Kreirung der zwei vergleich Objekte
		VornameVergleich vergleich1 = new VornameVergleich();
		NachnameVergleich vergleich2 = new NachnameVergleich();

		// Kreirung der prufungsleistungen nur fuer testen
		List<Pruefungsleistung> leistungen = new ArrayList<Pruefungsleistung>();
		leistungen.add(new Pruefungsleistung("Mathe", 2.2));
		// Kreirung der studentenliste
		List<Student> studentenliste = new ArrayList<Student>();
		studentenliste.add(new Student("A", "D", 3, leistungen));
		studentenliste.add(new Student("B", "C", 2, leistungen));
		studentenliste.add(new Student("C", "B", 1, leistungen));
		studentenliste.add(new Student("D", "A", 0, leistungen));
		// Kreirung der loesungen
		String loesungen[] = { "A", "B", "C", "D" };

		// Testet ob die nachnamen von a bis d sortiert sind
		Collections.sort(studentenliste, vergleich2);
		for (int i = 0; i < studentenliste.size(); i++) {
			assertEquals(studentenliste.get(i).getNachname(), loesungen[i]);
		}
		// Testet ob die vornamen von a bis d sortiert sind
		Collections.sort(studentenliste, vergleich1);
		for (int i = 0; i < studentenliste.size(); i++) {
			assertEquals(studentenliste.get(i).getVorname(), loesungen[i]);
		}
	}

}
