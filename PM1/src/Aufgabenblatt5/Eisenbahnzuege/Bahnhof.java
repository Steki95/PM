package Aufgabenblatt5.Eisenbahnzuege;

import java.util.Scanner;

public class Bahnhof {
	private Zug[] zuge;
	private Wagen[] wagentypen;
	private Lokomotive[] lokomotivenTypen;
	private int zugAnzahl = 0;

	public Bahnhof() {
		zuge = new Zug[0];
		wagentypen = new Wagen[3];
		wagentypen[0] = new Wagen(10, 20);
		wagentypen[1] = new Wagen(20, 40);
		wagentypen[2] = new Wagen(30, 60);
		lokomotivenTypen = new Lokomotive[3];
		lokomotivenTypen[0] = new Lokomotive(10, 1);
		lokomotivenTypen[1] = new Lokomotive(20, 2);
		lokomotivenTypen[2] = new Lokomotive(30, 3);
	}

	public void addZug(String eingabe) {
		Zug[] neueListe = new Zug[zuge.length+1];
		System.arraycopy(zuge, 0, neueListe, 0, zuge.length);
		zuge = neueListe;
		zugAnzahl++;
		switch(eingabe){
		case "1":zuge[zuge.length-1] = new Zug(lokomotivenTypen[0].getLange(),lokomotivenTypen[0].getTyp());break;
		case "2":zuge[zuge.length-1] = new Zug(lokomotivenTypen[1].getLange(),lokomotivenTypen[1].getTyp());break;
		case "3":zuge[zuge.length-1] = new Zug(lokomotivenTypen[2].getLange(),lokomotivenTypen[2].getTyp());break;
		default:System.out.println("Dieser typ existiert nicht");zugAnzahl--;break;
		}
	}

	public int getZugAnzahl() {
		return zugAnzahl;
	}

	public void lokomotivenTypenAusgabe() {
		for (int i = 0; i < lokomotivenTypen.length; i++) {
			System.out.println("Lokomotive " + (i+1) + "|Typ = " + lokomotivenTypen[i].getTyp() + "|Lange = "
					+ lokomotivenTypen[i].getLange());
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String eingabe;
		boolean simulationsState = true;
		Bahnhof bahnhof = new Bahnhof();
		System.out.println("Wilkomen in der Simulation bitte wahlen sie eine Lokomotiven typ fuer euren ersten Zug");
		bahnhof.lokomotivenTypenAusgabe();
		eingabe = input.nextLine();
		bahnhof.addZug(eingabe);
		while (simulationsState == true){
			System.out.println("Sie haben momentan " + bahnhof.getZugAnzahl()
					+ " Zuge im Bahnhof.\n Bitte gebben sie ein was sie machen wollen(ENDE,ADDZUG,ADDWAGEN,ENTFERNEZUG,ENTFERNEWAGEN,ZUGDATEN):");
			eingabe = input.nextLine();
			switch(eingabe){
			case "ENDE":simulationsState = false;break;
			case "ADDZUG":System.out.println("Wahlen sie Lokomotiven typ: ");
			bahnhof.lokomotivenTypenAusgabe();
			eingabe = input.nextLine();
			bahnhof.addZug(eingabe);break;
			//case "ZUGDATEN":System.out.println
			}
		}
		input.close();
	}
}
