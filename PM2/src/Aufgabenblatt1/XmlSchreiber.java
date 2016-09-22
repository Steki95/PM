package Aufgabenblatt1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSchreiber {

	private Document document;// Dokument welches wir spater speicher
	private DocumentBuilderFactory factory;// DocumentBuilderFactory des
											// dokumentes
	private DocumentBuilder builder;// DokumentBuilder des dokumentes

	/*
	 * @ einen builder erstellen
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

	/*
	 * @ Einen Dokument baum erstellen anhang der daten des Sensors der alts
	 * argument gegeben ist
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
			messungElement.setAttribute("wert", wert);
			zeitstempel = messung.getZeitstempel().toString();
			messungElement.setAttribute("zeitstempel", zeitstempel);
			// An sensor anhengen
			sensorElement.appendChild(messungElement);
		}
	}

	/*
	 * @ Wir speichern das kreirte dokument unter filename
	 */
	public void schreiben(String filename) {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;

		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}

		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(filename));

		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
