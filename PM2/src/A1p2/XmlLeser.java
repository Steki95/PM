package A1p2;

/**
 * Praktikum TIPR2, WS 2016 Gruppe: Stefan Belic (stefan_belic@haw.de) 
 * Dennis Bopp (dennis.bopp@haw-hamburg.de) 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 */

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlLeser {
	
	/**
	 * Das Dokument mit welchem wir arbeiten
	 */
	private Document document;

	/**
	 * Offnet ein xml Dokument unter filename
	 * 
	 * @param filename
	 *            wo sich das file befindet
	 */
	public XmlLeser(String filename) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		factory.setValidating(true);

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			document = builder.parse(new File(filename));
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Erschaft ein Sensor Objekt anhand aller Daten in dem Xml und gibt es
	 * zurueck
	 * 
	 * @return das Sensor Objekt das kreiert wurden ist
	 */
	public Sensor getSensor() {
		// Deklaration alle Variabeln die benoetigt werden
		NodeList nodeList = document.getElementsByTagName("Sensor");
		Node node;
		Element element;
		List<Messung> messungen = new ArrayList<Messung>();
		double wert;
		LocalDateTime zeitstempel;
		String id;

		// Node wird gleich Sensor node und
		// unter id wird die id des sensors geschpeichert
		
		node = nodeList.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE){
			element = (Element) node;
			id = element.getAttribute("id");
			// Wenn der sensor messungen hatt werden sie hier gelesen und
			// hizugefugt
			if (node.hasChildNodes()) {
				// eine Nodeliste aller messungen erstellen
				nodeList = node.getChildNodes();
				// string des wertes so das ich , mit . austauschen kann
				String wertString;
				// Durch alle messungen gehen und die messungen liste fullen
				for (int i = 0; i < nodeList.getLength(); i++) {
					node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						element = (Element) node;
						wertString = element.getAttribute("wert");
						wertString = wertString.replace(',', '.');
						wert = Double.parseDouble(wertString);
						zeitstempel = LocalDateTime.parse(element.getAttribute("zeitstempel"));
						messungen.add(new Messung(wert, zeitstempel));
					}
				}
				// Den fertigen Sensor zuruckgeben
				return new Sensor(id, messungen);
			} 
		}
		return null;
	}

}
