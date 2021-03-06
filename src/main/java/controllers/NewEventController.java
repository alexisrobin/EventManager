package controllers;

import authentication.AuthManager;
import models.Event;
import models.User;
import models.dao.EventDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * New event's controller.
 */
public class NewEventController implements PageController {

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLogged", true);
        request.setAttribute("isOnEvents", false);
        request.getRequestDispatcher("/partials/newevent.jsp").forward(request, response);
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("eventName");
        String address = request.getParameter("eventAddress");
        User currentUser = AuthManager.with(request.getSession()).getCurrentUser();
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yy HH:mm");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateParser.parse(request.getParameter("eventStartDate"));
            endDate = dateParser.parse(request.getParameter("eventEndDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(     name != null && !name.isEmpty()
                && address != null && !address.isEmpty()
                && currentUser != null && startDate != null
                && endDate != null){
            System.out.println("add event");
            EventDAO eventDAO = new EventDAO();
            Event e = new Event.EventBuilder().setName(name).setAddress(address).setUser(currentUser).setStartDate(startDate).setEndDate(endDate).build();
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
