package myBatis;

import mapper.EventMapperJava;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;


public class EventsMyBatisRunner {
    public static void main(String[] args) throws IOException {

        //Open Session for use with XML.
       /* try (InputStream inputStream = Resources.getResourceAsStream("myBatisConfig.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
*/
        //Open Session for use with Interface and annotations.
        try (InputStream inputStream = Resources.getResourceAsStream("myBatisConfig.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            EventMapperJava eventMapperJava = session.getMapper(EventMapperJava.class);



            //Select event by id using XML
           /*Event events = session.selectOne("mapper.EventsMapper.selectEventById", 9);
            System.out.println("Event from DB:\n" + events);
*/

            //getAllEvents using Interface and annotations
           // List<Event> eventList =  eventMapperJava.getAllEvents();
           // System.out.println(eventList);

            //Get event by id using Interface and annotations
           // Event event = eventMapperJava.getById(7);
            //System.out.println("Event with Interface:\n" + event);


            //Update event using Interface and annotations
            //Event event1 = eventMapperJava.getById(9);
            //System.out.println("Current Event Name:  "+ event1);

            //Update eventName
           /* event1.setEventName("Monster Trucks Tour");

            //Update the event record using Interface and annotations
            eventMapperJava.update(event1);
            System.out.println("Record updated successfully" );
            session.commit();

            //Show the updated record
            Event event2 = eventMapperJava.getById(9);
            System.out.println(event2);*/


            //Insert using Interface and annotations
           /* Event event1 = new Event();
            event1.setEventName("Taylor Swift Tour");
            event1.setEventDate(LocalDateTime.parse("2023-06-30T00:00:00"));
            event1.setEventTypeId(1);
            event1.setVenueId(4);

            eventMapperJava.insert(event1);
            System.out.println("Inserted event:\n" + event1);
            session.commit();*/

        }
    }
}












