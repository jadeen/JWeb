package com.jweb.controllers;

import com.jweb.models.NewsletterModel;
import com.jweb.models.OpinionModel;
import com.jweb.models.UserModel;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ProductController", urlPatterns = {"/product/*"})
public class ProductController extends javax.servlet.http.HttpServlet{
    static final String HOME = "/product";
    static final String NEWSLETTER = "/product/newsletter";
    static final String OPINION = "/product/opinion";


    private void doPostNewsletter(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        NewsletterModel news = new NewsletterModel();

        if (request.getParameter("mail") != null){
            if (news.subscribeNewsletter(request.getParameter("mail"))){
                System.out.println("subscription reussi");
            }else {
                response.sendRedirect("/");
            }
        }
    }

    private void doPostOpinion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        OpinionModel opinion = new OpinionModel();
        UserModel user = new UserModel(request.getSession());
        if (user.currentUser.getConnect()){
            user.settingCurrentUserData();
            if (request.getParameter("opinion") != null){
                opinion.addUserOpinion(user, request.getParameter("opinion"));
            }
        }
        response.sendRedirect("/");
    }

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

    private void doGetHome(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/product.jsp").forward
                (request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        switch (request.getRequestURI()) {
            case HOME:
                doGetHome(request, response);
                break;

        }
    }
}