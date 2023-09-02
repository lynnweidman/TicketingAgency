package service;

import model.Seat;
import utils.GenericDAO;

import java.util.List;

public class SeatsService implements ServiceInterface<Seat>, GenericDAO<Seat> {
    private final GenericDAO<Seat> seatsDAO;

    public SeatsService(GenericDAO<Seat> seatsDAO) {
        this.seatsDAO = seatsDAO;
    }


    @Override
    public Seat findById(int id) {
        return seatsDAO.findById(id);
    }

    @Override
    public List<Seat> findAll() {
        return seatsDAO.findAll();
    }

    @Override
    public void save(Seat seat) {
        seatsDAO.save(seat);

    }

    @Override
    public void update(Seat seat) {
        seatsDAO.update(seat);

    }

    @Override
    public void delete(int id) {
        seatsDAO.delete(id);

    }
}
