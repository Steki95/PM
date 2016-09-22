package Aufgabenblatt6;

import java.util.*;

/**
 * Klasse zur Datenhaltung aller personen die eine Sendung machen koennen, sie
 * wird in diesen beispiel automatisch entworfen mit hilfe von gegebenen daten
 * aber man kann es so machen das man Person die man will in die Liste
 * hineinfuegt
 */
public class PersonenListe {
	
	/**
	 * Eine liste die alle personen und derren adressen speichert
	 */
	private List<Person> personen;
	/**
	 * die Lange der liste
	 */


	public PersonenListe() {
		personen = new ArrayList<Person>();
		
		personen.add(new Person(new Adresse("adresse1", 1, 12000, Staedte.BERLIN)));
		personen.add(new Person(new Adresse("adresse2", 2, 13000, Staedte.HAMBURG)));
		personen.add(new Person(new Adresse("adresse3", 3, 14000, Staedte.MUENCHEN)));
		personen.add(new Person(new Adresse("adresse4", 4, 15000, Staedte.KOELN)));
		personen.add(new Person(new Adresse("adresse5", 5, 16000, Staedte.FRANKFURT)));
		personen.add(new Person(new Adresse("adresse6", 6, 17000, Staedte.STUTTGART)));
		personen.add(new Person(new Adresse("adresse7", 7, 18000, Staedte.DUESSELDORF)));
		personen.add(new Person(new Adresse("adresse8", 8, 19000, Staedte.DORTMUND)));
		personen.add(new Person(new Adresse("adresse9", 9, 20000, Staedte.ESSEN)));
		personen.add(new Person(new Adresse("adresse10", 10, 21000, Staedte.BREMEN)));

	}

	public Staedte getOrt(int i) {
		return personen.get(i).getAdresse().getOrt();
	}

	/**
	 * Fugt eine neue person zu der liste hinzu
	 * 
	 * @param input
	 *            der scanner aus main methode
	 */
	public void personHinzufugen(Person neuePerson) {
		personen.add(neuePerson);
	
	}

	public int getLange() {
		return personen.size();
	}

	public Person getPerson(int i) {
		return personen.get(i);
	}
}
