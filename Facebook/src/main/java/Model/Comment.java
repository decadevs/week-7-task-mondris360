package Model;

import java.sql.Timestamp;
public class Comment {
    private int id;
    private int postID;
    private int userID;
    private String comment;
    private Timestamp date;

    // constructor
    public Comment(int commentID, int postID, int userID, String comment, Timestamp date) {
        this.id = commentID;
        this.postID = postID;
        this.userID = userID;
        this.comment = comment;
        this.date = date;
    }

    // overloaded constructor
    public Comment(int postID, int userID, String comment, Timestamp date) {
        this.postID = postID;
        this.userID = userID;
        this.comment = comment;
        this.date =  date;
    }

    public Comment(int postID, int userID, String comment) {
        this.postID = postID;
        this.userID = userID;
        this.comment = comment;
    }

    public int getCommentID() {
        return id;
    }

    public void setCommentID(int commentID) {
        this.id = commentID;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return getPostID() + " " +  getUserID() + " " +  getComment() + getDate();
    }
}
