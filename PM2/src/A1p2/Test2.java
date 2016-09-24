package A1p2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test2 {

	/**
	 * Testet ob XmlLeser richtig liest
	 */
	@Test
	public void testXmlLeser() {

		XmlLeser leser = new XmlLeser("./src/Resources/Sensor.xml");
		Sensor sensor = leser.getSensor();
		List<Messung> messungen;
		messungen = sensor.getMessungen();
		double losungen[] = { 23.2, 24.5 };
		double test;
		for (int i = 0; i < messungen.size(); i++) {
			test = messungen.get(i).getWert();
			assertEquals(losungen[i], test, 0.001);
		}
	}

	/**
	 * Testet ob XmlSchreiber ein richtiges dokument kreiert
	 */
	@Test
	public void testXmlSchreiber() {
		XmlSchreiber schreiber = new XmlSchreiber();
		List<Messung> messungen = new ArrayList<Messung>();
		messungen.add(new Messung(6.0, LocalDateTime.now()));
		messungen.add(new Messung(6.0, LocalDateTime.now()));
		Sensor sensor = new Sensor("Test", messungen);
		schreiber.sensorLaden(sensor);
		schreiber.schreiben("./src/Resources/Test.xml");
		XmlLeser leser = new XmlLeser("./src/Resources/Test.xml");
		Sensor sensor2 = leser.getSensor();

		assertEquals("Test", sensor2.getId());
	}

}
