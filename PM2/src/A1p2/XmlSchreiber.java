package A1p2;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
 */

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
	
	/**
	 * Dokument welches wir spaeter speichern
	 */
	private Document document;
	/**
	 * DokumentBuilder des Dokuments
	 */
	private DocumentBuilder builder;

	/**
	 * Erstellt einen DokumentBuilder
	 */
	public XmlSchreiber() {
		DocumentBuilderFactory factory;
		factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Nimmt ein Sensor als Argument und erstellt einen Nodebaum anhand seiner Daten
	 * in document
	 * 
	 * @param sensor
	 *            der Sensor denn wir als Xml schreiben wollen
	 */
	public void sensorLaden(Sensor sensor) {
		// Neues dokument erstellen
		document = builder.newDocument();
		// Das sensor element erstellen und ihn ein atribut geben
		Element sensorElement = document.createElement("Sensor");
		document.appendChild(sensorElement);
		sensorElement.setAttribute("id", sensor.getId());
		// Alle variabeln notwending fuer ein Messungs element wie auch ein wert
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
	 * Wir kreiern ein neues file unter filename
	 * 
	 * @param filename
	 *            Position wo wir unsere neue file haben wollen
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
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
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
