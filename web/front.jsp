<%--
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
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/ressources/css/style.css" />
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top bilboquet-navbar">
        <div class="container">
            <a class="navbar-brand" href="#">Projet Ara</a>
            <p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
        </div>
    </nav>
    <div class="row ara-intro">
        <div class="col-md-offset-1 col-md-10">
            <div class="container ara-first-picture">
                <h1 class="text-center">Projet Ara !</h1>
                <img src="<%=request.getContextPath()%>/ressources/img/affiche.png"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div class="col-md-3">
                <img style="width: 240px" src="<%=request.getContextPath()%>/ressources/img/shop-ara.jpg"/>
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
                <img style="width:600px" src="<%=request.getContextPath()%>/ressources/img/block-ara.jpg"/>
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
            <img class="picture-center" src="<%=request.getContextPath()%>/ressources/img/size-ara.jpg"/>
        </div>
    </div>
<p><% String mytask = (String) request.getAttribute("mytask");
    out.println("mytask = " + mytask);%></p>
</div>
</body>
</html>
