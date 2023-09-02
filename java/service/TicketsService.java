package service;

import model.Ticket;
import utils.GenericDAO;

import java.util.List;

public class TicketsService implements ServiceInterface<Ticket>, GenericDAO<Ticket> {


    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void save(Ticket entity) {

    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public void delete(int id) {

    }
}
