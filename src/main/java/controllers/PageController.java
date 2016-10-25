package controllers;

import authentication.AuthRequirement;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexis on 05/10/2016.
 */
public interface PageController extends AuthRequirement {
    public String getExecute(HttpServletRequest request);
    public String postExecute(HttpServletRequest request);
}
