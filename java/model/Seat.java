package model;

public class Seat {
    private int seat_id;
    private int seat_number;
    private int venue_id;

    public Seat(int seat_id, int seat_number, int venue_id) {
        this.seat_id = seat_id;
        this.seat_number = seat_number;
        this.venue_id = venue_id;
    }

    public Seat() {}

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "seat_id=" + seat_id +
                ", seat_number=" + seat_number +
                ", venue_id=" + venue_id +
                '}';
    }
}
