package servlet;

import authentication.AuthManager;
import controllers.LoginController;
import controllers.MyEventsController;
import controllers.NewEventController;
import controllers.PageController;
import authentication.AuthRequirement;
import models.User;
import models.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexis on 05/10/2016.
 */
@WebServlet(name = "FrontController", urlPatterns = "/action/*")
public class FrontController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PageController ctrl = process(request, response);
        if(ctrl != null){
            ctrl.postExecute(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PageController ctrl = process(request,response);
        if(ctrl != null){
            ctrl.getExecute(request, response);
        }
    }

    protected PageController process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // response.setContentType("text/html");
        HttpSession session = request.getSession();
        PageController ctrl = null;
        String requestUri = request.getRequestURI();
        if(requestUri.contains("login")){
            ctrl = new LoginController();
        } else if (requestUri.contains("events")){
            ctrl = new MyEventsController();
        } else if (requestUri.contains("new")){
            ctrl = new NewEventController();
        } else if (requestUri.contains("auth")){
            // Simulate test auth (create user if he doesn't exist)
            if(!AuthManager.getInstance(session).authenticate("robinalexis@outlook.fr", "okok")){
                System.out.println("create test user");
                User newUser = new User.UserBuilder().setMail("robinalexis@outlook.fr").setPassword("okok").build();
                UserDAO uDAO = new UserDAO();
                uDAO.create(newUser);
                AuthManager.getInstance(session).authenticate("robinalexis@outlook.fr", "okok");
            }
            System.out.println(AuthManager.getInstance(session).isUserAuthenticate());
        }

        return this.authenticationSecurityCheck(request, response, ctrl);
    }

    protected PageController authenticationSecurityCheck(HttpServletRequest request, HttpServletResponse response, PageController ctrl) throws IOException {
        // Authentication
        if(     ctrl != null
                && ctrl.getAuthRequirementState() == AuthRequirement.AuthRequirementState.IS_REQUIRED
                && !AuthManager.getInstance(request.getSession()).isUserAuthenticate()){
            System.out.println("Authentication is required to access this website's part");
            ctrl =  null;
            response.sendRedirect("login");
        }

        return ctrl;
    }

}
