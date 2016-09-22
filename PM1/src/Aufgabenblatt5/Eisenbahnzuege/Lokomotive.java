/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 5
 */
package Aufgabenblatt5.Eisenbahnzuege;

public class Lokomotive {
	// KAS toString programmieren
	/**
	 * die lange der lokomotive
	 */
	private final int lange;
	/**
	 * typ der lokomotive
	 */
	private final int typ;
	/**
	 * Wagen der an die lokomotive angehangt ist
	 */
	// KAS Die Namen der Methoden sind unschön => Abändern (auch in Zug ...)
	private Wagen ersterWagen;

	/**
	 * @param lange
	 *            die lange der lokomotive die wir kreiert haben
	 * @param typ
	 *            der lokomotive die wir kreieren
	 */
	Lokomotive(int lange, int typ) {
		this.lange = lange;
		this.typ = typ;
	}

	public int getLange() {
		return lange;
	}

	public int getTyp() {
		return typ;
	}

	/**
	 * 
	 * @param nexterWagen
	 *            der neue Wagen der an die Lokomotive angehangt wird
	 */
	public void setErstenWagen(Wagen ersterWagen) {
		this.ersterWagen = ersterWagen;
	}

	public Wagen getErstenWagen() {
		return ersterWagen;
	}

	public String toString() {
		return "\nLokomotiven typ: " + getTyp() + " Lokomotiven lange: " + getLange();
	}
}
