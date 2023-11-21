package com.teenkung.devlottery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLManager {

    private final ConfigLoader config;
    private Connection connection;

    public SQLManager(ConfigLoader config) {
        this.config = config;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" +
                            config.getString("Mysql.Host")+":" +
                            config.getString("Mysql.Port")+"/" +
                            config.getString("Mysql.Database")+"?useSSL=false&autoReconnect=true",
                    config.getString("Mysql.Username"),
                    config.getString("Mysql.Password")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    private boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
