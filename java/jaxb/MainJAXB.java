package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.Event;

import java.io.File;
import java.time.LocalDateTime;

public class MainJAXB {


    public static void main(String[] args) {

        try {
            Event events1 = new Event();
            events1.setEventId(100);
            events1.setEventName("Cats");
            events1.setEventDate(LocalDateTime.parse("2023-09-10T00:00:00"));
            events1.setEventTypeId(4);
            events1.setVenueId(15);

            File file = new File("src\\main\\resources\\eventsJaxB.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance((Event.class));

            //Marshalling
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(events1, file);
            System.out.println("Marshalling Event\n");
            jaxbMarshaller.marshal(events1, System.out);

            //Unmarshalling
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Event eventUnmarshalled = (Event) jaxbUnmarshaller.unmarshal(new File("src\\main\\resources\\eventsJaxB.xml"));

            System.out.println("Event unmarshalled " + eventUnmarshalled);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
