package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// for future implementation
public class CreateTablesDao {


    //  methods to create database tables if it does not exist
    public void createUserTable(){
        // sql statement to automatically create table if it does not exist
        String sql  = "CREATE TABLE IF NOT EXISTS users (" +
                "userID INTEGER PRIMARY KEY  AUTO_INCREMENT,"+
                        "firstName Varchar(100) NOT NULL," +
                        "lastName Varchar(100) NOT NULL,"+
                        "email VARCHAR(100) NOT NULL," +
                        "password VARCHAR(200) NOT NULL," +
                        "address VARCHAR(100) NOT NULL," +
                        "gender VARCHAR(10) NOT NULL," +
                        "lastLoginDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                        "dateCreated DATETIME DEFAULT CURRENT_TIMESTAMP);";

        try(Connection connection  = DBConnection.getConnection()) {
            // create a prepared statement
            PreparedStatement preparedStatement =  connection.prepareStatement(sql);
            // execute the prepared statement
            preparedStatement.executeQuery();
            System.out.println("users Table Created");
        } catch (SQLException throwables) {
            System.out.println("Unable to create user table");
            throwables.printStackTrace();
        }

    }


}
