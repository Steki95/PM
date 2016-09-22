package Aufgabenblatt1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import java.time.LocalDateTime;

public class Test2 {

	/*@
	 * Testen ob der Leser richtig das dokuments liest
	 */
	@Test
	public void testXmlLeser() {
		XmlLeser leser = new XmlLeser("./src/Aufgabenblatt1/Sensor.xml");
		Sensor sensor = leser.getSensor();
		List<Messung> messungen;
		messungen = sensor.getMessungen();
		double losungen[] = { 23.2, 24.5 };
		for (int i = 0; i < messungen.size(); i++) {
			System.out.println(losungen[i]);
			System.out.println(messungen.get(i).getWert());
		}
	}
	/*@
	 * Testen ob der Schreiber richtig dokumente schreibt
	 */
	@Test
	public void testXmlSchreiber() {
		XmlSchreiber schreiber = new XmlSchreiber();
		List<Messung> messungen = new ArrayList<Messung>();
		messungen.add(new Messung(2.0, LocalDateTime.now()));
		messungen.add(new Messung(2.0, LocalDateTime.now()));
		Sensor sensor = new Sensor("Test", messungen);
		schreiber.sensorLaden(sensor);
		schreiber.schreiben("./src/Aufgabenblatt1/Test.xml");
		XmlLeser leser = new XmlLeser("./src/Aufgabenblatt1/Test.xml");
		Sensor sensor2 = leser.getSensor();

		assertEquals("Test", sensor2.getId());
	}

}
