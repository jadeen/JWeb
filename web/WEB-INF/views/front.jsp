<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.jweb.beans.Opinion" %><%--
  Created by IntelliJ IDEA.
  User: Kevin Marrec
  Date: 12/14/2015
  Time: 1:09 PM
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
    <%@include file="nav.jsp" %>

    <div class="row">
        <div class="panel panel-default" style="margin-top: 50px">
            <div class="panel-body" style="padding-top: 0px">
                <div class="row">
                    <div class="col-md-2"><h1>Projet Ara</h1></div>
                    <div class="col-md-offset-8 col-md-1">
                        <a href="/product">
                            <button class="btn btn-default btn-ara-buy">Acheter Kit à 299 €</button>
                        </a>
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
                    Pour accompagner le lancement de leur toute nouvelle gamme de produit. Google a l'honneur d'annoncer la création de la toute première boutique Ara. Elle permettra à chaque client de venir
                    et de repartir en moins de 5 minute avec leur téléphone en kit fonctionnel. Nous nous somme associés avec tous les opérateurs du pays pour permettre la creation d'une toute nouvelle
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
                <h3 style="margin-top: 100px">Une sélection modulaire</h3>
                <p style="text-align: justify">
                    La force du projet Ara est de pouvoir personnaliser les composants de votre téléphone par un système de module.
                    Vous pourrez choisir en temps réel les modules de votre téléphone, depuis votre ordinateur. Vous pourrez aussi ajouter et supprimer des fonctionnalités pendant que vous l'utilisez.
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <h3 class="text-center">Diférrentes tailles d'appareils</h3>
            <p class="text-center">
                Vous pourrez choissir le socle de votre projet Ara en fonction de 3 tailles différentes. Chaque taile permettant un ajout limité de modules.
            </p>
            <img class="picture-center" src="<%=request.getContextPath()%>/resources/img/size-ara.jpg"/>
        </div>
    </div>
    <!-- caractéristique technique -->
    <div class="row ara-setting">
        <div class="container">
            <h3>Aperçu</h3>
            <p>Design 100% metal, matériaux de qualité garantissant une grande solidité des modules. Le tout fonctionnant avec la dernière version d'Android (Android 6.0 Marshmallow)</p>
            <div class="row">
                <div class="col-md-6">
                    <h3>Un module personnalisé</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisl ligula, consequat fringilla viverra id, suscipit sed
                        Integer a dui eget sapien aliquam tempor. Donec vitae lacinia quam. Donec et enim varius, lacinia lacus ac, aliquet massa.
                        Fusce vel tempor ante, molestie lobortis enim. Sed mattis mattis suscipit. Morbi porttitor dolor quis nibh commodo consequat.
                        Sed pretium id felis a aliquam. Vestibulum aliquet vitae velit ac tristique. In fermentum hendrerit urna, ut tristique orci tincidunt vitae.
                        Pellentesque nec rhoncus dui. Nam volutpat justo sed consequat euismod. Fusce fringilla erat ut elit molestie molestie.
                        Suspendisse consectetur elit quis arcu blandit cursus. Duis pellentesque viverra felis at feugiat.
                    </p>
                    <h3>Des performances équivalentes</h3>
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
                    <h3>Un grand choix de fonctionnalités</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisl ligula, consequat fringilla viverra id, suscipit sed
                        Integer a dui eget sapien aliquam tempor. Donec vitae lacinia quam. Donec et enim varius, lacinia lacus ac, aliquet massa.
                        Fusce vel tempor ante, molestie lobortis enim. Sed mattis mattis suscipit. Morbi porttitor dolor quis nibh commodo consequat.
                        Sed pretium id felis a aliquam. Vestibulum aliquet vitae velit ac tristique. In fermentum hendrerit urna, ut tristique orci tincidunt vitae.
                        Pellentesque nec rhoncus dui. Nam volutpat justo sed consequat euismod. Fusce fringilla erat ut elit molestie molestie.
                        Suspendisse consectetur elit quis arcu blandit cursus. Duis pellentesque viverra felis at feugiat.
                    </p>
                    <h3>Une stabilité à toute épreuve</h3>
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
            <h2>Recevoir nos Newsletters regulières !!</h2>
            <div class="input-group col-md-offset-1 col-md-10">
                <form class="form-inline" action="/product/newsletter" method="POST">
                    <div class="row">
                        <div class="col-md-10">
                            <input type="text" class="form-control" placeholder="Addresse Mail" aria-describedby="basic-addon2">
                        </div>
                        <div class="col-md-2">
                            <button class="btn" type="submit">Envoyer</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row ara-talk">
        <div class="container">
            <h2 class="text-center">Ils parlent de nous !</h2>
            <p class="text-center">
                <% Opinion res = (Opinion) request.getAttribute("opinion");
                    if (res == null){
                        out.println("Aucun avis pour le moment !");
                    }else {
                        out.println(res.getOpinion());
                    }
                %>
            </p>
            <h3 class="text-center">Faites de même !</h3>
            <div>

                <%
                    if (user.getConnect()){
                %>
                <form method="POST" action="/product/opinion">
                    <div class="form-group">
                        <label>Votre Avis !</label>
                        <textarea class="form-control" name="opinion">

                        </textarea>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Envoyer</button>
                    </div>
                </form>
                <%
                    }else{
                %>
                <h4>Identifiez-vous sur le site pour donner votre avis</h4>
                <% }%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
