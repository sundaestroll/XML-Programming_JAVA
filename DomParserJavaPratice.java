package DomParser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserJavaPratice {

	public static void main(String[] args) {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder builder	= factory.newDocumentBuilder();
		Document doc = builder.parse("movie.xml");
		NodeList movieList = doc.getElementsByTagName("movie");
		for (int i=0; i<movieList.getLength();i++) {
			Node m= movieList.item(i);
			if(m.getNodeType()== Node.ELEMENT_NODE) {
				Element movie = (Element) m;
				String id = movie.getAttribute("id");
				NodeList titleList = movie.getChildNodes();
				for (int j=0;j<titleList.getLength();j++) {
					Node t = titleList.item(j);
					if(t.getNodeType()== Node.ELEMENT_NODE) {
						Element title = (Element) t;
						System.out.println("Movie" + id + ":" + title.getTagName()+ "=" + title.getTextContent());
					}
				}
			}
		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
