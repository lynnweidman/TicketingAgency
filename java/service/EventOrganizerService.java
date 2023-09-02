package service;

import model.Customer;
import utils.GenericDAO;

import java.util.List;

public class EventOrganizerService implements ServiceInterface<Customer>, GenericDAO<Customer> {


    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer entity) {

    }

    @Override
    public void update(Customer entity) {

    }

    @Override
    public void delete(int id) {

    }
}
