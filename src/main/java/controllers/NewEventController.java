package controllers;

import authentication.AuthManager;
import models.Event;
import models.User;
import models.dao.EventDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 24/10/2016.
 */
public class NewEventController implements PageController {

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/partials/newevent.jsp").forward(request, response);
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("eventName");
        String address = request.getParameter("eventAddress");
        User currentUser = AuthManager.with(request.getSession()).getCurrentUser();
        if(     name != null && !name.isEmpty()
                && address != null && !address.isEmpty()
                && currentUser != null){
            System.out.println("add event");
            EventDAO eventDAO = new EventDAO();
            Event e = new Event.EventBuilder().setName(name).setAddress(address).setUser(currentUser).build();
            eventDAO.create(e);
            response.sendRedirect(request.getContextPath() + "/action/events");
        } else {
            response.sendRedirect(request.getContextPath() + "/action/newError");
        }
    }

    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_REQUIRED;
    }
}
