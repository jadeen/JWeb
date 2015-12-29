<%--
  Created by IntelliJ IDEA.
  User: mickael
  Date: 12/21/2015
  Time: 17:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projet Ara - Ajouter un article</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
    <div class="container-fluid">
        <%@include file="/WEB-INF/views/nav.jsp" %>
        <p class="big-space"></p>
        <div class="row">
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h1 class="text-center">Ajouter un article</h1>
                        <form name="/blog/create" method="post">
                            <div class="form-group">
                                <label>Titre</label>
                                <input type="text" name="titre" class="well form-control" id="exampleInputEmail1" placeholder="Titre">
                            </div>
                            <label>Contenu</label>
                            <textarea  placeholder="Contenu de votre atricle" name="content" class="well form-control" rows="3"></textarea>
                            <p class="space"></p>
                            <button type="submit" class="center-block btn btn-default">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
