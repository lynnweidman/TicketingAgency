package utils;

import exception.RunSQLException;
import model.Participates;
import model.Venue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionPool;


public class ParticipatesDAO extends AbstractDAO<Participates>{
    private static final String SELECT_BY_ID = "SELECT * FROM participates WHERE participates_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM venues ";
    private static final String INSERT = "INSERT INTO participates (participates_id, event_id, performer_id) VALUES (?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE participates SET event_id = ?, SET performer_id  WHERE participates_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM participates WHERE participates_id = ?";

    private ConnectionPool connectionPool;

    public ParticipatesDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public Participates findById(int id) {
        Participates participates = null ;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                participates = getParticipatesFromResultSet(resultSet);
                System.out.println(participates);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding participates by id ", e);

        }

        return participates;
    }

    @Override
    public List<Participates> findAll() {
        List<Participates> allParticipates = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allParticipates.add(getParticipatesFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all participates  ", e);
        }
        System.out.println(allParticipates);
        return allParticipates;
    }

    @Override
    public void save(Participates participates) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, participates.getParticipatesId());
            statement.setInt(2, participates.getEventId());
            statement.setInt(2, participates.getParticipatesId());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting participates ", e);
        }

    }

    @Override
    public void update(Participates participates) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setInt(1, participates.getEventId());
            statement.setInt(2, participates.getPerformerId());
            statement.setInt(3, participates.getParticipatesId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating participates", e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting participates ", e);
        }
    }
    private Participates getParticipatesFromResultSet(ResultSet resultSet) throws SQLException {
        Participates participates = new Participates();

        participates.setParticipatesId(resultSet.getInt("participates_id"));
        participates.setEventId(resultSet.getInt("event_id"));
        participates.setPerformerId(resultSet.getInt("performer_id"));
        return participates;
    }

    public static void main(String[] args) throws SQLException {

    }
}
