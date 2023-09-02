package service;

import model.Venue;
import utils.GenericDAO;
import utils.VenueDAO;

import java.util.List;

public class VenueService implements ServiceInterface<Venue>, GenericDAO<Venue> {

    private final GenericDAO<Venue> venueDao;

    public VenueService(GenericDAO<Venue> venueDao) {
        this.venueDao = venueDao;
    }

    @Override
    public Venue findById(int id) {
        return venueDao.findById(id);
    }

    @Override
    public List<Venue> findAll() {
        return venueDao.findAll();
    }

    @Override
    public void save(Venue entity) {
        venueDao.save(entity);
    }


    @Override
    public void update(Venue entity) {
        venueDao.update(entity);
    }


    @Override
    public void delete(int id) {
        venueDao.delete(id);
    }

    public static void main(String[] args) {

    }
}






