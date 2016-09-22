/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

public class DoubleWert {
	/**
	 * Wert der speicher klasse
	 */
	private double wert;
	/**
	 * Schwellwert
	 */
	public final static double schwellwert = 0.00001;

	DoubleWert(double wert) {
		this.wert = wert;
	}

	public double getWert() {
		return wert;
	}

	@Override
	public int hashCode() {
		return (int) (wert * (1.0 / schwellwert + 1.0));
	}

	@Override
	public boolean equals(Object obj) {
		boolean ruckgabe = true;
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		DoubleWert doubleWertObj = (DoubleWert) obj;
		double wert1 = this.getWert();
		double wert2 = doubleWertObj.getWert();
		if ((wert1 > 0 && wert2 > 0) || (wert1 < 0 && wert2 < 0)) {
			wert1 = Math.abs(wert1);
			wert2 = Math.abs(wert2);
			double differenc = Math.abs(wert1 - wert2);
			if (differenc > schwellwert) {
				ruckgabe = false;
			}
		}else{
			ruckgabe = false;
		}
		return ruckgabe;
	}
}