package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // method to create a new database connection
    public static  Connection getConnection() throws SQLException {
        String dbUrl  = "jdbc:mysql://localhost:3306/facebook?serverTimezone=UTC";
        String dbUsername ="root";
        String dbPassword = "Mas10ter^^^&@$$%%%%";
        // returns the newly created database connection
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}
