package com.jweb.controllers;

import com.jweb.models.OpinionModel;
import com.jweb.models.UserModel;

import javax.servlet.annotation.*;

/**
 * Created by Kevin Marrec on 12/14/2015.
 */
@WebServlet(name = "FrontController", urlPatterns = {""})
public class FrontController extends javax.servlet.http.HttpServlet {
    static final String HOME = "/";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    private void doGetHome(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        OpinionModel opinion = new OpinionModel();

        opinion.countElement();

        opinion.getRandomOpinion();
        request.setAttribute("opinionText", opinion._text);

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);

        this.getServletContext().getRequestDispatcher( "/WEB-INF/views/front.jsp" ).forward
                ( request, response );
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        switch (request.getRequestURI()){
            case HOME:
                doGetHome(request, response);
        }
    }
}
