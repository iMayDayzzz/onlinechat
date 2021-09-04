package com.trackensure.onlinechat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnect {

    private Properties properties;
    private Connection connection;

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(
                        (getClass().getResourceAsStream("/db/postgres.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public Connection getConnect() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        getProperties().getProperty("database.url"),
                        getProperties().getProperty("database.username"),
                        getProperties().getProperty("database.password"));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
