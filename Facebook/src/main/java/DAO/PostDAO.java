package DAO;

import Model.Comment;
import Model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PostDAO {
  // sql queries
    private String postTable = "posts";
    private String createPostsql = "INSERT INTO " + postTable + "(userID, message) VALUES(?, ?)";
//    private String getuserPosts = " SELECT * FROM   posts WHERE userID = ? order by date DESC";
    private  String  getUsersPosts = "SELECT posts.userID, posts.postID, posts.message, posts.date, count(likes.id) as totalLikes\n" +
        "        FROM posts \n" +
        "        LEFT JOIN likes ON \n" +
        "        posts.postID =  likes.PostID WHERE posts.deleted = 'false' and posts.userID =? GROUP BY postID ORDER BY posts.date DESC;";
    private String deleteAPost = "DELETE  FROM likes ? WHERE postID = ?";
    private String getAPost = "SELECT * FROM posts WHERE postID = ?";
    // sql queries for post likes
        private String getPostLikeSQL = "SELECT * FROM  likes WHERE postID = ? AND userID = ?";

    private String likePostSQl = "INSERT INTO likes (postID, userID) VALUES(?, ?)";
    private String unlikePostSql = "DELETE  FROM likes  WHERE postID = ? AND userID = ?";
    private String createCommentSql = "INSERT INTO COMMENTS(postID, userID, comment) VALUES (?, ?, ?)";
    private String getComments = "SELECT * FROM comments WHERE postID = ?";
    private String getPostContentByIdSql = "SELECT message from  posts WHERE postID = ?";
    private  String updatePostSql  = "UPDATE posts SET message = ? WHERE postID = ?";
    private  String deletePostSql = "UPDATE posts SET deleted = ?  WHERE postID = ?";

    // method to create a new post
    public boolean createPost(Post post){
        boolean status = false;
        try (Connection connection =DBConnection.getConnection()) {
            // create a prepared statement
            PreparedStatement preparedStatement =  connection.prepareStatement(createPostsql);
            // set the values of the statement
            preparedStatement.setInt(1, post.getUserID());
            preparedStatement.setString(2, post.getMessage());
            // execute the query
            preparedStatement.execute();
            status =  true;
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Could Not Create Post");
        }
        return status;
    }


    // method to fetch all the posts of a single user from the db
    public Map<Post, List<Comment>> getUserPosts(int userID) throws SQLException {
//        List<Post> userPosts =  new ArrayList<>();
        Map<Post, List<Comment>>  userPosts =  new LinkedHashMap<Post, List<Comment>>();

        // get a db connection
        Connection connection =  DBConnection.getConnection();
        // create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(getUsersPosts);
        // set the values of the prepared statement
        preparedStatement.setInt(1, userID);
        ResultSet resultSet =  preparedStatement.executeQuery();


        // loop through the result and use each record to create a post object
        while (resultSet.next()){
            int postID =  resultSet.getInt("postID");
//            int storedUserId =  resultSet.getInt("userID");
            String message =  resultSet.getString("message");
            int totalLikes =  resultSet.getInt("totalLikes");
//            String deleted =  resultSet.getString("deleted");
            Timestamp date = resultSet.getTimestamp("date");
            Post post =  new Post(postID, 0000, message, "No", date,totalLikes );
             // get all the comments for the post
            List postComments =  getComments(postID);
            userPosts.put(post, postComments);
            // add the post object to our array list
//            userPosts.add(post);
        }
        return userPosts;
    }

    // method to like or Unlike a post
    public  void likeOrUnlikePost(int postID, int userID) throws SQLException {
        System.out.println("inside like or unlike()");
        // check if the user has already liked the post
        try(Connection connection =  DBConnection.getConnection()){
            //create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(getPostLikeSQL);
            // set the values of the prepared statement
            preparedStatement.setInt(1, postID);
            preparedStatement.setInt(2, userID);
            ResultSet resultSet  = preparedStatement.executeQuery();
            // if the user has already liked the post,
            if(resultSet.next()){
                // unlike the post
                PreparedStatement preparedStatement1 = connection.prepareStatement(unlikePostSql);
                preparedStatement1.setInt(1, postID);
                preparedStatement1.setInt(2, userID);
                preparedStatement1.execute();
                System.out.println("unliked post!");
            } else {
                // like the post
                PreparedStatement preparedStatement1 = connection.prepareStatement(likePostSQl);
                preparedStatement1.setInt(1, postID);
                preparedStatement1.setInt(2, userID);
                preparedStatement1.execute();
                System.out.println("Liked!");

            }
        }
    }

    // method to create a new comment
    public boolean createComment(Comment comment)  {
        // get object connection
       boolean successful =  false;
       try {
            Connection connection = DBConnection.getConnection();
            // create a prepared statement
            PreparedStatement preparedStatement =  connection.prepareStatement(createCommentSql);
            // set values for the parameters
           preparedStatement.setInt(1, comment.getPostID());
           preparedStatement.setInt(2, comment.getUserID());
           preparedStatement.setString(3, comment.getComment());
            // execute query;
             boolean createStatement = preparedStatement.execute();
             successful  = true;
       } catch (SQLException e){
           e.printStackTrace();
       }
       return successful;
    }

    // method to retrieve all the comments for a particular posts
    public List<Comment> getComments(int postID)  {
       List<Comment>comments =  new ArrayList<>();
        try {
            // get db connection
            Connection connection =  DBConnection.getConnection();
            // create a prepared statement
            PreparedStatement preparedStatement =  connection.prepareStatement(getComments);
            preparedStatement.setInt(1, postID);
            ResultSet resultSet =  preparedStatement.executeQuery();
            // create a a comment object for each record in the result
            while (resultSet.next()){
                int postID2 =  resultSet.getInt("postID");
                int userID =  resultSet.getInt("userID");
                String comment =  resultSet.getString("comment");
                Timestamp date = resultSet.getTimestamp("date");
                System.out.println("Time Stamp = " + date);
                Comment comment1 = new Comment(postID2, userID, comment, date);
                // add the newly created comment to the list
                System.out.println("created comment 1" +  comment1);
                comments.add(comment1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    // method to get post content of a particular post ID
    public String getPostContentById(int postID)  {
        String postContent = "";
        try(Connection connection  = DBConnection.getConnection()) {
            // create a prepared statement
                PreparedStatement preparedStatement =  connection.prepareStatement(getPostContentByIdSql);
                // set the values of the prepared statement
               preparedStatement.setInt(1, postID);
               // execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                postContent =  resultSet.getString("message");
                System.out.println("Post Content = " + postContent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to get post Content");
        }

        return postContent;
    }

    //method to update post
    public  boolean updatePost (Post post) {
        boolean successful =  false;
        // get a connection
        try (Connection connection = DBConnection.getConnection()) {
            // create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(updatePostSql);
            // set the values of the  statement
            preparedStatement.setString(1, post.getMessage());
            preparedStatement.setInt(2, post.getPostID());
            // execute the command
            boolean updatePost = preparedStatement.execute();
            successful = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  successful;
    }

    // METHOD TO DELETE A POST
    public boolean deletePost(int postID){
        boolean successful =  false;
        // create a prepared statement
        try (Connection connection  = DBConnection.getConnection()){
            // create a prepared statement
            // i prefer to delete a row by setting the  value of  the deleted column to true, to avoid the overhead of deleting a key
            // that is a foreign key in other tables;
            PreparedStatement preparedStatement =  connection.prepareStatement(deletePostSql);
            preparedStatement.setString(1,"true");
            preparedStatement.setInt(2, postID);

            boolean deletePost =  preparedStatement.execute();
            if (deletePost){
                successful =  true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
       return  successful;
    }

}
