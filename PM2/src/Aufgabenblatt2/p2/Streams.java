package Aufgabenblatt2.p2;

import java.util.Arrays;

public class Streams {
	
	/**
	 * Der array wo wir alle string speichern
	 */
	private String[] array;
	/**
	 * Anzahl der strings im array
	 */
	private int arrayPos;
	
	public Streams() {
		array = new String[2];
		arrayPos = 0;
	}
	/**
	 * Fugt ein neuen string dem array hinzu
	 * @param newString neuer string den wir hinzufugen
	 */
	public void addString(String newString){
		if(arrayPos == array.length){
			String[] new_array = new String[arrayPos*2];
			System.arraycopy(array, 0, new_array, 0, arrayPos);
			array = new_array;
		}
		array[arrayPos] = newString;
		arrayPos++;
	}
	/**
	 * Loschen alle eintrage in dem array
	 */
	public void clearString(){
		arrayPos = 0;
		array = new String[2];
	}
	/**
	 * Wir setzen den array sofort gleich einen anderen array 
	 * @param array Der array denn wir bearbeiten wollen
	 */
	public void setArray(String...array){
		this.array = array;
	}
	
	
	/**
	 * Nimmt denn array und mit hilfe von streams entfernen wir alle null strings,
	 * alle extra lehrzeichen vor und nach dem string, machen alle buchstaben gross buchstaben,
	 * erstetzen alle umlaute und setzen die lange des strings auf 7
	 * @return Der bearbeitete string
	 */
	public String[] apply(){
	
	return Arrays.stream(array).filter(e -> e!=null)
		.map(String::trim)
		.map(String::toUpperCase)
		.map(s -> s.replaceAll("Ä", "AE"))
		.map(s -> s.replaceAll("Ö", "OE"))
		.map(s -> s.replaceAll("Ü", "UE"))
		.map(s -> s.replaceAll("ß", "SS"))
		.map(s -> s.length() > 7 ? s.substring(0,8):s)
		.toArray(String[]::new);
	}
	 
}
