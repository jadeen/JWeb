<%@ page import="com.jweb.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: mickael
  Date: 12/27/2015
  Time: 21:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top bilboquet-navbar">
    <div class="container">
        <!--<a class="navbar-brand" href="#">Projet Ara</a>-->
        <a class="navbar-brand" href="/">Acceuil</a>
        <p class="navbar-text navbar-left">
            <a href="/blog">Blog</a>
        </p>
        <p class="navbar-text navbar-right">
            <%
                User user = (User) request.getAttribute("user");

                if (!user.getConnect()){
            %>
            <a href="/profil" class="navbar-link">Se connectez/S'inscrire</a>
            <%
            }
            else {
                if (user.getAdmin()){
            %>
                <a href="/blog/create" class="navbar-link">
                    <span class="glyphicon glyphicon-plus"></span> Crée un article
                </a>

                <a href="/profil/admin" class="navbar-link">
                    <span class="glyphicon glyphicon-globe"></span> Gérer les utilisateurs
                </a>
                    <%
                    }
                %>

            <a href="/profil" class="navbar-link">
                <span class="glyphicon glyphicon-user"></span> Mon Profil
            </a>
            <%
                }
            %>
        </p>
    </div>
</nav>