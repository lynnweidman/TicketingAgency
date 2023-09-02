package model;

public class EventOrganizer {
    private int eventOrganizerId;
    private String eventOrganizerName;
    private String eventOrganizerPhone;
    private String eventOrganizerEmail;
    private int eventId;

    public EventOrganizer(int eventOrganizerId, String eventOrganizerName, String eventOrganizerPhone, String eventOrganizerEmail, int eventId) {
        this.eventOrganizerId = eventOrganizerId;
        this.eventOrganizerName = eventOrganizerName;
        this.eventOrganizerPhone = eventOrganizerPhone;
        this.eventOrganizerEmail = eventOrganizerEmail;
        this.eventId = eventId;
    }

    public EventOrganizer() {}

    public int getEventOrganizerId() {
        return eventOrganizerId;
    }

    public void setEventOrganizerId(int eventOrganizerId) {
        this.eventOrganizerId = eventOrganizerId;
    }

    public String getEventOrganizerName() {
        return eventOrganizerName;
    }

    public void setEventOrganizerName(String eventOrganizerName) {
        this.eventOrganizerName = eventOrganizerName;
    }

    public String getEventOrganizerPhone() {
        return eventOrganizerPhone;
    }

    public void setEventOrganizerPhone(String eventOrganizerPhone) {
        this.eventOrganizerPhone = eventOrganizerPhone;
    }

    public String getEventOrganizerEmail() {
        return eventOrganizerEmail;
    }

    public void setEventOrganizerEmail(String eventOrganizerEmail) {
        this.eventOrganizerEmail = eventOrganizerEmail;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "EventOrganizers{" +
                "eventOrganizerId=" + eventOrganizerId +
                ", eventOrganizerName='" + eventOrganizerName + '\'' +
                ", eventOrganizerPhone='" + eventOrganizerPhone + '\'' +
                ", eventOrganizerEmail='" + eventOrganizerEmail + '\'' +
                ", eventId=" + eventId +
                '}';
    }
}
