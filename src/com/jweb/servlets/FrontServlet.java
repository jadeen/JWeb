package com.jweb.servlets;

import javax.servlet.annotation.*;

import javax.servlet.*;

/**
 * Created by Kevin Marrec on 12/14/2015.
 */
@WebServlet(name = "FrontServlet", urlPatterns = {""})
public class FrontServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {


        this.getServletContext().getRequestDispatcher( "/front.jsp" ).forward
                ( request, response );

    }
}
