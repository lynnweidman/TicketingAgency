package utils;

import exception.RunSQLException;
import model.Event;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbc.ConnectionPool;
import org.apache.ibatis.io.Resources;


public class EventDAO extends AbstractDAO<Event>{
    private static final String SELECT_BY_ID = "SELECT * FROM events WHERE event_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM events";
    private static final String INSERT = "INSERT INTO events (event_id, event_name, event_date, even_type_id, venue_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE events SET event_name = ?, event_date = ?, event_type_id= ?, venue_id WHERE event_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM events WHERE event_id = ?";

    private ConnectionPool connectionPool;

    public EventDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Event findById(int id) {
        Event event = null ;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                event = getEventFromResultSet(resultSet);
            }
        } catch (SQLException e) {
           throw new RunSQLException("Error while finding event by id",  e);
        }

        return event;
    }

    @Override
    public List<Event> findAll() {
        List<Event> allEvents = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
             ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
                 Event event = new Event();
                 allEvents.add(getEventFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding allEvents ",  e);
        }
        return allEvents;
    }

    @Override
    public void save(Event event) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, event.getEventId());
            statement.setString(2, event.getEventName());
            statement.setTimestamp(3, Timestamp.valueOf(event.getEventDate()));
            statement.setInt(4, event.getEventTypeId());
            statement.setInt(5, event.getVenueId());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting event ",  e);
        }
    }

    @Override
    public void update(Event events) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, events.getEventName());
            statement.setString(2, events.getEventDate().toString());
            statement.setInt(3, events.getEventTypeId());
            statement.setInt(4, events.getVenueId());
            statement.setInt(5, events.getEventId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating event ",  e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Event getEventFromResultSet(ResultSet resultSet) throws SQLException {
        Event event = new Event();

        event.setEventId(resultSet.getInt("event_id"));
        event.setEventName(resultSet.getString("event_name"));
        event.setEventDate(resultSet.getTimestamp("event_date").toLocalDateTime());
        event.setEventTypeId(resultSet.getInt("event_type_id"));
        event.setVenueId((resultSet.getInt("venue_id")));
        return event;
    }

    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = Resources.getResourceAsStream("JDBCconnection.properties")) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool dbConnection = new ConnectionPool(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("password"), 1);


        EventDAO eventDAO = new EventDAO(dbConnection);
        //System.out.println(eventDAO.findAll());
      // System.out.println(eventDAO.findById(7));

        //Inserting new event
        //Event event = new Event(21, "New Event", Timestamp.valueOf("2023-07-01 00:00:00").toLocalDateTime(), 1, 1);
        //System.out.println(eventDAO.findAll());

    }
}
