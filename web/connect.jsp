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
    <title>Inscription / Connection</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
    <div class="container-fluid">
        <nav class="navbar navbar-default navbar-fixed-top bilboquet-navbar">
            <div class="container">
                <!--<a class="navbar-brand" href="#">Projet Ara</a>-->
                <p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
            </div>
        </nav>

        <p class="big-space"></p>

        <div class="row">
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="col-md-6">
                            <h3 class="text-center">Connection</h3>
                            <form method="post" name="connection" action="/connect?type=connect">
                                <div class="form-group" >
                                    <label for="exampleInputEmail1">Login/Mail</label>
                                    <input type="login" name="login" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Mots de passe</label>
                                    <input type="password" name="password" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>
                                <button type="submit" class="btn btn-default center-block">Connection</button>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <h3 class="text-center">Inscription</h3>
                            <form method="post" name="inscription" action="/connect?type=inscription">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Login</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Adresse mail</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>

                                <div class="form-inline">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Nom</label>
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Prénom</label>
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                </div>

                                <p class="space"></p>

                                <div class="form-inline">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Mot de passe</label>
                                        <input type="password" name="password" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password2" class="form-control" id="exampleInputEmail1" placeholder="Email">
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
