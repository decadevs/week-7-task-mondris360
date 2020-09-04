package Model;

import java.sql.Timestamp;

public class Post {
    private int postID;
    private int userID;
    private String message;
    private String deleted;
    private Timestamp date;
    private  int totalLikes;

    // contructor
    public Post(int postID, int userID, String message, String deleted, Timestamp date, int totalLikes) {
        this.postID = postID;
        this.userID = userID;
        this.message = message;
        this.deleted = deleted;
        this.date = date;
        this.totalLikes =  totalLikes;
    }

    // overloaded constructor
    public Post(int userID, String message) {
        this.userID = userID;
        this.message = message;
    }

    // overloaded constructor
    public Post( int postID, int userID, String message) {
        this.userID = userID;
        this.message = message;
        this.postID = postID;
    }



    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", userID=" + userID +
                ", message='" + message + '\'' +
                ", deleted='" + deleted + '\'' +
                ", date=" + date +
                '}';
    }
}
