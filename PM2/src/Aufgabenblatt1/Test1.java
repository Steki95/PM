package Aufgabenblatt1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void testMethodeHashUndEquals(){
		
		//Kreirung der prufungsleistungen nur fuer testen
		List<Pruefungsleistung> leistungen = new ArrayList<Pruefungsleistung>();
		leistungen.add(new Pruefungsleistung("Mathe",2.2));
		//Kreirung der studenten
		Student student1 = new Student("Belic","Stefan",22,leistungen);
		Student student2 = new Student("Bopp","Etwas",23,leistungen);
		Student student3 = new Student("Student","Drei",23,leistungen);
		//Sicherstellen ob student1 und student2 verschiedene martikelnummern haben
		assertFalse(student1.equals(student2));
		//Sicherstellen ob student3 und student2 gleiche martikelnummern haben
		assertTrue(student2.equals(student3));
		
	}
	
	@Test
	public void testMethodeComparable(){
		//Kreirung der prufungsleistungen nur fuer testen
		List<Pruefungsleistung> leistungen = new ArrayList<Pruefungsleistung>();
		leistungen.add(new Pruefungsleistung("Mathe",2.2));
		//Kreirung einer liste von alle studenten mit martikel nummer von hochsten bis kleinsten
		List<Student> studentenliste = new ArrayList<Student>();
		studentenliste.add(new Student("Belic","Stefan",3,leistungen));
		studentenliste.add(new Student("Belic","Stefan",2,leistungen));
		studentenliste.add(new Student("Belic","Stefan",1,leistungen));
		studentenliste.add(new Student("Belic","Stefan",0,leistungen));
		//Sortieren der studenten von kleinste bis hochste martikel numer
		Collections.sort(studentenliste);
		//testen ob sich die liste gedreht hatt
		for(int i = 0;i<4;i++){
			assertEquals(studentenliste.get(i).getMartikelnummer(),i);
		}
		
	}

}
