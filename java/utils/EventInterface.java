package utils;

import model.Event;
import java.util.List;

public interface EventInterface  {
    public List<Event> getAllEvents();
    public Event getEvent(int eventId);
    public void updateEvent(Event event);
    public void deleteEvent(int eventId);

}

