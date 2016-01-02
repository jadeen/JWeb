package com.jweb.controllers;

import com.jweb.beans.User;
import com.jweb.models.UserModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * Java Servlet
 */
@WebServlet(name = "ProfilController", urlPatterns = {"/profil/*"})
public class ProfilController extends javax.servlet.http.HttpServlet{

    /** Define pour l'url /profil */
    static final String HOME = "/profil";
    /** Define pour l'url /profil/connect */
    static final String CONNECT = "/profil/connect";
    /** Define pour l'url /profil/inscription */
    static final String REGISTER = "/profil/inscription";
    /** Define pour l'url /profil/delete */
    static final String DELETE = "/profil/delete";
    /** Define pour l'url /profil/switch/status */
    static final String STATUS_USER = "/profil/switch/status";
    /** Define pour l'url /profil/admin */
    static final String ADMIN = "/profil/admin";
    /** Define pour l'url /profil/deconnect */
    static final String DISCONNECT = "/profil/deconnect";

    /**
     * Fonction appelée en cas de requête de type POST vers l'url /profil/connect par la fonction doPost()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
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

    /**
     * Fonction appelée en cas de requête de type POST vers l'url /profil/inscription par la fonction doPost()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doPostRegister(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel userModel = new UserModel(request.getSession());

        if (!request.getParameter("password").equals(request.getParameter("password2"))){
            doGet(request, response);
        }
        if (userModel.isExist(request.getParameter("login"))){
            User user = new User();

            user.setPrenom(request.getParameter("prenom"));
            user.setNom(request.getParameter("nom"));
            user.setPassword(request.getParameter("password"));
            user.setLogin(request.getParameter("login"));
            user.setMail(request.getParameter("mail"));

            if (userModel.createUser(user)){
                userModel.setCurrentUser(user.getLogin(),user.getPassword());
                if (userModel.ConnectUser()){
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

    /**
     * doPost est une méthode appelée par les servlets JAVA en cas de requête de type POST avec une url commençant par /profil
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
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

    /**
     * Fonction appelée en cas de requête de type GET vers l'url /profil/deconnect par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
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

    /**
     * Fonction appelée en cas de requête de type GET vers l'url /profil/admin par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doGetAdmin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        if (user.currentUser.getConnect() && user.currentUser.getAdmin()) {
            request.setAttribute("user", user.currentUser);


            request.setAttribute("users", user.all());

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/userGest.jsp").forward
                    (request, response);
        }
        else {
            response.sendRedirect("/");
        }
    }

    /**
     * Fonction appelée en cas de requête de type GET vers l'url /profil/delete par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doGetDelete(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        if (user.currentUser.getConnect() && user.currentUser.getAdmin()) {
            request.setAttribute("user", user.currentUser);

            user.delete(request.getParameter("id"));

            request.setAttribute("users", user.all());

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/userGest.jsp").forward
                    (request, response);
        }else {
            response.sendRedirect(STATUS_USER);
        }
    }

    /**
     * Fonction appelée en cas de requête de type GET vers l'url /profil/switch/status par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doGetStatusUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        if (user.currentUser.getConnect() && user.currentUser.getAdmin()) {
            request.setAttribute("user", user.currentUser);

            user.switchStatus(request.getParameter("id"));

            request.setAttribute("users", user.all());

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/userGest.jsp").forward
                    (request, response);
        }else {
            response.sendRedirect(STATUS_USER);
        }
    }

    /**
     * Fonction appelée en cas de requête de type GET vers l'url /profil par la fonction doGet()
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
    private void doGetHome(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        UserModel user = new UserModel(request.getSession());

        user.settingCurrentUserData();
        request.setAttribute("user", user.currentUser);

        if (user.currentUser.getConnect()){
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/profil.jsp").forward
                    (request, response);
        }else{
            this.getServletContext().getRequestDispatcher( "/WEB-INF/views/connect.jsp" ).forward
                    ( request, response );
        }
    }

    /**
     * doGet est une méthode appelée par les servlets JAVA en cas de requête de type GET avec une url commençant par /profil
     * @param request variable de type HttpServletRequest
     * @param response variable de type HttpServletReponse
     * @throws javax.servlet.ServletException Génère des exceptions si notre servlet a un problème
     * @throws java.io.IOException Génère des exceptions Java
     */
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
