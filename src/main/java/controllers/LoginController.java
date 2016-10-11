package controllers;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexis on 05/10/2016.
 */
public class LoginController implements PageController{

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("name", "kepa");
        return "login.jsp";
    }
}
