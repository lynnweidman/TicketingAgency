package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketMain {

    public static void main(String[] args) {

        File ticketsFile = new File("C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\target\\tickets.json");

        TicketsJson tickets = new TicketsJson();
        tickets.setTicketId(1);
        tickets.setTicketSoldDate(new Date());
        tickets.setEventId(1);

        TicketsJson tickets2 = new TicketsJson();
        tickets2.setTicketId(2);
        tickets2.setTicketSoldDate(new Date());
        tickets2.setEventId(1);

        List<TicketsJson> listTickets = new ArrayList<>();
        listTickets.add(tickets);
        listTickets.add(tickets2);
        System.out.println("Ticket list: " + listTickets);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //Serialize Ticket Object to String
            String stringTicket = objectMapper.writeValueAsString(tickets);
            System.out.println("Print the ticket  " + stringTicket);
            String ticketId = objectMapper.writeValueAsString(tickets.getTicketId());

            System.out.println("Print ticket Id- " + ticketId);

            //Deserialize String ticket to Object
            TicketsJson deserializer = objectMapper.readValue(stringTicket, TicketsJson.class);
            System.out.println("Deserialized TicketsJSON: " + deserializer);

            //Serialize listTickets Object to String
            String stringList = objectMapper.writeValueAsString(listTickets);
            System.out.println("Serialized list- " + stringList);

            //Write to the file
            objectMapper.writeValue(ticketsFile, stringTicket);
            objectMapper.writeValue(ticketsFile, stringList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}