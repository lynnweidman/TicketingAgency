package utils;

import exception.RunSQLException;
import model.Offers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionPool;


public class OffersDAO extends AbstractDAO<Offers> {
    private static final String SELECT_BY_ID = "SELECT * FROM offers WHERE offer_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM offers ";
    private static final String INSERT = "INSERT INTO offers (offer_id, event_id, venue_id) VALUES (?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE offers SET event_id = ?, SET venue_id  WHERE offer_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM offers WHERE offer_id = ?";

    private ConnectionPool connectionPool;

    public OffersDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Offers findById(int id) {
        Offers offers = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                offers = getOffersFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding offers by id ", e);
        }
        return offers;
    }

    @Override
    public List<Offers> findAll() {
        List<Offers> allOffers = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allOffers.add(getOffersFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all offers ", e);

        }
        System.out.println(allOffers);
        return allOffers;
    }

    @Override
    public void save(Offers offers) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, offers.getOfferId());
            statement.setInt(2, offers.getEventId());
            statement.setInt(2, offers.getVenueId());

            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting offers ", e);
        }
    }

    @Override
    public void update(Offers offers) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setInt(1, offers.getEventId());
            statement.setInt(2, offers.getVenueId());
            statement.setInt(3, offers.getOfferId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating offers ", e);

        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting offers ", e);

        }
    }

    private Offers getOffersFromResultSet(ResultSet resultSet) throws SQLException {
        Offers offer = new Offers();

        offer.setOfferId(resultSet.getInt("offer_id"));
        offer.setEventId(resultSet.getInt("event_id"));
        offer.setVenueId((resultSet.getInt("venue_id")));
        return offer;
    }

    public static void main(String[] args) throws SQLException {

    }
}
