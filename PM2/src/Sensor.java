package Aufgabenblatt1;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

	private int id;
	private List<Messung> messungen;
	
	public Sensor(int id,List<Messung> messungen){
		this.id = id;
		this.messungen = messungen;
	}

	public int getId() {
		return id;
	}
}
