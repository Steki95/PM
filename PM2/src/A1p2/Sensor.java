package A1p2;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de), Mia
 * Meister (mia.meister@haw-hamburg.de) Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 * 
 */

import java.util.List;

public class Sensor {

	private String id;// Id des sensors
	private List<Messung> messungen;// Alle messungen der der Sensor gemacht
									// hatt

	public Sensor(String id, List<Messung> messungen) {
		this.id = id;
		this.messungen = messungen;
	}

	public List<Messung> getMessungen() {
		return messungen;
	}

	public String getId() {
		return id;
	}
}
