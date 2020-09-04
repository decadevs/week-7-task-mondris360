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

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    UserDAO userDAO =  new UserDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // create the dispatcher instance to forward  the req and res object to jsp
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.jsp");
        // forward the request to the
        requestDispatcher.forward(request, response);
    }

    // method to handle the signup route post request
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        boolean createUser;
        String firstName =  request.getParameter("firstName");

        String lastName =  request.getParameter("lastName");
        String email =  request.getParameter("email");
        String password =  request.getParameter("password");
        String birthdayDay = request.getParameter("birthday_day");
        String birthdayMonth = request.getParameter("birthday_month");
        String birthdayYear = request.getParameter("birthday_year");
        String dateOfBirth =  birthdayDay+"-"+ birthdayMonth + "-" + birthdayYear;
        String gender =  request.getParameter("gender");


        try {
            // create a new user object
            User newUser =  new User(firstName, lastName, email, password, gender, dateOfBirth);
            //  create the user
            createUser =  userDAO.createNewUser(newUser);
            // get the user auto generated userID from from the db
            HttpSession session  =  request.getSession();
            if (createUser){
                User getUserDetails =  userDAO.getUserByEmail(email);
                // store the object in the request session
                session.setAttribute("userID", getUserDetails.getUserID());
                session.setAttribute("userFirstName", getUserDetails.getFirstName());
                response.sendRedirect("./viewPosts");
            } else {
                request.setAttribute("errorMessage" , "A User With That Email Already Exist");
                RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.jsp");
                // forward the request to the
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException| IOException e) {
                e.printStackTrace();

            // forward the request to the
            try {
                request.setAttribute("errorMessage" , "An Error Occurred While Processing Your Request");
                RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }catch (ServletException | IOException z){
                z.printStackTrace();
            }
        }






    }
}
