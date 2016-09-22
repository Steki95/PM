package Aufgabenblatt1;

import java.time.LocalDateTime;

public class Messung {
	private double wert;
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
