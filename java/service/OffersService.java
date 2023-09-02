package service;

import model.Offers;
import utils.GenericDAO;

import java.util.List;




public class OffersService implements ServiceInterface<Offers>, GenericDAO<Offers> {
    private final GenericDAO<Offers> offersDAO;

    public OffersService(GenericDAO<Offers> offersDAO) {
        this.offersDAO = offersDAO;
    }


    @Override
    public Offers findById(int id) {
        return offersDAO.findById(id);
    }

    @Override
    public List<Offers> findAll() {
        return offersDAO.findAll();
    }

    @Override
    public void save(Offers entity) {
        offersDAO.save(entity);

    }

    @Override
    public void update(Offers entity) {
        offersDAO.update(entity);

    }

    @Override
    public void delete(int id) {
        offersDAO.delete(id);

    }

}
