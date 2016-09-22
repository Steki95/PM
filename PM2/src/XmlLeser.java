package Aufgabenblatt1;

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
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public XmlLeser(String filename){
		factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			document = builder.parse(new File(filename));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Sensor getSensor(){
		NodeList nodeList = document.getElementsByTagName("Sensor");
		Node node;
		Element element;
		List<Messung> messungen = new ArrayList<Messung>();
		double wert;
		LocalDateTime zeitstempel;
		int id;
		
		node = nodeList.item(0);
		element = (Element)node;
		id = Integer.parseInt(element.getAttribute("id"));
		if(node.hasChildNodes()){
			nodeList = node.getChildNodes();
				for(int i = 0;i < nodeList.getLength(); i++){
						node = nodeList.item(i);
							if (node.getNodeType() == Node.ELEMENT_NODE) {
								element = (Element)node;
								wert = Double.parseDouble(element.getAttribute("wert"));
								zeitstempel = LocalDateTime.parse(element.getAttribute("zeitstempel"));
								messungen.add(new Messung(wert,zeitstempel));
							}
				}
				return new Sensor(id,messungen);
		}
		else{
			return null;
		}
		
	}

}
