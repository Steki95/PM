package A1p2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class XmlSchreiber {

	private Document document;// Dokument welches wir spater speicher
	private DocumentBuilderFactory factory;// DocumentBuilderFactory des
											// dokumentes
	private DocumentBuilder builder;// DokumentBuilder des dokumentes

	/**
	 * Erstelt ein DokumentBuilder
	 */
	public XmlSchreiber() {
		factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Nimmt ein Sensor als argument und erselt ein Node baum anhang seine daten
	 * unter document
	 * 
	 * @param sensor
	 *            der sensor anhand wenn wir das dokument bauen
	 */
	public void sensorLaden(Sensor sensor) {
		// Neues dokument erstellen
		document = builder.newDocument();
		// Das sensor element erstellen und ihn ein atribut geben
		Element sensorElement = document.createElement("Sensor");
		document.appendChild(sensorElement);
		sensorElement.setAttribute("id", sensor.getId());
		// Alle variabeln notwending fuer ein Wert element wie auch ein wert
		// element
		Element messungElement;
		String wert;
		String zeitstempel;
		Messung messung;
		// Wir gehen durch alle messungen des sensors durch und
		// Kreiren messungElemente die wir an sensorElement anhangen
		for (int i = 0; i < sensor.getMessungen().size(); i++) {
			// Messung element kreiren
			messung = sensor.getMessungen().get(i);
			messungElement = document.createElement("Messung");
			// Attribute seten
			wert = String.valueOf(messung.getWert());
			wert = wert.replace('.', ',');
			messungElement.setAttribute("wert", wert);
			zeitstempel = messung.getZeitstempel().toString();
			messungElement.setAttribute("zeitstempel", zeitstempel);
			// An sensor anhengen
			sensorElement.appendChild(messungElement);
		}
	}

	/**
	 * Wir kreiern ein neues file auf filename
	 * 
	 * @param filename
	 *            position wo wir unser neuen file haben wollen auf den
	 *            kompjuter
	 */
	public void schreiben(String filename) {
		// Transformer und TransformerFactory kreiren
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}

		// alles auf neue linie schreiben
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		// <!DOCTYPE> hinzufugen
		DOMImplementation domImpl = document.getImplementation();
		DocumentType doctype = domImpl.createDocumentType("doctype", "-//Oberon//YOUR PUBLIC DOCTYPE//EN",
				"Sensor.dtd");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());

		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(filename));
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
