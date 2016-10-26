package controllers;

import authentication.AuthManager;
import models.User;
import models.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 05/10/2016.
 */
public class RegisterController implements PageController{

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
		request.getSession().setAttribute("mailInscription", "kepa@mail.fr");
        request.getRequestDispatcher("/partials/login.jsp").forward(request, response);
    }
    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");

        UserDAO uDao = new UserDAO();
        User u = new User.UserBuilder().setMail(request.getParameter("mailInscription")).setPassword(request.getParameter("pwdInscription")).build();
        uDao.create(u);
        request.getRequestDispatcher("/partials/login.jsp").forward(request, response);
    }

    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_NOT_REQUIRED;
    }
}
