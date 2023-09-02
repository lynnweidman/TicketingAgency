package utils;

import exception.RunSQLException;
import jdbc.ConnectionPool;
import model.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO extends AbstractDAO<Seat> {
    private static final String SELECT_BY_ID = "SELECT * FROM seats WHERE seat_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM seats ";
    private static final String INSERT = "INSERT INTO seats (seat_id, seat_number, venue_id) VALUES (?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE seats SET seat_number = ?, venue_id = ?, WHERE seat_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM seats WHERE seat_id = ?";

    private jdbc.ConnectionPool connectionPool;

    public SeatDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public Seat findById(int id) {
        Seat seats = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                seats = getSeatFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding seat by id ", e);
        }

        return seats;
    }

    @Override
    public List<Seat> findAll() {
        List<Seat> allSeats = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allSeats.add(getSeatFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all seats ", e);
        }
        System.out.println(allSeats);
        return allSeats;
    }

    @Override
    public void save(Seat seats) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, seats.getSeat_id());
            statement.setInt(2, seats.getSeat_number());
            statement.setInt(3, seats.getVenue_id());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while insterting seat ", e);
        }

    }

    @Override
    public void update(Seat seats) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setInt(1, seats.getSeat_number());
            statement.setInt(2, seats.getVenue_id());
            statement.setInt(3, seats.getSeat_id());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating seat ", e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting seat ", e);
        }
    }

    private Seat getSeatFromResultSet(ResultSet resultSet) throws SQLException {
        Seat seats = new Seat();

        seats.setSeat_id(resultSet.getInt("seat_id"));
        seats.setSeat_number(resultSet.getInt("seat_number"));
        seats.setVenue_id(resultSet.getInt("venue_id"));

        return seats;
    }

    public static void main(String[] args) throws SQLException {

    }
}
