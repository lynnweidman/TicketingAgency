package service;

import model.EventType;
import utils.GenericDAO;

import java.sql.SQLException;
import java.util.List;

public class EventTypeService implements ServiceInterface<EventType>, GenericDAO<EventType> {

    private final GenericDAO<EventType> eventTypeDAO;

    public EventTypeService(GenericDAO<EventType> eventTypeDao) {
        this.eventTypeDAO = eventTypeDao;
    }

    @Override
    public EventType findById(int id) {
        return eventTypeDAO.findById(id);
    }

    @Override
    public List<EventType> findAll() {
        return eventTypeDAO.findAll();
    }

    @Override
    public void save(EventType entity) {
        eventTypeDAO.save(entity);

    }

    @Override
    public void update(EventType entity) {
        eventTypeDAO.update(entity);

    }

    @Override
    public void delete(int id) {
        eventTypeDAO.delete(id);

    }

    public static void main(String[] args) throws SQLException {

    }
}
