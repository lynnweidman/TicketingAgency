package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class EventOrganizerMain {

    public static void main(String[] args) {

        EventOrganizerJson eventOrganizer = new EventOrganizerJson();
        eventOrganizer.setEventOrganizerId(1);
        eventOrganizer.setEventOrganizerName("Jane Smith");
        eventOrganizer.setEventOrganizerPhone("333-333-5555");
        eventOrganizer.setEventOrganizerEmail("janeSmith@gmail.com");
        eventOrganizer.setEventId(5);

        EventOrganizerJson eventOrganizer2 = new EventOrganizerJson();
        eventOrganizer2.setEventOrganizerId(2);
        eventOrganizer2.setEventOrganizerName("Paul Jones");
        eventOrganizer2.setEventOrganizerPhone("333-333-6666");
        eventOrganizer2.setEventOrganizerEmail("paulJones@gmail.com");
        eventOrganizer2.setEventId(5);

        List<EventOrganizerJson> listEventOrganizers = new ArrayList<>();
        listEventOrganizers.add(eventOrganizer);
        listEventOrganizers.add(eventOrganizer2);
        System.out.println("Event Organizers list: " + listEventOrganizers);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //Serialize eventOrganizer Object to String
            String serializeEventOrganizer = objectMapper.writeValueAsString(eventOrganizer);
            System.out.println("Serialized event organizer  " + serializeEventOrganizer);


            String serializeEventOrganizerList = objectMapper.writeValueAsString(listEventOrganizers);

            System.out.println("Serialized listEventOrganizers - " + serializeEventOrganizerList);

            //Deserialize String eventOrganizerList to Object
            EventOrganizerJson deserializeEventOrganizerList = objectMapper.readValue(serializeEventOrganizer, EventOrganizerJson.class);
            System.out.println("Deserialized eventOrganizerByIndex " + deserializeEventOrganizerList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
