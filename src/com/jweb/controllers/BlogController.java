package com.jweb.controllers;

import com.jweb.beans.Article;
import com.jweb.models.ArticleModel;
import com.jweb.models.UserModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "BlogController", urlPatterns = {"/blog/*"})
public class BlogController extends javax.servlet.http.HttpServlet {
    static final String HOME = "/blog";
    static final String CREATE = "/blog/create";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        switch (request.getRequestURI()){
            case CREATE:
                doPostCreate(request, response);
        }
    }

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
    }

    private void doGetBlog(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException{
        ArticleModel articles = new ArticleModel();

        UserModel user = new UserModel(request.getSession());

        if (user.currentUser.getConnect()) {
            request.setAttribute("isConnect", true);
            user.settingCurrentUserData();
            request.setAttribute("name", user.getCompletName());
        } else {
            request.setAttribute("isConnect", false);
        }

        request.setAttribute("articles", articles.all());

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/blog.jsp").forward
                (request, response);
    }

    private void doGetCreate(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/createBlog.jsp").forward
                (request, response);
    }

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
