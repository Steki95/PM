package Aufgabenblatt1;

public class Pruefungsleistung {
	
	private String modulName;
	private double note;
	
	public Pruefungsleistung(String modulName,double note){
		this.modulName = modulName;
		this.note = note;
	}
	
	public String getModulName() {
		return modulName;
	}
	public void setModulName(String modulName) {
		this.modulName = modulName;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}

}