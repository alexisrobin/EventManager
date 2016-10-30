package controllers;

import authentication.AuthRequirement;
import models.Event;
import models.Registrant;
import models.dao.EventDAO;
import models.dao.RegistrantDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Deleting event's contoller.
 */
public class DeleteEventController implements PageController {
    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_REQUIRED;
    }

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eDAO = new EventDAO();
        RegistrantDAO rDAO = new RegistrantDAO();
        request.setAttribute("isLogged", true);
        request.setAttribute("isOnEvents", false);
        Event event = this.retrieveEventWithUri(request);

        // Check if the event has no registrant
        if(rDAO.findRegistrantsByEvent(event).isEmpty()){
            eDAO.delete(this.retrieveEventWithUri(request));
            response.sendRedirect(request.getContextPath() + "/action/events/evtDelOk");
        } else {
            response.sendRedirect(request.getContextPath() + "/action/events/evtDelFail");
        }
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Event retrieveEventWithUri(HttpServletRequest request){
        String uri = request.getRequestURI();
        String splittedUri[] = uri.split("/");
        int eventId = Integer.parseInt(splittedUri[splittedUri.length-2]);
        EventDAO eDAO = new EventDAO();
        return eDAO.findEventById(eventId);
    }
}
