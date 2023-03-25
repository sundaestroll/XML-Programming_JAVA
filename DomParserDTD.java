package DomParser;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class DomParserDTD {

    public static boolean validate(String xmlFilePath, String dtdFilePath) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setValidating(true);
            documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");

            DocumentBuilder parser = documentBuilderFactory.newDocumentBuilder();
            parser.setErrorHandler(null);

            Document doc = parser.parse(new File(xmlFilePath));
            doc.getDocumentElement().normalize();

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
