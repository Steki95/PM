package A1p1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
 */

import java.util.List;

public class Student implements Comparable<Student> {
	
	/**
	 *  Vorname des Studenten 
	 */
	private String vorname;
	/**
	 * Nachname des Studenten
	 */
	private String nachname; 
	/**
	 * Martikelnummer des Studenten
	 */
	private int martikelnummer; 
	/**
	 * Liste aller Pruefungsleistungen des Studentens fuer alle Faecher
	 */
	private List<Pruefungsleistung> list; 

	public Student(String vorname, String nachname, int martikelnummer, List<Pruefungsleistung> list) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.martikelnummer = martikelnummer;
		this.list = list;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getMartikelnummer() {
		return martikelnummer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + martikelnummer;
		return result;
	}

	@Override
	/**
	 * Vergleicht anhand der Martikelnummer
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (martikelnummer != other.martikelnummer)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student obj) {
		return Integer.compare(this.martikelnummer, obj.getMartikelnummer());
	}

}
