package servlet;

import controllers.LoginController;
import controllers.MyEventsController;
import controllers.PageController;
import models.User;
import models.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexis on 05/10/2016.
 */
@WebServlet(name = "FrontController", urlPatterns = "/action/*")
public class FrontController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request,response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // response.setContentType("text/html");
        HttpSession session = request.getSession();
        PageController ctrl = null;
        String requestUri = request.getRequestURI();
        if(requestUri.contains("login")){
            ctrl = new LoginController();
        } else if (requestUri.contains("events")){
            ctrl = new MyEventsController();
        } else if (requestUri.contains("tests")){

            System.out.println("create user");
            UserDAO uDao = new UserDAO();
            User u = new User.UserBuilder().setMail("robinalexis@outlook.fr").setPassword("okok").build();
            uDao.create(u);

            System.out.println("find user");
            User uFind = uDao.find("robinalexis@outlook.fr");
            System.out.println(uFind.getPassword());
        }
        System.out.println(requestUri);
        if(ctrl != null){
            String pageName = ctrl.execute(request);
            request.getRequestDispatcher(pageName).forward(request, response);
        }
    }
}
