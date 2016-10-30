package controllers;

import authentication.AuthRequirement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Interface which defines methods for the eventmanager's services/pages.
 */
public interface PageController extends AuthRequirement {
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
