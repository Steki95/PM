package A1p1;

import java.util.Comparator;

public class NachnameVergleich implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		String nachname1 = student1.getNachname();
		String nachname2 = student2.getNachname();

		return nachname1.compareTo(nachname2);
	}

}
