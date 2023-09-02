package utils;


import exception.RunSQLException;
import model.Venue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import jdbc.ConnectionPool;
import org.apache.ibatis.io.Resources;

public class VenueDAO extends AbstractDAO<Venue> {
    private static final String SELECT_BY_ID = "SELECT * FROM venues WHERE venue_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM venues";
    private static final String INSERT = "INSERT INTO venues (venue_id, venue_name, venue_address, venue_max_capacity) VALUES (?,?,?,?)";
    private static final String UPDATE_BY_ID = "UPDATE venues SET venue_name = ?, venue_address = ?, venue_max_capacity = ? WHERE venue_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM venues WHERE venue_id = ?";


    private ConnectionPool connectionPool;

    public VenueDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Venue findById(int id) {
        Venue venue = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                venue = getVenueFromResultSet(resultSet);
                System.out.println(venue);

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding venue by id ",  e);
        }

        return venue;
    }

    @Override
    public List<Venue> findAll() {
        List<Venue> allVenues = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allVenues.add(getVenueFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            throw new RunSQLException("Error while finding all venues ",  e);
        }
        return allVenues;

    }

    @Override
    public void save(Venue venue) {
        String sql = INSERT;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, venue.getVenueId());
            statement.setString(2, venue.getVenueName());
            statement.setString(3, venue.getVenueAddress());
            statement.setInt(4, venue.getVenueMaxCapacity());
            statement.execute();

            System.out.println("Insert successful.");
        } catch (SQLException e) {
            throw new RunSQLException("Error while inserting new venue ",  e);
        }
    }

    @Override
    public void update(Venue venue) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
            statement.setString(1, venue.getVenueName());
            statement.setString(2, venue.getVenueAddress());
            statement.setInt(3, venue.getVenueMaxCapacity());
            statement.setInt(4, venue.getVenueId());
            statement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while updating venue ",  e);
        }
    }

    @Override
    //public void delete(Venue venue) {
    public void delete(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Delete successful");
        } catch (SQLException e) {
            throw new RunSQLException("Error while deleting ",  e);
        }
    }

    private Venue getVenueFromResultSet(ResultSet resultSet) throws SQLException {
        Venue venue = new Venue();

        venue.setVenueId(resultSet.getInt("venue_id"));
        venue.setVenueName(resultSet.getString("venue_name"));
        venue.setVenueAddress(resultSet.getString("venue_address"));
        venue.setVenueMaxCapacity(resultSet.getInt("venue_max_capacity"));
        return venue;
    }

    public static void main(String[] args) throws SQLException {

       /* Properties properties = new Properties();
        try (InputStream inputStream = Resources.getResourceAsStream("JDBCconnection.properties")) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool dbConnection = new ConnectionPool(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("password"), 1);
*/

        // Prints allVenues
       // VenueDAO venue = new VenueDAO(dbConnection);
        //System.out.println(venue.findAll());


        //Update
        //venue.update(new Venue(4, "Miami Venue", "Miami, Fl", 300000));


        //Save
        /*VenueDAO venue = new VenueDAO(dbConnection);
        Venue venue1 = new Venue(22, "Atlanta Venue", "Atlanta, GA", 100000);
        venue.save(venue1);
        System.out.println("New save " + venue.findAll());*/

        //Deletes venue by locating the id.
        //VenueDAO venue = new VenueDAO(dbConnection);
        //venue.delete(15);


        //Finds venueById
        // VenueDAO venue = new VenueDAO(dbConnection);
        // venue.findById(17);

    }
}





