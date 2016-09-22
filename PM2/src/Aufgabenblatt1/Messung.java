package Aufgabenblatt1;

/**
* Praktikum TIPR2, WS 2016
* Gruppe: Stefan Belic (stefan_belic@haw.de),
* Mia Meister (mia.meister@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
* 
*/

import java.time.LocalDateTime;

public class Messung {

	private double wert;// Wert der messung
	private LocalDateTime zeitstempel;// Wann die messung passiert ist

	public Messung(double wert, LocalDateTime zeitstempel) {
		this.wert = wert;
		this.zeitstempel = zeitstempel;
	}

	public double getWert() {
		return wert;
	}

	public LocalDateTime getZeitstempel() {
		return zeitstempel;
	}
}
