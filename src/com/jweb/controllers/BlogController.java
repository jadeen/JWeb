package com.jweb.controllers;

import com.jweb.beans.Article;
import com.jweb.models.ArticleModel;
import com.jweb.models.UserModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java Servlet
 */
@WebServlet(name = "BlogController", urlPatterns = {"/blog/*"})
public class BlogController extends javax.servlet.http.HttpServlet {
    /** Define pour l'url /blog */
    static final String HOME = "/blog";
    /** Define pour l'url /blog/creqte */
    static final String CREATE = "/blog/create";

    /**
     * doPost est une method appelé par les servlets JAVA en cas de requête de type post avec une url commencent par /blog
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        switch (request.getRequestURI()){
            case CREATE:
                doPostCreate(request, response);
        }
    }

    /**
     * Fonction appeler en cas de requete de type POST vers l'url /blog/create par la fonction doPost()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    private void doPostCreate(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();

        ArticleModel articleModel = new ArticleModel();

        Article article = new Article();

        article.setContent(request.getParameter("content"));
        article.setTitle(request.getParameter("titre"));
        article.setIdAuthor(user.currentUser.getId());

        articleModel.addArticle(article);

        user.settingCurrentUserData();
        response.sendRedirect("/blog");
    }

    /**
     * Fonction appeler en cas de requete de type GET vers l'url /blog par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    private void doGetBlog(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException{
        ArticleModel articles = new ArticleModel();

        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);

        request.setAttribute("articles", articles.all());

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/blog.jsp").forward
                (request, response);
    }

    /**
     * Fonction appeler en cas de requete de type GET vers l'url /blog/create par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    private void doGetCreate(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);

        if (user.currentUser.getConnect() && user.currentUser.getAdmin()) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/createBlog.jsp").forward
                    (request, response);
        }
        else {
            response.sendRedirect("/blog");
        }
    }

    /**
     * doGet est une method appelé par les servlets JAVA en cas de requête de type Get avec une url commencent par /blog
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException genere des exception si notre servlet a un problème
     * @throws java.io.IOException genere des execption Java
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String url = request.getRequestURI();
        switch (url){
            case HOME:
                doGetBlog(request, response);
                break;
            case CREATE:
                doGetCreate(request, response);
        }
    }
}
