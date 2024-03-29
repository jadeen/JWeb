<%--
  Created by IntelliJ IDEA.
  User: mickael
  Date: 12/19/2015
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription / Connexion</title>
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
                        <div class="col-md-6">
                            <h3 class="text-center">Connexion</h3>
                            <form method="post" name="connection" action="/profil/connect">
                                <div class="form-group" >
                                    <label for="exampleInputEmail1">Login</label>
                                    <input type="login" name="login" class="form-control" id="exampleInputEmail1" placeholder="Login">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Mot de passe</label>
                                    <input type="password" name="password" class="form-control" id="exampleInputEmail1" placeholder="Mot de passe">
                                </div>
                                <button type="submit" class="btn btn-default center-block">Connexion</button>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <h3 class="text-center">Inscription</h3>
                            <form method="post" name="inscription" action="/profil/inscription">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Login</label>
                                    <input type="text" name="login" class="form-control" id="exampleInputEmail1" placeholder="Login">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Adresse mail</label>
                                    <input type="email" name="mail" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>

                                <div class="form-inline">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Nom</label>
                                        <input type="text" name="nom" class="form-control" id="exampleInputEmail1" placeholder="Nom">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Prénom</label>
                                        <input type="text" name="prenom" class="form-control" id="exampleInputEmail1" placeholder="Prénom">
                                    </div>
                                </div>

                                <p class="space"></p>

                                <div class="form-inline">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Mot de passe</label>
                                        <input type="password" name="password" class="form-control" id="exampleInputEmail1" placeholder="Mot de passe">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password2" class="form-control" id="exampleInputEmail1" placeholder="Confirmation">
                                    </div>
                                </div>

                                <p class="space"></p>

                                <button type="submit" class="btn btn-default center-block">Inscription</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
