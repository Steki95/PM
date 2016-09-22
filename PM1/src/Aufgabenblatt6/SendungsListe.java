package Aufgabenblatt6;

import java.util.*;

public class SendungsListe {

	private List<Sendung> sendungen;
	private PersonenListe personenListe;
	private SendungsdauerSchaetzer schaetzer;

	/**
	 * @param simulationsZeit
	 * @param schaetzer
	 */
	public SendungsListe(int simulationsZeit, SendungsdauerSchaetzer schaetzer) {
		sendungen = new ArrayList<Sendung>();
		personenListe = new PersonenListe();
		this.schaetzer = schaetzer;
		for (int i = 0; i < 20; i++) {
			sendungen.add(sendungErzeugen(simulationsZeit));
		}

	}

	/**
	 * Erzeugt eine neue randomisierte Sendung mit hilfe von Math.rand() und
	 * fuegt es denn Array hinzu
	 * 
	 * @param simulationsZeit die zeit in der simulation
	 * @return
	 */
	public Sendung sendungErzeugen(int simulationsZeit) {
		// Randomisiert den sendungsTyp,sender und empfanger
		Sendung neueSendung = null;
		int sendungsTyp = (int) (Math.random() * 2);
		int personen1Index = (int) (Math.random() * personenListe.getLange());
		int personen2Index;
		
		do {
			personen2Index = (int) (Math.random() * personenListe.getLange());
		} while (personen2Index == personen1Index); // sucht eine person die ungleich der ersten ist
		String string = "";
		int transportDauer = schaetzer.getSendungsTransportDauer(personenListe.getOrt(personen1Index),
				personenListe.getOrt(personen2Index)); // findet die transport
														// dauer
		Person sender = personenListe.getPerson(personen1Index); // holt den
																	// sender
		Person empfanger = personenListe.getPerson(personen2Index); // holt den
																	// empfanger

		// Kreiert anhang des sendungsTyp ein brief oder paket
		switch (sendungsTyp) {
		case 0:
			boolean einschreiben;
			if((int)Math.random()*2 == 0){
				einschreiben = true;
			}
			else{
				einschreiben = false;
			}
			neueSendung = new Brief(sender, empfanger, simulationsZeit, transportDauer, einschreiben);
			string += "Brief ";
			break;
		case 1:
			int gewicht = ((int)Math.random()*5)+1;
			neueSendung = new Paket(sender, empfanger, simulationsZeit, transportDauer, gewicht);
			string += "Paket ";
			break;
		}
		// Sagt das die sendung kreiert wurden ist
		string += personenListe.getOrt(personen1Index) + ">" + personenListe.getOrt(personen2Index) + "(Start:"
				+ simulationsZeit + " Dauer:" + transportDauer + ") erzeugt";
		System.out.println(string);
		return neueSendung;
	}

	/**
	 * Aktualisiert die zeit fuer jede Sendung
	 * 
	 * @param simulationsZeit
	 */
	public void sendungenAktualisieren(int simulationsZeit) {
		for (int i = 0; i < sendungen.size(); i++) {
			sendungen.get(i).aktualisiereZeitpunk(simulationsZeit);
			System.out.println(sendungen.get(i).toString());
		}
	}

	/**
	 * Wenn eine Sendung ausgeliefert woerden ist kreiert man eine neue und
	 * fuegt man sie im array statt der fertigen Sendung hinzu
	 * 
	 * @param simulationsZeit
	 */
	public void sendungenAustauschen(int simulationsZeit) {
		sendungenAktualisieren(simulationsZeit);
		for (int i = 0; i < sendungen.size(); i++) {
			if (sendungen.get(i).istAusgeliefert() == true) {
				sendungen.remove(i);
				sendungen.add(sendungErzeugen(simulationsZeit));
				i--;
			}
		}
	}

	public void personHinzufugen(Scanner input) {
		// variabeln der adresse
				String strasse;
				int hausnummer;
				int posleitzahl;
				Staedte ort;

				// Eingabe aller daten
				System.out.println("Wie lautet der Strassenname: ");
				strasse = input.next();
				System.out.println("Wie lautet die Hausnummer: ");
				hausnummer = input.nextInt();
				System.out.println("Wie lautet die posleitzahl: ");
				posleitzahl = input.nextInt();
				do {
					System.out.println("Wie lautet der ort(Bsp: Hamburg): ");
					ort = Staedte.BERLIN;
					ort = ort.toEnum(input.next().trim().toUpperCase());
					if (ort == null) {
						System.out.println("Eingabe is fehlerhaft!");
					}
				} while (ort == null);// wiederholt bis man keinen ort eingibt der
										// existiert
		personenListe.personHinzufugen(new Person(new Adresse(strasse, hausnummer, posleitzahl, ort)));

	}

}
