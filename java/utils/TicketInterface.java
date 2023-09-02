package utils;

import model.Ticket;
import java.util.List;

public interface TicketInterface {
    public List<Ticket> getAllTickets();
    public Ticket getTicket(int ticketId);
    public void updateTickets(Ticket tickets);
    public void deleteTickets(int ticketId);
}
