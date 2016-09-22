/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

import java.util.*;

public class Nullstelle {

	/**
	 * Der funktion typ fuer denn wir die nullstelle suchen
	 */
	private Funktion funktion;
	/**
	 * Schwellwert
	 */
	private final double schwellwert = 0.00001;
	/**
	 * Maximale anzahl von iterationen bevor exception geworfen wirt
	 */
	private final int maxAnzahlIterationen = 10;

	public Nullstelle(Funktion funktion) {
		this.funktion = funktion;
	}

	/**
	 * such die nullstelle anhang eines start werts
	 * 
	 * @param startWert
	 *            von welchen punkt man startet
	 * @return x nahsten zu der nullstelle in precision von e
	 * @throws NullstellenException
	 */
	public double findeNullstele(double startWert) throws NullstellenException {
		int anzahlIterationen = 0;
		do {
			// testet ob wir durch 0 teilen
			if (funktion.funktionPrim(startWert) == 0.0) {
				throw new NullstellenException(ExceptionsEnum.DIVMIT0);
				// testet ob wir uber 10 mall iteriart haben
			} else if (anzahlIterationen == maxAnzahlIterationen) {
				throw new NullstellenException(ExceptionsEnum.KONVERGENZ);
			}
			// Newton ferfahren
			startWert = startWert - (funktion.funktion(startWert) / funktion.funktionPrim(startWert));
			anzahlIterationen++;
		} while (Math.abs(funktion.funktion(startWert)) > schwellwert);
		return startWert;
	}

	/**
	 * sucht mehrere nullstenne mit ein randomasierten verfahren zwischen zwei
	 * gegebenen werten fur eine gegebene anzahl von malle an und gibt sie als
	 * liste zuruck
	 * 
	 * @param min
	 *            min wert mit denn man testet
	 * @param max
	 *            max wert mit denn man testet
	 * @param anzahlVersuche
	 *            anzahl der iterationen
	 * @return
	 */
	public List<Double> findeNullstellenRandomisiert(int min, int max, int anzahlVersuche) {
		Set<DoubleWert> set = new HashSet<DoubleWert>();
		List<Double> neueListe = new ArrayList<Double>();
		double startWert;
		DoubleWert nullStelle;
		// Wiederholt die schleiife anzahlVersuche von mallen
		while (anzahlVersuche > 0) {
			anzahlVersuche--;
			// Findet einen startWert anhang max und min
			startWert = max - (Math.random() * (Math.abs(max) - min));
			try {
				// Findet eine nullstelle und gibt sie ins set ein
				nullStelle = new DoubleWert(findeNullstele(startWert));
				set.add(nullStelle);
			} catch (NullstellenException e) {
			  // wird ignoriert
			}
		}
		int wert1;
		double wert2;
		// Rundet die gefundenen zahlen auf denn Schwellwert und steckt ihn in
		// die liste
		for (DoubleWert element : set) {
			wert1 = (int) (element.getWert() * (int)(1.0 / schwellwert + 1.0));
			wert2 = wert1 * schwellwert;
			neueListe.add(wert2);
		}
		// Sortiert die liste von kleinste zur groeste zahl
		Collections.sort(neueListe);
		return neueListe;

	}
}
