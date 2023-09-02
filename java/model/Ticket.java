package model;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


//Class using JASON
public class Ticket {
     @JsonProperty("ticketId")
    private int ticketId;

    @JsonProperty("ticketSoldDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss")
    private Timestamp ticketSoldDate;

    @JsonProperty("eventId")
    private int eventId;

    public Ticket(int ticketId, Timestamp ticketSoldDate, int eventId) {
        this.ticketId = ticketId;
        this.ticketSoldDate = ticketSoldDate;
        this.eventId = eventId;
    }

    public Ticket() {}

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getTicketSoldDate() {
        return ticketSoldDate;
    }

    public void setTicketSoldDate(Timestamp ticketSoldDate) {
        this.ticketSoldDate = ticketSoldDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", ticketSoldDate=" + ticketSoldDate +
                ", eventId=" + eventId +
                '}';
    }
}
