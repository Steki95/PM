package Aufgabenblatt2.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flughafen extends Thread {
	
	/**
	 * Die anzahl der flugzeuge die gerade flieged und landen
	 */
	private int anzahlFlugzeugen;
	/**
	 * eine liste mit allen flugzeugen
	 */
	private List<Flugzeug> flugzeuge;
	
	public Flughafen(int anzahlFlugzeugen){
		this.anzahlFlugzeugen = anzahlFlugzeugen;
		flugzeuge = new ArrayList<Flugzeug>();
	}
	/**
	 * Eine synchronized funktion die ein flugzeug nach 1500 ms landet und deren
	 * status wechselt
	 * @param flugzeug flugzeug der gerade landet
	 */
	public synchronized void landen(Flugzeug flugzeug){
		flugzeug.setStatus(Status.IM_LANDEANFLUG);
		try {
			sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flugzeug.setStatus(Status.GELANDET);
		System.out.println("	Flugzeug gelandet -> " + flugzeug.toString());
		flugzeuge.remove(flugzeug);
	}
	/**
	 * Erzeugt ein neues flugzeug objekt und startet den thread
	 * @return
	 */
	public Flugzeug erzeugeFlugzeug(){
		Random random = new Random();
		String id;
		id = "Flugzeug";
		// Gibt eine randomasierte flugmarke
		switch(random.nextInt(5)){
		case 0:id+=" Lufthansa";break;
		case 1:id+=" Luftbus";break;
		case 2:id+=" Airserbia";break;
		case 3:id+=" Germanwings";break;
		case 4:id+=" Piloto";break;
		}
		//Gibt eine randomasierte id zwischen 0 und 2999
		id += " "+random.nextInt(3000);
		Flugzeug flugzeug = new Flugzeug(id,this,random.nextInt(20)+1);
		System.out.println("	Neues Flugzeug erstelt -> " + flugzeug.toString());
		flugzeug.start();
		return flugzeug;
	}
	/**
	 * Die haupt methode des threads. Eine endloss schleiffe die ein flugzeug erstellt 
	 * wenn es nicht genugt gibt
	 */
	@Override
	public void run(){
		int zeit = 1;
		System.out.println("FLUGHAFEN WURDE GESTARTET");
		while(flugzeuge.size() < anzahlFlugzeugen){
			flugzeuge.add(erzeugeFlugzeug());
		}
		while(true){
			System.out.println("ZEIT: "+zeit);
			if(flugzeuge.size() < anzahlFlugzeugen){
				flugzeuge.add(erzeugeFlugzeug());
			}
			for(int i=0;i<anzahlFlugzeugen;i++){
				try{
					flugzeuge.get(i).tick();
					if(!flugzeuge.get(i).istGelandet()){
						System.out.println("	"+flugzeuge.get(i).toString());
					}
				}
				catch(Exception e){
					
				}
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zeit++;
		}
	}
}
