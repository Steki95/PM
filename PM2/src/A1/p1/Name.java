package A1.p1;

import java.util.Comparator;

public class Name implements Comparator<Student> {

	public int compare(Student student1, Student student2) {

		String vorname1 = student1.getVorname();
		String vorname2 = student2.getVorname();
		String nachname1 = student1.getNachname();
		String nachname2 = student2.getNachname();

		if (nachname1.equals(nachname2)) {
			return vorname1.compareTo(vorname2);
		}
		return nachname1.compareTo(nachname2);
	}
}
