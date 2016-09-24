package A1p1;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de), Mia
 * Meister (mia.meister@haw-hamburg.de) Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 * 
 */

public class Pruefungsleistung {

	private String modulName;// Name des modules
	private double note;// Note in denn modul

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
