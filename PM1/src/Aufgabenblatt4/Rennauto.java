/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Mia Meister (mia.meister@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4, Aufgabe 4.1
 */
package Aufgabenblatt4;


public class Rennauto {
	/**
	 * Deklaration der Eigenschaften
	 */
	private String name;
	
	
	private String typ;
	private double maximalGeschwindigkeit, gefahreneStrecke;

	/**
	 * daskhdlas
	 * 
	 * @param name Initialier Wert fuer den Fahrernamen.
	 * @param typ
	 * @param maximalGeschwindigkeit
	 */
	public Rennauto(String name, String typ, int maximalGeschwindigkeit) {
		this.name = name;
		this.typ = typ;
		this.maximalGeschwindigkeit = maximalGeschwindigkeit;
		this.gefahreneStrecke = 0;
	}

	/**
	 * Erhoht die gefahreneStrecke des Rennautos
	 */
	public void fahren() {
		gefahreneStrecke += Math.random() * maximalGeschwindigkeit;
	}

	/**
	 * Gibt alle daten des Rennautos auf der Konsole aus
	 */
	public void ausgeben() {
		System.out.println(name + "|" + typ + "|" + maximalGeschwindigkeit + "|" + gefahreneStrecke);
	}

	/**
	 * @return
	 */
	public double getGefahreneStrecke() {
		return gefahreneStrecke;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Fuehrt das renne durch und gibt den sieger des rennens zuruck wie auch
	 * die sieger der wetten
	 */
	public static void main(String[] args) {

		Rennen rennen = new Rennen(20000);
		Wettbuero wettbuero = new Wettbuero(rennen, 2);

		rennen.addRennauto(new Rennauto("stefan", "bmw", 100));
		rennen.addRennauto(new Rennauto("bojan", "bmw", 1));
		rennen.addRennauto(new Rennauto("miodrag", "bmw", 1));

		wettbuero.wetteAnnehmen("stefan", 100, "s1");
		wettbuero.wetteAnnehmen("bojan", 50, "s2");
		wettbuero.wetteAnnehmen("miodrag", 200, "s3");
		wettbuero.wetteAnnehmen("miodrag", 200, "s4");

		rennen.durchfuhren();
		wettbuero.auswerten();
	}

}
