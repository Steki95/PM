/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

public class NullstellenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullstellenException(ExceptionsEnum exceptionTyp) {
		super(exceptionTyp.toString());
	}
}
