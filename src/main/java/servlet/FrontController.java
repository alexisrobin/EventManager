package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 05/10/2016.
 */
@WebServlet(name = "FrontCOntroller", urlPatterns = "/")
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
        String requestUri = request.getRequestURI();
        if(requestUri.contains("login")){

        }
    }
}
