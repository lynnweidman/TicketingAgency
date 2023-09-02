package json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketsJson {
    @JsonProperty("ticketId")
    private int ticketId;

    @JsonProperty("ticketSoldDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date ticketSoldDate;

    @JsonProperty("eventId")
    private int eventId;

    public TicketsJson(int ticketId, Date ticketSoldDate, int eventId) {
        this.ticketId = ticketId;
        this.ticketSoldDate = ticketSoldDate;
        this.eventId = eventId;
    }

    public TicketsJson() {}

    @JsonProperty("listTickets")
    public List<TicketsJson> listTickets = new ArrayList<>();

/*
    @JsonProperty("getListTickets")
    public List<TicketsJSON> getListTickets() {
        return listTickets;
    }

    @JsonProperty("setListTickets")
    public void setListTickets(List<TicketsJSON> listTickets) {
        this.listTickets = listTickets;
    }*/

   /* return getListTickets(new TypeReference<List<TicketsJSON>>() {

        });
    }*/


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Date getTicketSoldDate() {
        return ticketSoldDate;
    }

    public void setTicketSoldDate(Date ticketSoldDate) {
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
        return "TicketsJSON{" +
                "ticketId=" + ticketId +
                ", ticketSoldDate=" + ticketSoldDate +
                ", eventId=" + eventId +
                '}';
    }
}



