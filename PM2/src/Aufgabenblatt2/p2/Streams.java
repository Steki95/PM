package Aufgabenblatt2.p2;

import java.util.Arrays;

public class Streams {
	
	private String[] array;
	
	public Streams(String... array) {
		this.array = array;
	}
	
	public void setArray(String...array){
		this.array = array;
	}
	
	public String[] apply(){
	
	return Arrays.stream(array).filter(e -> e!=null)
		.map(String::trim)
		.map(String::toUpperCase)
		.map(s -> s.replaceAll("�", "AE"))
		.map(s -> s.replaceAll("�", "OE"))
		.map(s -> s.replaceAll("�", "UE"))
		.map(s -> s.replaceAll("�", "SS"))
		.map(s -> s.length() > 7 ? s.substring(0,8):s)
		.toArray(String[]::new);
	}
	 
}
