package servlet;

import authentication.AuthManager;
import controllers.*;
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
 * The only eventmanager's Servlet.
 * Delegates "doPost" and "doGet" behaviors with the requested URI to the right PageController.
 * Handles authentication requirement, redirection and information messages.
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
        AuthManager authManager = AuthManager.with(session);
        PageController ctrl = null;
        String requestUri = request.getRequestURI();
        System.out.println(requestUri);
        addInfoToRequest(request, requestUri);
        if(requestUri.contains("login")){
            ctrl = new LoginController();
        } else if (requestUri.contains("delete")){
            ctrl = new DeleteEventController();
        } else if (requestUri.contains("eventregister")){
            ctrl = new EventRegisterController();
        } else if (requestUri.contains("events")){
            ctrl = new MyEventsController();
        } else if (requestUri.contains("new")){
            ctrl = new NewEventController();
        } else if (requestUri.contains("event/")){
            ctrl = new EventController();
        } else if (requestUri.contains("register")){
            ctrl = new RegisterController();
        }
        else if (requestUri.contains("auth")){
            // Simulate test auth (create user if he doesn't exist)
            if(authManager.authenticate("robinalexis@outlook.fr", "okok")){
                System.out.println("create test user");
                User newUser = new User.UserBuilder().setMail("robinalexis@outlook.fr").setPassword("okok").build();
                UserDAO uDAO = new UserDAO();
                uDAO.create(newUser);
                authManager.authenticate("robinalexis@outlook.fr", "okok");
            }
            System.out.println(authManager.isUserAuthenticate());
        }else if (requestUri.contains("logout")){
            authManager.invalidateUserAuthentication();
            response.sendRedirect(request.getContextPath() + "/action/login");
        }

        return this.authenticationSecurityCheck(request, response, ctrl);
    }

    // Gestion des redirections : Arguments différents ajoutés à la requête d'une même page
    private void addInfoToRequest(HttpServletRequest request, String requestUri){
        // Login échoué
        if(requestUri.contains("loginFailed")){
            request.setAttribute("login-failed", "true");
        }
        // Login réussi
        else if (requestUri.contains("loginAccepted")){
            request.setAttribute("login-failed", "false");
        }
        // Redirection au login via une page non autorisée
        else if (requestUri.contains("loginAuthNeeded")){
            request.setAttribute("login-needed", "true");
        }
        // Page de login de base sans redirect
        else if(requestUri.contains("login")){
            request.setAttribute("login-failed", "null");
        }
        // Page d'event redirigée par le login réussi
        else if (requestUri.contains("eventsLoginOk")){
            request.setAttribute("login-failed", "false");
        }
        // Page d'event de base sans redirect
        else if (requestUri.contains("events")){
            request.setAttribute("login-failed", "null");
        }
        // Echec d'ajout d'un event
        else if (requestUri.contains("newError")){
            request.setAttribute("add-failed", "true");
        }
        // Ajout d'un participant à un event
        else if (requestUri.contains("eventAddOk")){
            request.setAttribute("add-reg-ok", "true");
        }
        // Suppression d'un évènement effectuée
        if (requestUri.contains("evtDelOk")){
            request.setAttribute("event-del-ok", "true");
        }
        // Suppression d'un évènement impossible
        if (requestUri.contains("evtDelFail")){
            request.setAttribute("event-del-fail", "true");
        }
    }

    protected PageController authenticationSecurityCheck(HttpServletRequest request, HttpServletResponse response, PageController ctrl) throws IOException {
        // Authentication
        if(     ctrl != null
                && ctrl.getAuthRequirementState() == AuthRequirement.AuthRequirementState.IS_REQUIRED
                && !AuthManager.with(request.getSession()).isUserAuthenticate()){
            System.out.println("Authentication is required to access this website's part");
            ctrl =  null;
            response.sendRedirect(request.getContextPath() + "/action/loginAuthNeeded");
        }

        return ctrl;
    }

}
