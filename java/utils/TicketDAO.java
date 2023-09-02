package utils;

import exception.RunSQLException;
import model.Event;
import model.Ticket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbc.ConnectionPool;
import org.apache.ibatis.io.Resources;


public class TicketDAO extends AbstractDAO<Ticket> {
    private static final String SELECT_BY_ID = "SELECT * FROM tickets WHERE ticket_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM tickets ";
    private static final String INSERT = "INSERT INTO tickets (ticket_id, ticket_Sold_Date, event_Id) VALUES (?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE tickets SET ticket_sold_date = ?, event_id = ?, WHERE ticket_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM tickets WHERE ticket_id = ?";

    private ConnectionPool connectionPool;

    public TicketDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public Ticket findById(int id) {
        Ticket tickets = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tickets = getTicketFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding ticket by id ", e);
        }

        return tickets;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> allTickets = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allTickets.add(getTicketFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all tickets", e);
        }
        System.out.println(allTickets);
        return allTickets;
    }

    @Override
    public void save(Ticket tickets) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, tickets.getTicketId());
            statement.setTimestamp(2, tickets.getTicketSoldDate());
            statement.setInt(3, tickets.getEventId());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting ticket ", e);
        }

    }

    @Override
    public void update(Ticket tickets) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setTimestamp(1, tickets.getTicketSoldDate());
            statement.setInt(2, tickets.getEventId());
            statement.setInt(3, tickets.getTicketId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating ticket ", e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting ticket ", e);
        }
    }

    private Ticket getTicketFromResultSet(ResultSet resultSet) throws SQLException {
        Ticket tickets = new Ticket();

        tickets.setTicketId(resultSet.getInt("ticket_id"));
        tickets.setTicketSoldDate(resultSet.getTimestamp("ticket_sold_date"));
        tickets.setEventId(resultSet.getInt("event_id"));

        return tickets;
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


        Ticket ticket = new Ticket(22, Timestamp.valueOf("2023-07-01"), 1);
    }
}
