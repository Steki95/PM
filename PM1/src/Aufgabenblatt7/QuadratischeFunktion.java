/**
 * Praktikum TIPR1, SS 2016
 * Gruppe: Stefan Belic (Stefan.Belic@haw-hamburg.de),
 * Aufgabe: Aufgabenblatt 7
 */
package Aufgabenblatt7;

public class QuadratischeFunktion implements Funktion {

	private int a;
	private int b;
	private int c;

	public QuadratischeFunktion(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double funktion(double x) {
		return ((a * (x * x)) + (b * x) + c);
	}

	@Override
	public double funktionPrim(double x) {
		return ((2 * a * x) + b);
	}
}
