package utils;

import model.Venue;
import java.util.List;

public interface VenueInterface {
    public List<Venue> getAllVenues();
    public Venue getVenue(int venueId);
    public void updateVenue(Venue venue);
    public void deleteVenue(int venueId);
}
