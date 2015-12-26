<%@ page import="com.jweb.beans.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Kevin Marrec
  Date: 12/16/2015
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projet Ara - Blog</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/blog.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>

<div class="container-fluid">
    <div class="container-fluid">
        <nav class="navbar navbar-default navbar-fixed-top bilboquet-navbar">
            <div class="container">
                <!--<a class="navbar-brand" href="#">Projet Ara</a>-->
                <a class="navbar-brand" href="/">Acceuil</a>
                <p class="navbar-text navbar-left">
                    <a href="/blog">Blog</a>
                </p>
                <%
                    Boolean flag = (Boolean) request.getAttribute("isConnect");
                    if (flag){
                %>
                <p class="navbar-text navbar-right">
                    Connectez en tant que
                    <a href="/profil" class="navbar-link">
                        <% String mytask = (String) request.getAttribute("name");
                            out.println("" + mytask);
                        %>
                    </a>
                </p>
                <%
                }else {
                %>
                <p class="navbar-text navbar-right"><a href="/profil" class="navbar-link">Se connectez/S'inscrire</a></p>
                <%
                    }
                %>
            </div>
        </nav>
    </div>
    <div class="row blog-articles">
        <div class="container">
            <div class="row blog-article">
                <div class="container">
                    <%
                        ArrayList<Article> list = (ArrayList<Article>)request.getAttribute("articles");

                        for (Iterator<Article> it = list.iterator(); it.hasNext();)
                        {
                            Article a = it.next();
                    %>
                    <div class="row blog-article">
                        <div class="container">
                            <div class="col-md-offset-3 col-md-6 test">
                                <p>Titre : <% out.println(a.getTitle()); %></p>
                                <p>Contenu : <% out.println(a.getContent()); %></p>
                                <p>Auteur : <% out.println(a.getAuthor()); %></p>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
