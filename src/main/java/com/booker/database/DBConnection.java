package com.booker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private static final String driver = "org.postgresql.Driver";
//    private static final String username = "ywvhywkzeausaz";
//    private static final String password = "12976fe4015a30b27a136dd1efb9c0b0fba90f84cfd1f3cf0d490590d7c7d498";
//    private static final String dbUrl = "jdbc:postgres://ywvhywkzeausaz:12976fe4015a30b27a136dd1efb9c0b0fba90f84cfd1f3cf0d490590d7c7d498@ec2-184-73-232-93.compute-1.amazonaws.com:5432/d18gkho6mnfpet";

    private static final String username = "postgres";
    private static final String password = "admin";
    private static final String dbUrl = "jdbc:postgres://localhost:5433/postgres";

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            connection.setAutoCommit(true);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
