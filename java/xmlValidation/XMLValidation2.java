package xmlValidation;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLValidation2 {
    private static boolean validateXML(String xmlFile) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(null);
            builder.parse(xmlFile);

            if (true) {
                System.out.println("Passed Validation");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void parseXMLWithDOM(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            String vName = ((org.w3c.dom.Document) document).getElementsByTagName("name").item(0).getTextContent();
            System.out.println("Venue name: " + vName);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        String xmlFile = "C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\target\\venues.xml";
        boolean isValid = validateXML(xmlFile);

        if (isValid) {
            parseXMLWithDOM(xmlFile);
        }
    }
}
