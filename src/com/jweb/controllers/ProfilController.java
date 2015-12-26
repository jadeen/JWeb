package com.jweb.controllers;

import com.jweb.models.UserModel;
import com.jweb.tools.SqlManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * Created by mickael on 12/19/2015.
 */
@WebServlet(name = "ProfilController", urlPatterns = {"/profil/*"})
public class ProfilController extends javax.servlet.http.HttpServlet{

    static final String HOME = "/profil";
    static final String CONNECT = "/profil/connect";
    static final String REGISTER = "/profil/inscription";
    static final String DELETE = "/profil/delete";
    static final String STATUS_USER = "/profil/switch/status";
    static final String ADMIN = "/profil/admin";
    static final String DISCONNECT = "/profil/deconnect";

    private void doPostConnect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.setCurrentUser(request.getParameter("login"),request.getParameter("password"));

        if (user.ConnectUser()){
            user.settingCurrentUserData();
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/profil");
        }
    }

    private void doPostRegister(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        if (!request.getParameter("password").equals(request.getParameter("password2"))){
            doGet(request, response);
        }
        if (user.isExist(request.getParameter("login"))){
            if (user.createUser(request.getParameter("nom"),
                    request.getParameter("prenom"),
                    request.getParameter("mail"),
                    request.getParameter("login"),
                    request.getParameter("password"))){
                user.setCurrentUser(request.getParameter("login"),request.getParameter("password"));
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
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        switch (request.getRequestURI()){
            case CONNECT:
                doPostConnect(request, response);
                break;
            case REGISTER:
                doPostRegister(request, response);
                break;
        }
    }

    private void doGetDisconnect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        if (user.currentUser.getConnect()) {
            user.settingCurrentUserData();
            request.setAttribute("user", user.currentUser);

            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/");
        }
    }

    private void doGetAdmin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        if (user.currentUser.getConnect()) {
            user.settingCurrentUserData();
            request.setAttribute("user", user.currentUser);


            request.setAttribute("users", user.all());

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/userGest.jsp").forward
                    (request, response);
        }
    }

    private void doGetDelete(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        UserModel user = new UserModel(request.getSession());

        if (user.currentUser.getConnect()) {
            user.settingCurrentUserData();
            request.setAttribute("user", user.currentUser);

            user.delete(request.getParameter("id"));

            request.setAttribute("users", user.all());

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/userGest.jsp").forward
                    (request, response);
        }
    }

    private void doGetStatusUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        if (user.currentUser.getConnect()) {
            user.settingCurrentUserData();
            request.setAttribute("user", user.currentUser);

            user.switchStatus(request.getParameter("id"));

            request.setAttribute("users", user.all());

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/userGest.jsp").forward
                    (request, response);
        }
    }

    private void doGetHome(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        if (user.currentUser.getConnect()){
            user.settingCurrentUserData();
            request.setAttribute("user", user.currentUser);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/profil.jsp").forward
                    (request, response);
        }else{
            this.getServletContext().getRequestDispatcher( "/WEB-INF/views/connect.jsp" ).forward
                    ( request, response );
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        switch (request.getRequestURI()){
            case HOME:
                doGetHome(request, response);
                break;
            case DELETE:
                doGetDelete(request, response);
                break;
            case STATUS_USER:
                doGetStatusUser(request, response);
                break;
            case ADMIN:
                doGetAdmin(request, response);
                break;
            case DISCONNECT:
                doGetDisconnect(request, response);
                break;
        }
    }
}
