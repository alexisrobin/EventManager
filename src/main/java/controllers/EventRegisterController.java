package controllers;

import authentication.AuthManager;
import authentication.AuthRequirement;
import models.Event;
import models.Registrant;
import models.User;
import models.dao.EventDAO;
import models.dao.RegistrantDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Event registration's controller.
 */
public class EventRegisterController implements PageController{

    @Override
    public AuthRequirement.AuthRequirementState getAuthRequirementState() {
        return AuthRequirement.AuthRequirementState.IS_NOT_REQUIRED;
    }

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = AuthManager.with(request.getSession()).getCurrentUser();
        boolean isLogged = currentUser != null;
        request.setAttribute("isLogged", isLogged);
        request.setAttribute("isOnEvents", false);
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String companyName = request.getParameter("companyName");
        String mail = request.getParameter("mail");
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        EventDAO eDAO = new EventDAO();
        Event event = eDAO.findEventById(eventId);
        if (lastName != null && !lastName.isEmpty()
                && firstName != null && !firstName.isEmpty()
                && companyName != null
                && mail != null
                && event != null) {
            RegistrantDAO rDAO = new RegistrantDAO();
            Registrant registrant = new Registrant.RegistrantBuilder()
                    .setLastName(lastName)
                    .setFirstName(firstName)
                    .setCompanyName(companyName)
                    .setMail(mail)
                    .setEvent(event).build();
            rDAO.create(registrant);
            request.getSession().setAttribute("message", "Inscription succeeded");
            response.sendRedirect(request.getContextPath() + "/action/event/" + eventId + "/eventAddOk");
        } else {
            request.getSession().setAttribute("message", "Inscription failed");
            response.sendRedirect(request.getContextPath() + "/action/event/" + eventId);
        }
    }
}