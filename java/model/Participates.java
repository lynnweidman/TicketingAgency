package model;

public class Participates {
    int participatesId;
    int eventId;
    int performerId;

    public Participates(int participatesId, int evnetId, int performerId) {
        this.participatesId = participatesId;
        this.eventId = evnetId;
        this.performerId = performerId;
    }

   public Participates() {

    }

    public int getParticipatesId() {
        return participatesId;
    }

    public void setParticipatesId(int participatesId) {
        this.participatesId = participatesId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getPerformerId() {
        return performerId;
    }

    public void setPerformerId(int performerId) {
        this.performerId = performerId;
    }

    @Override
    public String toString() {
        return "Participates{" +
                "participatesId=" + participatesId +
                ", evnetId=" + eventId +
                ", performerId=" + performerId +
                '}';
    }
}
