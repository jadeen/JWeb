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
     * doPost est une méthode appelée par les servlets JAVA en cas de requête de type post ayant pour url /
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    /**
     * Fonction appelée en cas de requête de type GET vers l'url / par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
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
     * doGet est une méthode appelée par les servlets JAVA en cas de requête de type GET ayant pour url /
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        switch (request.getRequestURI()){
            case HOME:
                doGetHome(request, response);
        }
    }
}
