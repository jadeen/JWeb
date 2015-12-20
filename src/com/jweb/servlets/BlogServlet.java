package com.jweb.servlets;

import com.jweb.sql.SqlManager;

import javax.servlet.annotation.WebServlet;
import java.sql.Array;
import java.sql.ResultSet;

/**
 * Created by Kevin Marrec on 12/14/2015.
 */
@WebServlet(name = "BlogServlet", urlPatterns = {"/blog"})
public class BlogServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        SqlManager sm = SqlManager.getInstance();

        this.getServletContext().getRequestDispatcher( "/blog.jsp" ).forward
                ( request, response );
    }
}
