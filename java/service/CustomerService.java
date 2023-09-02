package service;

import model.Customer;
import utils.GenericDAO;
import java.util.List;

public class CustomerService implements ServiceInterface<Customer>, GenericDAO<Customer> {

    private final GenericDAO<Customer> customerDAO;

    public CustomerService(GenericDAO<Customer> customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public void save(Customer entity) {
        customerDAO.save(entity);

    }

    @Override
    public void update(Customer entity) {
        customerDAO.update(entity);

    }

    @Override
    public void delete(int id) {
        customerDAO.delete(id);

    }
}