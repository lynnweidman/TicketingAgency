package service;

import model.Customer;
import model.Performer;
import utils.GenericDAO;

import java.util.List;

public class PerformerService implements ServiceInterface<Performer>, GenericDAO<Performer> {

    private final GenericDAO<Performer> performerDAO;

    public PerformerService(GenericDAO<Performer> performerDAO) {
        this.performerDAO = performerDAO;
    }


    @Override
    public Performer findById(int id) {
        return performerDAO.findById(id);
    }

    @Override
    public List<Performer> findAll() {
        return performerDAO.findAll();
    }

    @Override
    public void save(Performer entity) {
        performerDAO.save(entity);
    }

    @Override
    public void update(Performer entity) {
        performerDAO.update(entity);
    }

    @Override
    public void delete(int id) {
        performerDAO.delete(id);

    }
}
