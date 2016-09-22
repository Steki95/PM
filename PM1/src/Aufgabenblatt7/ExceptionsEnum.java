/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

public enum ExceptionsEnum {
	DIVMIT0("Sie haben durch 0 geteilt"), KONVERGENZ("Die Funktion konvergiet nicht");

	/**
	 * Error message wenn eine exception passiert
	 */
	private String errorMessage;

	/**
	 * 
	 * @param string
	 *            die errorMessage die ubergeben wuerde
	 */
	private ExceptionsEnum(String string) {
		errorMessage = string;
	}

	public String toString() {
		return errorMessage;
	}
}
