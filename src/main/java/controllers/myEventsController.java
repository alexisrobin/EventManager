package controllers;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by il-es on 17/10/2016.
 */
public class myEventsController implements PageController {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("name", "kepa");
        return "/partials/mesEvenements.jsp";
    }
}
