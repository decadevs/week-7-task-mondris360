package Controller;

import DAO.PostDAO;
import Model.Comment;
import Model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
    PostDAO postDAO =  new PostDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route =  request.getServletPath();
        System.out.println("user route " +  route);
        switch (route){
            case "/viewPosts":
                showPosts(request, response);
                break;
            case "/like":
                likeOrUnlikePost(request, response);
                break;
            case "/edit":
                showEditPostPage(request, response);
                break;
            case "/delete":
                deletePost(request, response);

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = request.getServletPath();
        switch (route){
            case "/dashboard":
                createPost(request, response);
                break;
            case "/viewPosts":
                showPosts(request, response);
                break;
            case "/comment":
                createAComment(request, response);
                break;
            case "/edit":
                updatePost(request, response);


        }
    }


    // method to create a new post
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get a session object from the request
        HttpSession session =  request.getSession();
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("posts.jsp");

        int  userID = (int) session.getAttribute("userID");
        String message =  request.getParameter("postMessage");

        // create a  new post object
        Post post = new Post(userID, message);
        // store the post int he database
        boolean createPost = postDAO.createPost(post);
        if(createPost){
            System.out.println("Post Created");
            response.sendRedirect("./viewPosts");
        } else {
            System.out.println("Unable to create your post");
        }

    }

    // method to display user posts
    public void showPosts(HttpServletRequest request, HttpServletResponse response)  {
        System.out.println("inside  view post get");

        Map<Post, List<Comment>> userPosts = new LinkedHashMap<>();
        HttpSession session =  request.getSession();
        // get the user id from  the session
        int userID  =  (int) session.getAttribute("userID");
        String userFirstName = (String)session.getAttribute("userFirstName");
        System.out.println("UserID=======" +  userID);
        System.out.println("userFirstName===" +  userFirstName);
        RequestDispatcher  requestDispatcher =  request.getRequestDispatcher("posts.jsp");
        try {
            userPosts =  postDAO.getUserPosts(userID);
            if (userPosts.size() <= 0){
                // pass an array list to the jsp page
                request.setAttribute("userPosts", userPosts);
                requestDispatcher.forward(request, response);
                return;
            }
            //  store the list of post in the  req object
            request.setAttribute("userPosts", userPosts);
            requestDispatcher.forward(request, response);
        } catch(ServletException | IOException | SQLException e){
            e.printStackTrace();
            System.out.println("Unable to display posts");

        }
    }

    // method to like a post or unlike a post

    public void likeOrUnlikePost(HttpServletRequest request, HttpServletResponse response)  {
        int postID  =  Integer.parseInt(request.getParameter("postID"));
        HttpSession session =  request.getSession();
        // get the user id from the session
        int userID = (int) session.getAttribute("userID");
        // create the like
        try {
            postDAO.likeOrUnlikePost(postID, userID);
            response.sendRedirect("./viewPosts");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Unable To perform Like operation");
        }

    }

    // method to create a  new comment
    public void createAComment(HttpServletRequest request, HttpServletResponse response)  {

        try {
            // will implement latter
            HttpSession session = request.getSession();
            int userID = (int) session.getAttribute("userID");
            int postID = Integer.parseInt(request.getParameter("postID"));
            String comment =  request.getParameter("comment");

            //create a new comment object
            Comment comment1 =  new Comment(postID, userID, comment);
            // save the comment in the database
            boolean createComment = postDAO.createComment(comment1);
            if (createComment){
                System.out.println("comment created");
            } else {
                System.out.println("Could not create comment");
            }
            response.sendRedirect("./viewPosts");
        }catch (IOException e) {
            e.printStackTrace();
        }

    };

    // method to edit a post

    public void showEditPostPage(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session =  request.getSession();
        int userID = (int) session.getAttribute("userID");
        int postID  = Integer.parseInt(request.getParameter("postID"));
        String getPostContent =  postDAO.getPostContentById(postID);

         try {
             // create a request dispatcher obj to render the edit post page
             RequestDispatcher requestDispatcher =  request.getRequestDispatcher("editPost.jsp");
             Post post =  new Post(postID, userID, getPostContent);
             // add the post obj to the request object
             request.setAttribute("postToEdit", post);
             // render the page
             requestDispatcher.forward(request, response);
         }  catch (ServletException  |IOException e) {
             e.printStackTrace();
         }
    }

    // method to update a  post
    public void updatePost(HttpServletRequest request, HttpServletResponse response)  {
        // get the http Session Object
        HttpSession session =  request.getSession();
        // get the userID from the session
        int userID = (int) session.getAttribute("userID");
        int postID =  Integer.parseInt(request.getParameter("postID"));
        String newPostContent =  request.getParameter("postMessage");
        Post editedPost =  new Post(postID, userID, newPostContent);
        // update the post content
        boolean updatePost =  postDAO.updatePost(editedPost);
        if (updatePost) {
            System.out.println("post updated");
        } else {
            System.out.println("unable to  update post");
        }
        // redirect the user
        try {
            response.sendRedirect("./viewPosts");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to delete a post
    public void deletePost(HttpServletRequest request, HttpServletResponse response) {

        try {
            int postID = Integer.parseInt(request.getParameter("postID"));
            // delete the post
            boolean deletePost =  postDAO.deletePost(postID);
            if (deletePost){
                System.out.println("Post Deleted");
            } else {
                System.out.println("Unable to delete post");
            }
        }  finally {
                try {
                    response.sendRedirect("./viewPosts");
                } catch (IOException e){
                    e.printStackTrace();
                }
        }



    }
}
