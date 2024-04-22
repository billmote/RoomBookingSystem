package com.booker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URI;
import java.net.URISyntaxException;

public class ConnectionPool {

    private ConnectionPool(){
    }

    private Connection connection = getConnection();

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }

    static Connection getConnection() {
        //    private static final String username = "postgres";
        //    private static final String password = "admin";
        //    private static final String dbUrl = "jdbc:postgresql://localhost:5433/postgres";

        Connection connection = null;
        
        try {
            URI dbUri = new URI(System.getenv("DATABASE_URL"));    
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            // no-op
        }
        return connection;
    }
}
