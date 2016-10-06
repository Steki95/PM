package A1p2;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 */

import java.util.List;

public class Sensor {
	
	/**
	 * Id des Sensors
	 */
	private String id;
	/**
	 * Alle Messungen der dieser Sensor gemacht hat
	 */
	private List<Messung> messungen;

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
