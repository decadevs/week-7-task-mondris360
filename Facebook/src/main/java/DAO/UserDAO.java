package DAO;

import Model.User;

import java.sql.*;


public class UserDAO {
    String tableName = "users";


    // SQL Queries
    final String getUserByEmailSql = "SELECT * FROM users WHERE email=?;";
    final String createNewUserSql = "Insert Into users (firstName,lastName, email, password, gender, DateOfBirth) VALUE(?,?,?,?,?,?);";
    final String getAllUsersSql = "Select * from " +  tableName;
    final String updateUserByEmail =  "Update " +  tableName +
            "SET firstName =? , lastName =?"+
            "address =?, gender = ?";


    // method to get a single user from the database
    public User getUserByEmail(String emailAddress)  {
        User user = null;
        // create a database connection
        try(Connection connection =  DBConnection.getConnection()) {
            // create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(getUserByEmailSql);
            // set the values of the placeholders
            preparedStatement.setString(1, emailAddress);
            ResultSet resultSet =  preparedStatement.executeQuery();
            // return false if the user already exist
            if (resultSet.next()){
                int userID = resultSet.getInt("userID");
                String firstName =  resultSet.getString("firstName");
                String lastName =  resultSet.getString("lastName");
                String email =  resultSet.getString("email");
                String password =  resultSet.getString("password");
                String gender =  resultSet.getString("gender");
                String DateOfBirth = resultSet.getString("DateOfBirth");
                String Status =  resultSet.getString("Status");
                Timestamp lastLogin =  resultSet.getTimestamp("lastLoginDate");
                Timestamp dateCreated = resultSet.getTimestamp("dateCreated");
                // create a new user object
                user =  new User(userID,firstName,lastName,email,password,gender,DateOfBirth,
                        dateCreated, lastLogin, Status);
                System.out.println("Inside User Dao + " +  user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return user;

    }


    // method to add a new user to the database;
    public boolean createNewUser(User newUser) {
        System.out.println("user " +  newUser);
        try (Connection connection = DBConnection.getConnection()){

            // CHECK IF THE USER ALREADY EXISTS
            User userAlreadyExists =  getUserByEmail(newUser.getEmail());
            // if a user with that email address already exists
            if (userAlreadyExists != null){
                System.out.println("User Already Exist");
                return false;
            }

            // create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(createNewUserSql);
            // set  the placeholders values
            preparedStatement.setString(1,newUser.getFirstName());
            preparedStatement.setString(2,newUser.getLastName());
            preparedStatement.setString(3,newUser.getEmail());
            preparedStatement.setString(4,newUser.getPassword());
            preparedStatement.setString(5, newUser.getGender());
            preparedStatement.setString(6, newUser.getDateOfBirth());
            System.out.println(preparedStatement);


            boolean createUser = preparedStatement.execute();
            System.out.println("User Created =" +  createUser);


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }




}
