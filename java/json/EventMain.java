package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EventMain {

    public static void main(String[] args) {

        EventJson event = new EventJson();
        event.setEventId(7);
        event.setEventName("Taylor Swift Eras Tour");
        event.setEventDate(Timestamp.valueOf("2023-6-23 00:00:00"));


        EventJson event2 = new EventJson();
        event2.setEventId(8);
        event2.setEventName("Phantom of the Opera");
        event2.setEventDate(Timestamp.valueOf("2023-07-18 00:00:00"));


        List<EventJson> eventsList = new ArrayList<>();
        eventsList.add(event);
        eventsList.add(event2);
        System.out.println("Event list: " + eventsList);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //Serialize Events Object to String
            String serializeEvent = objectMapper.writeValueAsString(event);
            System.out.println("Serialized event  " + serializeEvent);
            String getDateOnly = objectMapper.writeValueAsString(event.getEventDate().toString());

            System.out.println("Print event date only- " + getDateOnly);

            //Deserialize String event to Object
            EventJson deserializeEvent = objectMapper.readValue(serializeEvent, EventJson.class);
            System.out.println("DeserializedEvent " + deserializeEvent);

            //Serialize eventsList Object to String
            String stringEventList = objectMapper.writeValueAsString(eventsList);
            System.out.println("Serialized list- " + stringEventList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
