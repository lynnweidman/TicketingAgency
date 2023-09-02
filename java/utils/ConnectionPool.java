package utils;

import model.Venue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
/*

    private String url;
    private String dbUserName;
    private String dbPassword;
    private int maxConnections;

    private List<Connection> connections;

    public ConnectionPool(String url, String dbUserName, String dbPassword, int maxConnections) {
        this.url = url;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
        this.maxConnections = maxConnections;

        connections = new ArrayList<>();
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxConnections; i++) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
                connections.add(connection);

                if (connection != null) {
                    System.out.println("Successfully connected.");
                } else {
                    System.out.println("Failed to connect.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized Connection getConnection() {
        while (connections.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return connections.remove(connections.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
        notify();
    }

    public static void main(String args[]) {

        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\src\\main\\resources\\JDBCconnection.properties")) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool dbConnection = new ConnectionPool(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("password"), 1);

        VenueDAO venue = new VenueDAO(dbConnection);

    }
*/

}









