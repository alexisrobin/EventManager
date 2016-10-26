package controllers;

import authentication.AuthManager;
import models.User;
import models.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by Alexis on 05/10/2016.
 */
public class LoginController implements PageController{

    @Override
    public String getExecute(HttpServletRequest request) {
        System.out.println("get");
        return "/partials/login.jsp";
    }
    @Override
    public String postExecute(HttpServletRequest request) {

        System.out.println("post");
        System.out.println(request.getParameter("formType"));
        String formType = request.getParameter("formType");
        if ("login".equals(formType))
        {
            UserDAO uDao = new UserDAO();
            System.out.println("find user");

            String mailConnexion = request.getParameter("mailConnexion");
            String pwdConnexion = request.getParameter("pwdConnexion");
            uDao.find(mailConnexion, pwdConnexion);
            User uFind = uDao.find(mailConnexion, pwdConnexion);
            if (uFind != null)
            {
                System.out.println(uFind.getPassword());
                AuthManager.getInstance(request.getSession()).authenticate(mailConnexion,pwdConnexion);

            }else
            {
                System.out.println("ERROR LOGIN");
            }
        }else if ("register".equals(formType))
        {
            UserDAO uDao = new UserDAO();
            User u = new User.UserBuilder().setMail(request.getParameter("mailInscription")).setPassword(request.getParameter("pwdInscription")).build();
            uDao.create(u);
        }
        return "/partials/login.jsp";
    }

    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_NOT_REQUIRED;
    }
}
