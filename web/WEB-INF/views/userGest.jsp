<%@ page import="com.jweb.beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: mickael
  Date: 12/21/2015
  Time: 17:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projet Ara</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
<div class="container-fluid">
    <%@include file="/WEB-INF/views/nav.jsp" %>

    <p class="big-space"></p>

    <h1 class="text-center">Gérer vos utilisateurs</h1>

    <div class="row">
        <div class="container">
            <table class="table table-hover table-condensed table-bordered">
                <thead>
                    <tr>
                        <th>Login</th>
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>Adresse Mail</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<User> list = (ArrayList<User>)request.getAttribute("users");

                        for (Iterator<User> it = list.iterator(); it.hasNext();)
                        {
                            User a = it.next();
                    %>
                    <tr>
                        <td><% out.println(a.getLogin()); %></td>
                        <td><% out.println(a.getPrenom()); %></td>
                        <td><% out.println(a.getNom()); %></td>
                        <td><% out.println(a.getMail()); %></td>
                        <td class="btn-group">
                            <a href="/profil/delete?id=<%= a.getId()%>">
                                <button title="Supprimer l'utilisateur" class="btn btn-danger">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </button>
                            </a>
                            <%
                                if (a.getAdmin()){

                            %>
                            <a href="/profil/switch/status?id=<%= a.getId()%>">
                                <button title="Enlever privilèges administrateur" class="btn btn-primary">
                                    <span class="glyphicon glyphicon-pawn"></span>
                                </button>
                            </a>
                            <%
                                }
                                else {

                            %>
                            <a href="/profil/switch/status?id=<%= a.getId()%>">
                                <button href="/plop" title="Donner privilèges administrateur" class="btn btn-primary">
                                    <span class="glyphicon glyphicon-tower"></span>
                                </button>
                            </a>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                <tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
