package utils;

import exception.RunSQLException;
import jdbc.ConnectionPool;
import model.EventOrganizer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventOrganizerDAO extends AbstractDAO<EventOrganizer> {
    private static final String SELECT_BY_ID = "SELECT * FROM event_organizers WHERE event_organizer_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM event_organizers ";
    private static final String INSERT = "INSERT INTO event_organizers (event_organizer_id, event_organizer_name, event_organizer_phone, event_organizer_email, event_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE event_organizers SET event_organizer_name = ?, event_organizer_phone, event_organizer_email, event_id WHERE event_organizer_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM event_organizers WHERE event_organizer_id = ?";

    private ConnectionPool connectionPool;

    public EventOrganizerDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public EventOrganizer findById(int id) {
        EventOrganizer eventOrganizer = null ;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                eventOrganizer = getEventOrganizerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding event organizer by id ", e);
        }

        return eventOrganizer;
    }


    @Override
    public List<EventOrganizer> findAll() {
        List<EventOrganizer> allEventOrganizers = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allEventOrganizers.add(getEventOrganizerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all event organizers", e);
        }
        return allEventOrganizers;
    }

    @Override
    public void save(EventOrganizer eventOrganizer) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventOrganizer.getEventOrganizerId());
            statement.setString(2, eventOrganizer.getEventOrganizerName());
            statement.setString(3, eventOrganizer.getEventOrganizerPhone());
            statement.setString(4, eventOrganizer.getEventOrganizerEmail());
            statement.setInt(5, eventOrganizer.getEventId());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting event organizer", e);
        }


    }

    @Override
    public void update(EventOrganizer eventOrganizer) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, eventOrganizer.getEventOrganizerName());
            statement.setString(2, eventOrganizer.getEventOrganizerPhone());
            statement.setString(3, eventOrganizer.getEventOrganizerEmail());
            statement.setInt(4, eventOrganizer.getEventId());
            statement.setInt(5, eventOrganizer.getEventOrganizerId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating event organizer ", e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting event organizer", e);
        }

    }

    private EventOrganizer getEventOrganizerFromResultSet(ResultSet resultSet) throws SQLException {
        EventOrganizer eventOrganizer = new EventOrganizer();

        eventOrganizer.setEventOrganizerId(resultSet.getInt("event_organizer_id"));
        eventOrganizer.setEventOrganizerName(resultSet.getString("event_organizer_name"));
        eventOrganizer.setEventOrganizerPhone(resultSet.getString("event_organizer_phone"));
        eventOrganizer.setEventOrganizerEmail(resultSet.getString("event_organizer_email"));
        eventOrganizer.setEventId((resultSet.getInt("event_id")));
        return eventOrganizer;
    }
}
