package com.jweb.controllers;

import com.jweb.beans.Newsletter;
import com.jweb.beans.Opinion;
import com.jweb.models.NewsletterModel;
import com.jweb.models.OpinionModel;
import com.jweb.models.UserModel;

import javax.servlet.annotation.WebServlet;

/**
 * Java Servlet
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product/*"})
public class ProductController extends javax.servlet.http.HttpServlet{
    /** Define pour l'url /product */
    static final String HOME = "/product";
    /** Define pour l'url /product/newsletter */
    static final String NEWSLETTER = "/product/newsletter";
    /** Define pour l'url /product/opinion */
    static final String OPINION = "/product/opinion";

    /**
     * Fonction appelée en cas de requête de type POST vers l'url /product/newsletter par la fonction doPost()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doPostNewsletter(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        NewsletterModel newsletterModel = new NewsletterModel();

        if (request.getParameter("mail") != null){
            Newsletter newsletter = new Newsletter();

            newsletter.setMail(request.getParameter("mail"));
            if (newsletterModel.subscribeNewsletter(newsletter)){
                response.sendRedirect("/");
            }else {
                response.sendRedirect("/");
            }
        }
    }

    /**
     * Fonction appelée en cas de requête de type POST vers l'url /product/opinion par la fonction doPost()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doPostOpinion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        OpinionModel opinionModel = new OpinionModel();
        UserModel user = new UserModel(request.getSession());
        if (user.currentUser.getConnect()){
            user.settingCurrentUserData();
            if (request.getParameter("opinion") != null){
                Opinion opinion = new Opinion();

                opinion.setOpinion(request.getParameter("opinion"));

                opinion.setIdUser(user.currentUser.getId());

                opinionModel.addUserOpinion(opinion);
            }
        }
        response.sendRedirect("/");
    }

    /**
     * doPost est une méthode appelée par les servlets JAVA en cas de requête de type post avec une url commençant par /product
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        switch (request.getRequestURI()){
            case NEWSLETTER:
                doPostNewsletter(request, response);
                break;
            case OPINION:
                doPostOpinion(request, response);
                break;
        }
    }

    /**
     * Fonction appelée en cas de requête de type GET vers l'url /product par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doGetHome(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/product.jsp").forward
                (request, response);
    }

    /**
     * doGet est une méthode appelée par les servlets JAVA en cas de requête de type GET avec une url commençant par /product
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        switch (request.getRequestURI()) {
            case HOME:
                doGetHome(request, response);
                break;

        }
    }
}