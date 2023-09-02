package mapper;

import model.Event;

public interface EventsMapper {
    Event selectEventById(int eventId);

    void addEvent(Event events);
}
