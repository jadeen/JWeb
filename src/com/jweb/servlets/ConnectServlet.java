package com.jweb.servlets;

import javax.servlet.annotation.WebServlet;
import java.util.Map;

/**
 * Created by mickael on 12/19/2015.
 */
@WebServlet(name = "ConnectServlet", urlPatterns = {"/connect"})
public class ConnectServlet extends javax.servlet.http.HttpServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String type = request.getParameter("type");
        if (type.equals("connect")){
            String login = request.getParameter("login");
            String password = request.getParameter("password");
        }else if (type.equals("inscription")){
            if (!request.getParameter("password").equals(request.getParameter("password2"))){
                System.out.println("invalid password");
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {


        this.getServletContext().getRequestDispatcher( "/connect.jsp" ).forward
                ( request, response );

    }
}
