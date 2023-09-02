package utils;

import exception.RunSQLException;
import model.EventType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionPool;


public class EventTypeDAO extends AbstractDAO<EventType> {
    private static final String SELECT_BY_ID = "SELECT * FROM event_types WHERE event_type_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM event_types ";
    private static final String INSERT = "INSERT INTO event_types (event_type_id, event_type) VALUES (?,?)";
    private static final String UPDATE_BY_ID = "UPDATE events_types SET event_type = ?  WHERE event_type_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM event_types WHERE event_type_id = ?";

    private ConnectionPool connectionPool;

    public EventTypeDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public EventType findById(int id) {
        EventType eventType = null ;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
                eventType = getEventTypeFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding event type by id ", e);

        }

        return eventType;
    }

    @Override
    public List<EventType> findAll() {
        List<EventType> allEventTypes = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allEventTypes.add(getEventTypeFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all event types", e);
        }
        System.out.println(allEventTypes);
        return allEventTypes;
    }

    @Override
    public void save(EventType eventType) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventType.getEventTypeId());
            statement.setString(2, eventType.getEventType());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting event type", e);
        }
    }

    @Override
    public void update(EventType eventType) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, eventType.getEventType());
            statement.setInt(2, eventType.getEventTypeId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating event type", e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting event type ", e);
        }
    }

    private EventType getEventTypeFromResultSet(ResultSet resultSet) throws SQLException {
        EventType eventType = new EventType();

        eventType.setEventTypeId(resultSet.getInt("event_type_id"));
        eventType.setEventType(resultSet.getString("event_type"));
        return eventType;
    }

    public static void main(String[] args) throws SQLException {

    }
}
