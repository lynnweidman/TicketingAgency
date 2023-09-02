package mapper;

import model.Customer;
import model.Event;
import model.Venue;

import java.util.List;


public interface VenueMapper {
    Venue selectVenueById(int venueId);

    Venue selectNameById(int venueId);

    void addVenue(Venue venue);

}
