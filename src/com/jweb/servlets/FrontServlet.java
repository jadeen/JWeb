package com.jweb.servlets;

import com.jweb.module.Opinion;
import com.jweb.module.User;

import javax.servlet.annotation.*;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 * Created by Kevin Marrec on 12/14/2015.
 */
@WebServlet(name = "FrontServlet", urlPatterns = {""})
public class FrontServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        User user = new User(request.getSession());

        Opinion opinion = new Opinion();

        opinion.countElement();

        opinion.getRandomOpinion();
        request.setAttribute("opinionText", opinion._text);

        if (user.isConnect()){
            request.setAttribute("isConnect", true);
            user.getUserData();
            request.setAttribute("name", user.getCompletName());
        }else {
            request.setAttribute("isConnect", false);
        }

        this.getServletContext().getRequestDispatcher( "/front.jsp" ).forward
                ( request, response );
    }
}
