package utils;

import exception.RunSQLException;
import jdbc.ConnectionPool;
import model.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO extends AbstractDAO<State> {
    private static final String SELECT_BY_ID = "SELECT * FROM states WHERE state_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM states ";
    private static final String INSERT = "INSERT INTO offers (state_id, state_name) VALUES (?,?)";
    private static final String UPDATE_BY_ID = "UPDATE states SET state_id = ?, SET state_name WHERE state_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM states WHERE state_id = ?";

    private jdbc.ConnectionPool connectionPool;

    public StateDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public State findById(int id) {
        State states = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                states = getStatesFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding state by id ", e);
        }
        return states;
    }

    @Override
    public List<State> findAll() {
        List<State> allStates = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                State state = new State();
                allStates.add(getStatesFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all states ", e);

        }
        System.out.println(allStates);
        return allStates;
    }

    @Override
    public void save(State states) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, states.getStateId());
            statement.setInt(2, states.getStateName());


            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting state ", e);

        }
    }

    @Override
    public void update(State states) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setInt(1, states.getStateId());
            statement.setInt(2, states.getStateName());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating state", e);

        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting state", e);

        }

    }

    private State getStatesFromResultSet(ResultSet resultSet) throws SQLException {
        State states = new State();

        states.setStateId(resultSet.getInt("state_id"));
        states.setStateName(resultSet.getInt("state_name"));

        return states;
    }

    public static void main(String[] args) throws SQLException {

    }
}
