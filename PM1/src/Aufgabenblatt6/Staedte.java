package Aufgabenblatt6;

public enum Staedte {
	BERLIN, HAMBURG, MUENCHEN, KOELN, FRANKFURT, STUTTGART, DUESSELDORF, DORTMUND, ESSEN, BREMEN;

	/**
	 * Gibt einen enum zuruck abhengig davon was im string stand
	 * 
	 * @param string
	 *            string welchen man verwandelt
	 * @return der enum der denn String passt ANSONSTEN null
	 */
	public Staedte toEnum(String string) {
		switch (string) {
		case "BERLIN":
			return BERLIN;
		case "HAMBURG":
			return HAMBURG;
		case "MUENCHEN":
			return MUENCHEN;
		case "KOELN":
			return KOELN;
		case "FFRANKFURT":
			return FRANKFURT;
		case "STUTTGART":
			return STUTTGART;
		case "DUESSELDORF":
			return DUESSELDORF;
		case "DORTMUND:":
			return DORTMUND;
		case "ESSEN":
			return ESSEN;
		case "BREMEN":
			return BREMEN;
		default:
			return null;
		}
	}
}
