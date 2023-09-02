package utils;

import model.EventType;
import java.util.List;

public interface EventTypesInterface {
    public List<EventType> getAllEventTypes();
    public EventType getEventTypes(int eventTypeId);
    public void updateEventType(EventType eventType);
    public void deleteEventType(int eventTypeId);
}
