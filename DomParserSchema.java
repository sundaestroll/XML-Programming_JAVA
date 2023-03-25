package DomParser;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;

public class DomParserSchema {

    public static void main(String[] args) {
        String xmlFilePath = "movie.xml";
        String xmlSchemaFilePath = "movie.xsd";

        try {
     
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setNamespaceAware(true);
            docBuilderFactory.setValidating(false);
            docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

     
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

    
            Document doc = docBuilder.parse(new File(xmlFilePath));


            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xmlSchemaFilePath));

            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(doc));


            System.out.println("Validation successful.");
        } catch (Exception e) {
      
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}
