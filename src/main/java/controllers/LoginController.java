package controllers;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by Alexis on 05/10/2016.
 */
public class LoginController implements PageController{

    @Override
    public String getExecute(HttpServletRequest request) {
        System.out.println("get");
        request.getSession().setAttribute("mailInscription", "kepa@mail.fr");
        return "/partials/login.jsp";
    }
    @Override
    public String postExecute(HttpServletRequest request) {

        System.out.println("post");
        System.out.println(request.getParameter("mailConnexion"));

        return "/partials/login.jsp";
    }

}
