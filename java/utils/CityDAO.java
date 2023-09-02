package utils;

import exception.RunSQLException;
import jdbc.ConnectionPool;
import model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends AbstractDAO<City> {
    private static final String SELECT_BY_ID = "SELECT * FROM Cities WHERE city_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM cities ";
    private static final String INSERT = "INSERT INTO cities (city_id, city_name, state_id) VALUES (?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE cities SET city_name, SET state_id WHERE city_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM cities WHERE city_id = ?";

    private ConnectionPool connectionPool;

    public CityDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public City findById(int id) {
        City cities = null;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cities = getCityFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding city by id ", e);
        }
        return cities;
    }

    @Override
    public List<City> findAll() {
        List<City> allCities = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allCities.add(getCityFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all cities ", e);
        }
        System.out.println(allCities);
        return allCities;
    }

    @Override
    public void save(City cities) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cities.getCityId());
            statement.setString(2, cities.getCityName());
            statement.setInt(3, cities.getStateId());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting city ", e);
        }

    }

    @Override
    public void update(City cities) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, cities.getCityName());
            statement.setInt(2, cities.getStateId());
            statement.setInt(3, cities.getCityId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating city ", e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting city ", e);
        }

    }

    private City getCityFromResultSet(ResultSet resultSet) throws SQLException {
        City cities = new City();

        cities.setCityId(resultSet.getInt("city_id"));
        cities.setCityName(resultSet.getString("city_name"));
        cities.setStateId(resultSet.getInt("state_id"));

        return cities;
    }

    public static void main(String[] args) throws SQLException {

    }
}
