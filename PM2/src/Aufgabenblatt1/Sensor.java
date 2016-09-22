package Aufgabenblatt1;

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
