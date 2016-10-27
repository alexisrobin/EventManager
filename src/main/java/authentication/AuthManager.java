package authentication;

import models.User;
import models.dao.UserDAO;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

/**
 * Created by Alexis on 25/10/2016.
 */
public class AuthManager {

    private static AuthManager SINGLETON = null;
    private static HttpSession session;

    private AuthManager(HttpSession session){
        this.session = session;
    }

    public static AuthManager getInstance(HttpSession session){
        if(SINGLETON == null){
            SINGLETON = new AuthManager(session);
        }
        return SINGLETON;
    }

    public boolean authenticate(String mail, String password){
        UserDAO uDAO = new UserDAO();
        User resultUser = uDAO.find(mail, password);
        this.session.setAttribute("user", resultUser);
        return resultUser != null;
    }

    public User getCurrentUser(){
        try{
            return (User) this.session.getAttribute("user");
        } catch(IllegalStateException e){
            return null;
        }
    }

    public boolean isUserAuthenticate() {
        try{
            return this.session.getAttribute("user") != null;
        } catch(IllegalStateException e){
            return false;
        }
    }

    public void invalidateUserAuthentication(){
        this.session.invalidate();
    }

}
