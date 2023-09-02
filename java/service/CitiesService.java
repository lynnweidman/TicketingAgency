package service;

import model.City;
import utils.GenericDAO;

import java.util.List;

public class CitiesService implements ServiceInterface<City> , GenericDAO<City> {

    private final GenericDAO<City> citiesDAO;

    public CitiesService(GenericDAO<City> citiesDAO) {
        this.citiesDAO = citiesDAO;
    }


    @Override
    public City findById(int id) {
        return citiesDAO.findById(id);
    }

    @Override
    public List<City> findAll() {
        return citiesDAO.findAll();
    }

    @Override
    public void save(City entity) {
        citiesDAO.save(entity);

    }

    @Override
    public void update(City entity) {
        citiesDAO.update(entity);

    }

    @Override
    public void delete(int id) {
        citiesDAO.delete(id);

    }
}
