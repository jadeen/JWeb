package com.jweb.servlets;

import com.jweb.module.User;
import com.jweb.sql.SqlManager;

import javax.servlet.annotation.WebServlet;

/**
 * Created by mickael on 12/19/2015.
 */
@WebServlet(name = "ProfilServlet", urlPatterns = {"/profil/*"})
public class ProfilServlet extends javax.servlet.http.HttpServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        User user = new User(request.getSession());

        String type = request.getParameter("type");
        if (request.getRequestURI().equals("/profil/connect")){
            user._login = request.getParameter("login");
            user._password = request.getParameter("password");

            if (user.ConnectUser()){
                user.getUserData();
                response.sendRedirect("/");
            }else {
                response.sendRedirect("/profil");
            }

        }else if (request.getRequestURI().equals("/profil/inscription")){
            if (!request.getParameter("password").equals(request.getParameter("password2"))){
                doGet(request, response);
            }
            if (user.isExist(request.getParameter("login"))){
                if (user.createUser(request.getParameter("nom"),
                        request.getParameter("prenom"),
                        request.getParameter("mail"),
                        request.getParameter("login"),
                        request.getParameter("password"))){
                    user._login = request.getParameter("login");
                    user._password = request.getParameter("password");
                    if (user.ConnectUser()){
                        response.sendRedirect("/");
                    }else {
                        System.out.println("ok");
                        response.sendRedirect("/profil");
                    }
                }
            }
            else {
                response.sendRedirect("/profil");
            }
            sm.closeConnection();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        System.out.println(request.getRequestURI());

        this.getServletContext().getRequestDispatcher( "/connect.jsp" ).forward
                ( request, response );

    }
}
