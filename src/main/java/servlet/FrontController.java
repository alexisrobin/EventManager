package servlet;

import controllers.LoginController;
import controllers.PageController;

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
        PageController ctrl = process(request, response);
        if(ctrl != null){
            String pageName = ctrl.postExecute(request);
            request.getRequestDispatcher(pageName).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PageController ctrl = process(request,response);
        if(ctrl != null){
            String pageName = ctrl.getExecute(request);
            request.getRequestDispatcher(pageName).forward(request, response);
        }
    }

    protected PageController process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // response.setContentType("text/html");
        HttpSession session = request.getSession();
        PageController ctrl = null;
        String requestUri = request.getRequestURI();
        if(requestUri.contains("login")){
            ctrl = new LoginController();
        }
        System.out.println(requestUri);
        return ctrl;
    }
}
