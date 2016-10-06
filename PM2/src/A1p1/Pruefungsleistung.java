package A1p1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
 */

public class Pruefungsleistung {
	/**
	 * Name des Moduls
	 */
	private String modulName;
	/**
	 * Note in dem Modul
	 */
	private double note;

	public Pruefungsleistung(String modulName, double note) {
		this.modulName = modulName;
		this.note = note;
	}

	public String getModulName() {
		return modulName;
	}

	public void setModulName(String modulName) {
		this.modulName = modulName;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

}
