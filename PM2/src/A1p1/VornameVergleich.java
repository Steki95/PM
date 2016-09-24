package A1p1;

import java.util.Comparator;

public class VornameVergleich implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		
		String vorname1 = student1.getVorname();
		String vorname2 = student2.getVorname();
		
		return vorname1.compareTo(vorname2);
	}

}
