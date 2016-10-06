package A1p2;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 */

import java.time.LocalDateTime;

public class Messung {
	
	/**
	 * Wert der Messung
	 */
	private double wert;
	/**
	 * Zeitstempel der Messung
	 */
	private LocalDateTime zeitstempel;

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
