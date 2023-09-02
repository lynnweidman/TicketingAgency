package utils;

import model.City;
import java.util.List;

public interface CityInterface<C> {
    public List<City> getAllCities();
    public City getCity(int cityId);
    public void updateCity(City cities);
    public void deleteCity(int cityId);
}
