package service;

import model.Event;
import utils.GenericDAO;

import java.sql.SQLException;
import java.util.List;

public class EventService implements ServiceInterface<Event>, GenericDAO<Event> {

    private final GenericDAO<Event> eventDao;

    public EventService(GenericDAO<Event> eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event findById(int id) {
        return eventDao.findById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventDao.findAll();
    }

    @Override
    public void save(Event entity) {
        eventDao.save(entity);
    }


    @Override
    public void update(Event entity) {
        eventDao.update(entity);
    }

    @Override
    public void delete(int id) {
        eventDao.delete(id);
    }

    public static void main(String[] args) throws SQLException {

    }
}
