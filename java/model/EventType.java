package model;

public class EventType {
    int eventTypeId;
    String eventType;

    public EventType(int eventTypeId, String eventType) {
        this.eventTypeId = eventTypeId;
        this.eventType = eventType;
    }

    public EventType() {

    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "EventTypes{" +
                "eventTypeId=" + eventTypeId +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
