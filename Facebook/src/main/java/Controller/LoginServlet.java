package Controller;

import DAO.UserDAO;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SigninServlet")
public class LoginServlet extends HttpServlet {

    // handles the login route get request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // create the dispatcher instance to forward  the req and res object to jsp
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.jsp");
        // forward the request to the
        requestDispatcher.forward(request, response);
    }

    // handles the login route post request
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO =  new UserDAO();
        // create a session to store the user object
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String suppliedPass = request.getParameter("password");

        // get the user info
        User getUserDetails =  userDAO.getUserByEmail(email);
        if (getUserDetails == null){
            request.setAttribute("errorMessage" , "Invalid Email");
            RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.jsp");
            // forward the request to the
            requestDispatcher.forward(request, response);

        } else {
            String storedPassword  =  getUserDetails.getPassword();
            if (!suppliedPass.equals(storedPassword)){
                request.setAttribute("errorMessage" , "Invalid Password");
                RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.jsp");
                // forward the request to the
                requestDispatcher.forward(request, response);

            } else {
                // store the object in the request session
                session.setAttribute("userID", getUserDetails.getUserID());
                session.setAttribute("userFirstName", getUserDetails.getFirstName());
                System.out.println("Valid Login");
                response.sendRedirect("viewPosts");
            }
        }


    }



}
