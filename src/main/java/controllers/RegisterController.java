package controllers;

import authentication.AuthManager;
import authentication.AuthRequirement;
import models.Event;
import models.Registrant;
import models.User;
import models.dao.EventDAO;
import models.dao.RegistrantDAO;
import models.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 26/10/2016.
 */
public class RegisterController implements PageController {
    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_NOT_REQUIRED;
    }

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLogged", "false");
        request.setAttribute("isOnEvents", "false");
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO uDao = new UserDAO();
        User u = new User.UserBuilder().setMail(request.getParameter("mailInscription")).setPassword(request.getParameter("pwdInscription")).build();
        uDao.create(u);
        if (uDao.find(request.getParameter("mailInscription"), request.getParameter("pwdInscription")) != null){
            request.setAttribute("register-failed", "false");
        } else {
            request.setAttribute("register-failed", "true");
        }
        request.getRequestDispatcher("/partials/login.jsp").forward(request, response);
    }
}
