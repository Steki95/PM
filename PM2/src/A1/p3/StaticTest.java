package A1.p3;

public class StaticTest {
   
	public static boolean testErstesElementIstNummer(ArrayListe<?> liste){
		if (liste.get(0)!= null && liste.get(0) instanceof Number) {
			return true;
		}
		return false;
	}
}
