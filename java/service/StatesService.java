package service;

import model.State;
import utils.GenericDAO;

import java.util.List;

public class StatesService implements ServiceInterface<State>, GenericDAO<State> {

    private final GenericDAO<State> statesDAO;

    public StatesService(GenericDAO<State> statesDAO) {
        this.statesDAO = statesDAO;
    }



    @Override
    public State findById(int id) {
        return statesDAO.findById(id);
    }

    @Override
    public List<State> findAll() {
        return statesDAO.findAll();
    }

    @Override
    public void save(State state) {
        statesDAO.save(state);

    }

    @Override
    public void update(State state) {
        statesDAO.update(state);

    }

    @Override
    public void delete(int id) {
        statesDAO.delete(id);

    }
}
