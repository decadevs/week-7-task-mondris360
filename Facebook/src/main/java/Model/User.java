package Model;

import java.sql.Timestamp;

public class User {
    private int userID;
    private String firstName;
    private  String lastName;
    private String email;
    private  String password;
    private String gender;
    private String DateOfBirth;
    private Timestamp dateCreated;
    private Timestamp lastLogin;
    private String active;

    // an overloaded constructor(for creating a new user)
    public User(int userID, String firstName, String lastName, String email, String password,  String gender, String DateOfBirth,
                Timestamp dateCreated, Timestamp lastLogin, String active) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.DateOfBirth = DateOfBirth;
        this.dateCreated = dateCreated;
        this.lastLogin = lastLogin;
        this.active = active;
    }

    // an overloaded constructor (to update/ create a user)
    public User(String firstName, String lastName, String email, String password, String gender,
                String DateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.DateOfBirth = DateOfBirth;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDOB(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getStatus() {
        return active;
    }

    public void setActive(String status) {
        this.active = active;
    }

    @Override
    public String toString() {
        return getUserID() + " " +  getFirstName() + " " + getLastName() + " " + getEmail() + " " + getGender() + " " +  getDateOfBirth() + " "
                + getDateCreated();
    }
}
