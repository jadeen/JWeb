<%@ page import="com.jweb.models.UserModel" %>
<%@ page import="javax.swing.text.StyledEditorKit" %>
<%@ page import="com.jweb.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: mickael
  Date: 12/20/2015
  Time: 17:13 PM
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
        <nav class="navbar navbar-default navbar-fixed-top bilboquet-navbar">
            <div class="container">
                <!--<a class="navbar-brand" href="#">Projet Ara</a>-->
                <a class="navbar-brand" href="/">Acceuil</a>
                <p class="navbar-text navbar-left">
                    <a href="/blog">Blog</a>
                </p>
                <p class="navbar-text navbar-right">
                    Connectez en tant que
                    <a href="/profil" class="navbar-link">
                        <%
                            User user = (User) request.getAttribute("user");
                            out.println("" + user.getNom() + " "+ user.getPrenom()+"");
                        %>
                    </a>
                </p>
            </div>
        </nav>

        <p class="big-space"></p>

        <%
            Boolean flag = user.getConnect();
            if (flag){
        %>
        <div class="row">
            <div class="panel panel-default" style="margin-top: -10px">
                <div class="panel-body" style="padding-top: 0px">
                    <div class="row">
                        <div class="container" style="margin-top: 10px">
                            <a href="/blog/create" class="admin-link space-line">Cree un article</a>
                            <a href="/profil/admin" class="admin-link">Gérer les utilisateurs</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>

        <div class="row">
            <div class="container">
                <div class="col-md-offset-3 col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-body">

                            <h1 class="text-center">Vos Information</h1>
                            <p class="space text-center">
                                <Strong>Nom :</Strong>
                                <span class="well-sm well">
                                <%String _nom =  user.getNom();
                                    out.println(_nom);%>
                                </span>
                            </p>
                            <p class="space text-center">
                                <Strong>prenom :</Strong>
                                <span class="well-sm well">
                                <%String _prenom =  user.getPrenom();
                                    out.println(_prenom);%>
                                </span>
                            </p>
                            <p class="space text-center">
                                <Strong>Login :</Strong>
                                <span class="well-sm well">
                                <%String _login =  user.getLogin();
                                    out.println(_login);%>
                                </span>
                            </p>
                            <p class="space text-center">
                                <Strong>Addresse Mail :</Strong>
                                <span class="well-sm well">
                                <%String _mail =  user.getMail();
                                    out.println(_mail);%>
                                </span>
                            </p>

                            <p class="space text-center">
                                <Strong>Status :</Strong>
                                <%
                                    if (!flag){
                                %>
                                    <span class="label label-primary">Utilisateur</span>
                                <%
                                    }
                                    else {
                                %>
                                    <span class="label label-danger">Administrateur</span>
                                <% }%>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="container">
                <div class="text-center">
                    <div class="btn-group">
                        <button class="btn  btn-primary">
                            <a style="color: white" href="/profil/deconnect">Se déconnectez</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
