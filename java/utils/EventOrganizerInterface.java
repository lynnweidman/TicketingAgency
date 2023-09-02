package utils;

import model.EventOrganizer;
import java.util.List;

public interface EventOrganizerInterface {
    public List<EventOrganizer> getAllEventOrganizers();
    public EventOrganizer getVenue(int eventOrganizerId);
    public void updateEventOrganizer(EventOrganizer eventOrganizer);
    public void deleteEventOrganizer(int eventOrganizerId);
}
