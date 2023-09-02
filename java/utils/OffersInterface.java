package utils;

import model.Offers;
import java.util.List;

public interface OffersInterface {
    public List<Offers> getAllOffers();
    public Offers getOfferId(int offerId);
    public void updateOffers(Offers offer);
    public void deleteOffers(int offerId);
}
