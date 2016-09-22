package Aufgabenblatt6;

/**
 * Die fatter Klasse fuer alle sendungen bsw. Paket und Brief
 */
public abstract class Sendung {
	
	/**
	 * sender der sendung
	 */
	protected Person sender;
	/**
	 * empfaenger der sendung
	 */
	protected Person empfaenger;
	protected int sendungsnummer;
	/**
	 * start zeitpunkt anhang der simulations zeit
	 */
	protected int startZeitpunkt;
	/**
	 * momentane zeit der simulation
	 */
	protected int momentanZeitpunkt;
	/**
	 * dauer der sendung
	 */
	protected int transportDauer;
	protected static int sendungsnummerZaehler = 0;

	public Sendung(Person sender, Person empfaenger, int startZeitpunkt, int transportDauer) {
		this.sender = sender;
		this.empfaenger = empfaenger;
		this.sendungsnummer = sendungsnummerZaehler;
		this.startZeitpunkt = startZeitpunkt;
		this.transportDauer = transportDauer;
		sendungsnummerZaehler++;
	}

	public int getSendungsnummer() {
		return sendungsnummer;
	}

	public int getTransportDauer() {
		return transportDauer;
	}

	public int getStartZeitpunkt() {
		return startZeitpunkt;
	}

	/**
	 * Aktualisiert die momentane zeit in der simulation so das das objekt weist
	 * ob es ausgeliefert woerden ist
	 * 
	 * @param momentanZeitpunkt
	 */
	public abstract void aktualisiereZeitpunk(int momentanZeitpunkt);

	/**
	 * gibt zuruck ob die Sendung ausgeliefert ist
	 * @return
	 */
	public abstract boolean istAusgeliefert();

	/**
	 * Kreiert eine detailten string uber die Sendung
	 */
	public String toString() {
		String string = sender.getAdresse().getOrt() + ">" + empfaenger.getAdresse().getOrt() + "(Start:"
				+ startZeitpunkt + " Dauer:" + transportDauer + ")";
		if (istAusgeliefert() == true) {
			string += " ist ausgeliefert";
		} else {
			string += "bei " + (100 * (momentanZeitpunkt - startZeitpunkt) / transportDauer) + "%";
		}
		return string;
	}
}
