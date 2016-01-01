package com.jweb.controllers;

import com.jweb.models.OpinionModel;
import com.jweb.models.UserModel;

import javax.servlet.annotation.*;

/**
 * Java Servlet
 */
@WebServlet(name = "FrontController", urlPatterns = {""})
public class FrontController extends javax.servlet.http.HttpServlet {
    /** Define pour l'url / */
    static final String HOME = "/";

    /**
     * doPost est une method appelé par les servlets JAVA en cas de requête de type post ayant pour url /
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    /**
     * Fonction appeler en cas de requete de type GET vers l'url / par la fonciton doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    private void doGetHome(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        OpinionModel opinion = new OpinionModel();

        opinion.all();

        request.setAttribute("opinion", opinion.getRandomOpinion());

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);

        this.getServletContext().getRequestDispatcher( "/WEB-INF/views/front.jsp" ).forward
                ( request, response );
    }

    /**
     * doGet est une method appelé par les servlets JAVA en cas de requête de type GET ayant pour url /
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        switch (request.getRequestURI()){
            case HOME:
                doGetHome(request, response);
        }
    }
}
