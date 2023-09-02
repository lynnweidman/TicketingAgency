package model;

import java.util.List;

public class Offers {
    int offerId;
    int eventId;
    int venueId;

    public Offers(int offerId, int eventId, int venueId) {
        this.offerId = offerId;
        this.eventId = eventId;
        this.venueId = venueId;
    }

    public Offers() {

    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "offerId=" + offerId +
                ", eventId=" + eventId +
                ", venueId=" + venueId +
                '}';
    }
}
