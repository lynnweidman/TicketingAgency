package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jaxb.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.List;


@XmlRootElement(name = "events")
@XmlAccessorType(XmlAccessType.FIELD)

//Class using XML and JaxB
public class Event {
    @XmlElement
    private int eventId;

    @XmlElement
    private String eventName;


    @XmlElement(name = "eventDate", required = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime eventDate;

    @XmlElement
    private int eventTypeId;

    @XmlElement
    private int venueId;

    public Event(int eventId, String eventName, LocalDateTime eventDate, int eventTypeId, int venueId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTypeId = eventTypeId;
        this.venueId = venueId;
    }

    public Event() {
    }

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", eventTypeId=" + eventTypeId +
                ", venueId=" + venueId +
                '}';
    }
}
