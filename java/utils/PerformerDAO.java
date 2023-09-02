package utils;

import exception.RunSQLException;
import jdbc.ConnectionPool;
import model.Customer;
import model.Performer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerformerDAO extends AbstractDAO<Performer> {
    private static final String SELECT_BY_ID = "SELECT * FROM customers WHERE performer_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM performers ";
    private static final String INSERT = "INSERT INTO performers (performer_id, performer_name, performer_phone, performer_email) VALUES (?,?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE performers SET performer_name = ?, performer_phone, performer_email = ? WHERE performer_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM performers WHERE performer_id = ?";

    private jdbc.ConnectionPool connectionPool;

    public PerformerDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Performer findById(int id) {
        Performer performer = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                performer = getPerformerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding performer by id ", e);
        }

        return performer;
    }

    @Override
    public List<Performer> findAll() {
        List<model.Performer> allPerformers = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allPerformers.add(getPerformerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all performers  ", e);

        }
        return allPerformers;
    }

    @Override
    public void save(Performer performer) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, performer.getPerformerId());
            statement.setString(2, performer.getPerformerName());
            statement.setString(3, performer.getPerformerPhone());
            statement.setString(4, performer.getPerformerEmail());

            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting performer", e);

        }

    }

    @Override
    public void update(Performer performer) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, performer.getPerformerName());
            statement.setString(2, performer.getPerformerPhone());
            statement.setString(3, performer.getPerformerEmail());
            statement.setInt(4, performer.getPerformerId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating performer ", e);

        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting performer", e);

        }
    }

    private Performer getPerformerFromResultSet(ResultSet resultSet) throws SQLException {
        Performer performer = new Performer();

        performer.setPerformerId(resultSet.getInt("performer_id"));
        performer.setPerformerName(resultSet.getString("performer_name"));
        performer.setPerformerPhone(resultSet.getString("performer_phone"));
        performer.setPerformerEmail(resultSet.getString("performer_email"));
        return performer;
    }

    public static void main(String[] args) throws SQLException {

    }
}
