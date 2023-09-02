package model;


public class Venue {
    private int venueId;
    private String venueName;
    private String venueAddress;
    private int venueMaxCapacity;

    public Venue(int venueId, String venueName, String venueAddress, int venueMaxCapacity) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venueMaxCapacity = venueMaxCapacity;
    }

    public Venue() {
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) { this.venueAddress = venueAddress; }


    public int getVenueMaxCapacity() {
        return venueMaxCapacity;
    }

    public void setVenueMaxCapacity(int venueMaxCapacity) {
        this.venueMaxCapacity = venueMaxCapacity;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", venueName='" + venueName + '\'' +
                ", venueAddress='" + venueAddress + '\'' +
                ", venueMaxCapacity=" + venueMaxCapacity +
                '}';
    }
}
