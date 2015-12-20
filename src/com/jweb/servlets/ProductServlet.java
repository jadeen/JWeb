package com.jweb.servlets;

import com.jweb.module.Newsletter;
import com.jweb.module.Opinion;
import com.jweb.module.User;

import javax.security.auth.Subject;
import javax.servlet.annotation.WebServlet;

/**
 * Created by mickael on 12/20/2015.
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product/*"})
public class ProductServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Newsletter news = new Newsletter();
        if (request.getRequestURI().equals("/product/newsletter")){
            System.out.println(request.getParameter("mail"));
            if (request.getParameter("mail") != null){
                if (news.subscribeNewsletter(request.getParameter("mail"))){
                    System.out.println("subscription reussi");
                }else {
                    response.sendRedirect("/");
                }
            }
        } else if (request.getRequestURI().equals("/product/opinion")){
            Opinion opinion = new Opinion();
            System.out.println("ok");
            User user = new User(request.getSession());
            if (user.isConnect()){
                user.getUserData();
                if (request.getParameter("opinion") != null){
                    opinion.addUserOpinion(user, request.getParameter("opinion"));
                }
            }
            response.sendRedirect("/");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
    }
}