package Aufgabenblatt1;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
	
	private String vorname;//Vorname des Studenten
	private String nachname;//Nachname des Studenten
	private int martikelnummer;//Martikelnummer des Studenten
	List<Pruefungsleistung> list;//Liste alle pruefungsleistungen des Studentens fuer alle facher
	
	public Student(String vorname,String nachname,int martikelnummer,List<Pruefungsleistung> list){
		this.vorname = vorname;
		this.nachname = nachname;
		this.martikelnummer = martikelnummer;
		this.list = list;
	}
	public String getVorname() {
		return vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public int getMartikelnummer() {
		return martikelnummer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + martikelnummer;
		return result;
	}
	//Vergleicht anhand der martikelnummer
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (martikelnummer != other.martikelnummer)
			return false;
		return true;
	}
	@Override
	public int compareTo(Student obj) {
		return Integer.compare(this.martikelnummer, obj.getMartikelnummer());
	}
	
}
