package authentication;

import models.User;
import models.dao.UserDAO;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

/**
 * Authentication Manager use to handle user's session.
 */
public class AuthManager {

    private static AuthManager instance;
    private static HttpSession session;

    public static AuthManager with(HttpSession session){
        if(instance == null){
            instance = new AuthManager(session);
        } else {
            instance.session = session;
        }
        return instance;
    }

    private AuthManager(HttpSession session){
        this.session = session;
    }

    public static boolean authenticate(String mail, String password){
        UserDAO uDAO = new UserDAO();
        User resultUser = uDAO.find(mail, password);
        session.setAttribute("user", resultUser);
        return resultUser != null;
    }

    public static User getCurrentUser(){
        return (User) session.getAttribute("user");
    }

    public static boolean isUserAuthenticate() {
        return session.getAttribute("user") != null;
    }

    public static void invalidateUserAuthentication(){
        session.invalidate();
    }

}
