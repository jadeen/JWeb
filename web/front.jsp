<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Kevin Marrec
  Date: 12/14/2015
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projat Ara By Epitech</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top bilboquet-navbar">
        <div class="container">
            <!--<a class="navbar-brand" href="#">Projet Ara</a>-->
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

    <div class="row">
        <div class="panel panel-default" style="margin-top: 50px">
            <div class="panel-body" style="padding-top: 0px">
                <div class="row">
                    <div class="col-md-2"><h1>Projet Ara</h1></div>
                    <div class="col-md-offset-8 col-md-1">
                        <button class="btn btn-default btn-ara-buy">Acheter Kit à 299 €</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row ara-intro">
        <div class="col-md-offset-1 col-md-10">
            <div class="container ara-first-picture">
                <h1 class="text-center">Projet Ara !</h1>
                <img src="<%=request.getContextPath()%>/resources/img/affiche.png"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div class="col-md-3">
                <img style="width: 240px" src="<%=request.getContextPath()%>/resources/img/shop-ara.jpg"/>
            </div>
            <div class="col-md-8">
                <h2 style="margin-top: 0px">Lancement de la première boutique Ara en Californie</h2>
                <p style="text-align: justify">
                    Pour accompagné le lancement de leur tout nouvelle game de produit. Google à l'honneur d'annoncer la création de la toute premier boutique Ara.Elle permettra a chaque client de venir
                    et de repartir en moins de 5 minute de leur téléphone en quitte fonctionnel. Nous nous somme associer avec tout les operateurs du pays pour permettre la creation d'une toute nouvelle
                    manière d'acheter un téléphone.
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div class="col-md-7 col-md-offset-1">
                <img style="width:600px" src="<%=request.getContextPath()%>/resources/img/block-ara.jpg"/>
            </div>
            <div class="col-md-4">
                <h3 style="margin-top: 100px">Une selection modulaire</h3>
                <p style="text-align: justify">
                    Avec le projet Ara, vous pourez choisir en temps réel les modules ajouté sur votre ordinateur. Vous pourez aussi ajouter et enlever des fonctionnalités pendant que vous l'utilisé.
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <h3 class="text-center">Diférrente taile de device</h3>
            <p class="text-center">
                Vous pourrez choissir le socle de votre projet Ara en fonction de 3 taile différente. Chaque taile permettant un ajout limité de module.
            </p>
            <img class="picture-center" src="<%=request.getContextPath()%>/resources/img/size-ara.jpg"/>
        </div>
    </div>
    <!-- caractéristique technique -->
    <div class="row ara-setting">
        <div class="container">
            <h3>Aperçu</h3>
            <p>Design 100% metal, materiaux de qualité garantice une grand solidité des modules. Le tout tournant sur la dernier monture android(Android 6.0 Marshmallow)</p>
            <div class="row">
                <div class="col-md-6">
                    <h3>Un module personalisé</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisl ligula, consequat fringilla viverra id, suscipit sed
                        Integer a dui eget sapien aliquam tempor. Donec vitae lacinia quam. Donec et enim varius, lacinia lacus ac, aliquet massa.
                        Fusce vel tempor ante, molestie lobortis enim. Sed mattis mattis suscipit. Morbi porttitor dolor quis nibh commodo consequat.
                        Sed pretium id felis a aliquam. Vestibulum aliquet vitae velit ac tristique. In fermentum hendrerit urna, ut tristique orci tincidunt vitae.
                        Pellentesque nec rhoncus dui. Nam volutpat justo sed consequat euismod. Fusce fringilla erat ut elit molestie molestie.
                        Suspendisse consectetur elit quis arcu blandit cursus. Duis pellentesque viverra felis at feugiat.
                    </p>
                    <h3>Des performance Equivalente</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisl ligula, consequat fringilla viverra id, suscipit sed
                        Integer a dui eget sapien aliquam tempor. Donec vitae lacinia quam. Donec et enim varius, lacinia lacus ac, aliquet massa.
                        Fusce vel tempor ante, molestie lobortis enim. Sed mattis mattis suscipit. Morbi porttitor dolor quis nibh commodo consequat.
                        Sed pretium id felis a aliquam. Vestibulum aliquet vitae velit ac tristique. In fermentum hendrerit urna, ut tristique orci tincidunt vitae.
                        Pellentesque nec rhoncus dui. Nam volutpat justo sed consequat euismod. Fusce fringilla erat ut elit molestie molestie.
                        Suspendisse consectetur elit quis arcu blandit cursus. Duis pellentesque viverra felis at feugiat.
                    </p>
                </div>
                <div class="col-md-6">
                    <h3>Un grand choix de fonctionnalité</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisl ligula, consequat fringilla viverra id, suscipit sed
                        Integer a dui eget sapien aliquam tempor. Donec vitae lacinia quam. Donec et enim varius, lacinia lacus ac, aliquet massa.
                        Fusce vel tempor ante, molestie lobortis enim. Sed mattis mattis suscipit. Morbi porttitor dolor quis nibh commodo consequat.
                        Sed pretium id felis a aliquam. Vestibulum aliquet vitae velit ac tristique. In fermentum hendrerit urna, ut tristique orci tincidunt vitae.
                        Pellentesque nec rhoncus dui. Nam volutpat justo sed consequat euismod. Fusce fringilla erat ut elit molestie molestie.
                        Suspendisse consectetur elit quis arcu blandit cursus. Duis pellentesque viverra felis at feugiat.
                    </p>
                    <h3>Une stabilité a tout epreuve</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisl ligula, consequat fringilla viverra id, suscipit sed
                        Integer a dui eget sapien aliquam tempor. Donec vitae lacinia quam. Donec et enim varius, lacinia lacus ac, aliquet massa.
                        Fusce vel tempor ante, molestie lobortis enim. Sed mattis mattis suscipit. Morbi porttitor dolor quis nibh commodo consequat.
                        Sed pretium id felis a aliquam. Vestibulum aliquet vitae velit ac tristique. In fermentum hendrerit urna, ut tristique orci tincidunt vitae.
                        Pellentesque nec rhoncus dui. Nam volutpat justo sed consequat euismod. Fusce fringilla erat ut elit molestie molestie.
                        Suspendisse consectetur elit quis arcu blandit cursus. Duis pellentesque viverra felis at feugiat.
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="row ara-newsletter">
        <div class="container">
            <h2>Recevoir nos Newsletter Regulière !!</h2>
            <div class="input-group col-md-offset-1 col-md-10">
                <form class="form-inline" action="/product/newsletter" method="POST">
                    <div class="form-group">
                        <label class="sr-only" for="exampleInputEmail3">Email address</label>
                        <input type="email" name="mail" class="form-control" id="exampleInputEmail3" placeholder="Email">
                    </div>
                    <button type="submit" class="btn btn-default">Sign in</button>
                </form>
            </div>
        </div>
    </div>

    <div class="row ara-talk">
        <div class="container">
            <h2 class="text-center">Il parle de nous !</h2>
            <p class="text-center">
                <% String res = (String) request.getAttribute("opinionText");
                    if (res == null){
                        out.println("Aucun avis pour le moment !");
                    }else {
                        out.println(res);
                    }
                %>
            </p>
            <h3 class="text-center">Faites de même !</h3>
            <div>

                <%
                    if (flag){
                %>
                <form method="POST" action="/product/opinion">
                    <div class="form-group">
                        <label>Votre Avis !</label>
                        <textarea class="form-control" name="opinion">

                        </textarea>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Envoyez</button>
                    </div>
                </form>
                <%
                    }else{
                %>
                <h4>Iddentifiez-vous sur le site pour donner votre avis</h4>
                <% }%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
