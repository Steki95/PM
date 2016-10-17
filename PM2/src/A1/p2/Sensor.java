package A1.p2;

import java.util.ArrayList;

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

	public Sensor(String id) {
		this.id = id;
		this.messungen = new ArrayList<Messung>();
	}
	
	public void addMessung(Messung messung){
		messungen.add(messung);
	}

	public List<Messung> getMessungen() {
		
		List<Messung> messungen2 = new ArrayList<Messung>();
		for(int i=0; i< messungen.size();i++){
			messungen2.add(messungen.get(i));
		}
		return messungen2;
	}

	public String getId() {
		return id;
	}
}
