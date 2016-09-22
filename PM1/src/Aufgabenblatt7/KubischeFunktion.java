package Aufgabenblatt7;

public class KubischeFunktion implements Funktion {
	private int a;
	private int b;
	private int c;
	private int d;

	public KubischeFunktion(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public double funktion(double x) {
		return ((a * (x * x * x)) + (b * x * x) + (c * x) + d);
	}

	@Override
	public double funktionPrim(double x) {
		return ((3 * a * x * x) + (2 * b * x) + c);
	}
}
