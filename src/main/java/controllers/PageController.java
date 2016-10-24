package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 05/10/2016.
 */
public interface PageController {
    public String getExecute(HttpServletRequest request);
    public String postExecute(HttpServletRequest request);

}
