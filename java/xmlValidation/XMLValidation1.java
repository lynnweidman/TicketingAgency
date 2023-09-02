package xmlValidation;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidation1 {

    public static boolean validateXML(String xmlFile, String xsdFile) throws ParserConfigurationException, IOException, SAXException {

        // parse an XML document into a DOM tree
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new File(xmlFile));

        // create a SchemaFactory capable of understanding WXS schemas
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // load a WXS schema, represented by a Schema instance
        Source schemaFile = new StreamSource(new File(xsdFile));
        Schema schema = factory.newSchema(schemaFile);


        // create a Validator instance, which can be used to validate an instance document
        Validator validator = schema.newValidator();


        // validate the DOM tree
        try {
            validator.validate(new DOMSource(document));
            if (true) {
                System.out.println("Valid");
            }
            return true;

        } catch (SAXException e) {
            // instance document is invalid!
            return false;
        }

    }

    //Retrieving data with DOM
    private static void parseXMLWithDOM(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            String vName = ((org.w3c.dom.Document) document).getElementsByTagName("name").item(0).getTextContent();
            String vName2 = ((org.w3c.dom.Document) document).getElementsByTagName("name").item(1).getTextContent();
            System.out.println("Venue name: " + vName + "\n" + "Venue name: " + vName2);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlFile = "C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\target\\venues.xml";
        String xsdFile = "C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\target\\venues.xsd";
        boolean isValid = validateXML(xmlFile, xsdFile);

        if (isValid) {
            parseXMLWithDOM(xmlFile);
        }
    }

}





