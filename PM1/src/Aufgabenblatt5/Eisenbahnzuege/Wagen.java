/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 5
 */
package Aufgabenblatt5.Eisenbahnzuege;

public class Wagen {
	// KAS toString programmieren
	/**
	 * lange des wagens
	 */
	private final int lange;
	/**
	 * passagierKapazitaet des wagens
	 */
	private final int passagierKapazitaet;
	/**
	 * serien nummer des wagens
	 */
	private int wagenSerienNummer;
	/**
	 * statische variable der klasse wagen so das jedes neues objekt eine eigene
	 * serien nummer hatt
	 */
	private static int serienNummer = 0;
	/**
	 * der an diesen Wagen angehengte Wagen
	 */
	private Wagen naechsterWagen;

	/**
	 * @param lange
	 *            wird eine lange denn neuen wagen gegeben
	 * @param passagierKapazitaet
	 *            wird eine passagier kapazitaet denn neuen wagen gegeben
	 */
	public Wagen(int lange, int passagierKapazitaet) {
		this.lange = lange;
		this.passagierKapazitaet = passagierKapazitaet;
		wagenSerienNummer = serienNummer;
		serienNummer++;
		naechsterWagen = null;
	}

	public int getLange() {
		return lange;
	}

	public int getPassagierKapazitaet() {
		return passagierKapazitaet;
	}

	public int getSerienNummer() {
		return wagenSerienNummer;
	}

	/**
	 * 
	 * @param nexterWagen
	 *            der Wagen der an diesen Wagen angehangt ist
	 */
	public void setNaechsterWagen(Wagen naechsterWagen) {
		this.naechsterWagen = naechsterWagen;
	}

	public Wagen getNaechsterWagen() {
		return naechsterWagen;
	}

	public String toString() {
		return (" \nSerienNummer des Wagen:" + getSerienNummer() + " die Lange:" + getLange()
				+ " die Passagierkapazitet:" + getPassagierKapazitaet());
	}
}
