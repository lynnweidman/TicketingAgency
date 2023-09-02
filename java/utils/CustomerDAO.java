package utils;

import exception.RunSQLException;
import jdbc.ConnectionPool;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer> {
    private static final String SELECT_BY_ID = "SELECT * FROM customers WHERE customer_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM customers ";
    private static final String INSERT = "INSERT INTO customers (customer_id, customer_name, customer_phone, customer_street_address, city_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE customers SET customer_name = ?, customer_phone, customer_street_address = ?, city_id= ? WHERE customer_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM customers WHERE customer_id = ?";

    private ConnectionPool connectionPool;

    public CustomerDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = getEventFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding customer by id ", e);
        }

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allCustomers = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allCustomers.add(getEventFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all customers", e);
        }
        return allCustomers;
    }

    @Override
    public void save(Customer customer) {

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerPhone());
            statement.setString(4, customer.getCustomerStreetAddress());
            statement.setInt(5, customer.getCityId());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting customer ", e);
        }

    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerPhone());
            statement.setString(3, customer.getCustomerStreetAddress());
            statement.setInt(4, customer.getCityId());
            statement.setInt(5, customer.getCustomerId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating customer ", e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting customer ", e);
        }
    }

    private Customer getEventFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();

        customer.setCustomerId(resultSet.getInt("customer_id"));
        customer.setCustomerName(resultSet.getString("customer_name"));
        customer.setCustomerPhone(resultSet.getString("customer_phone"));
        customer.setCustomerStreetAddress(resultSet.getString("customer_street_address"));
        customer.setCityId((resultSet.getInt("city_id")));
        return customer;
    }

    public static void main(String[] args) throws SQLException {

    }
}
