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
                Google a prévu trois tailles différentes d’endosquelette, avec des écrans entre 3 et 6 pouces. <br/>
                Chaque appareil pourra recevoir un nombre de modules différents,
                tandis que certains modules ne fonctionneront qu’avec le grand « endosquelette ».
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
               <div class="container">
                   <h3>Une personnalisation unique</h3>
                   <p>
                       A terme, le projet Ara doit permettre de choisir chaque module, son emplacement, ainsi que sa couleur et son design.
                       Cela offre une énorme souplesse tant en termes de personnalisation de la configuration que de coût.
                       Les éléments les plus élaborés coûteront le plus cher. Pour les utilisateurs ayant un budget défini,
                       le fait de pouvoir élaborer sa configuration et de choisir les fonctions prioritaires ou non,
                       permet de cibler les modules sur lesquels on veut investir et ceux où l’on veut économiser.
                       Par exemple, on peut vouloir un écran haute définition et n'avoir que faire de fonctions photo avancées.
                   </p>
               </div>
           </div>
            <div class="row">
                <div class="col-md-6">
                    <h3>Des performances équivalentes</h3>
                    <p>
                        En comparaison aux smartphones classiques, le ration qualité/prix reste équivalent,
                        mais avec un avantage énorme : celui de pouvoir choisir quels composants l'on veut mettre et
                        donc pouvoir consacrer une plus grande partie du budget à certaines fonctionnalités.
                    </p>
                </div>
                <div class="col-md-6">
                    <h3>Un smartphone celon votre humeur</h3>
                    <p>
                        Pour les plus grands adeptes de Ara, rien ne vous empêche de changer vos modules en cours de journée,
                        pour ainsi avoir une utilisation unique de votre smartphone.
                        En quelques secondes, vous pourrez remplacer votre appareil photo par plus de mémoire vive pour jouer à un jeu vidéo dans un plus grand confort !
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="row ara-newsletter">
        <div class="container">
            <h2>Recevoir nos Newsletters régulières !!</h2>
            <div class="input-group col-md-offset-1 col-md-10">
                <form class="form-inline" action="/product/newsletter" method="POST">
                    <div class="row">
                        <div class="col-md-10">
                            <input type="text" class="form-control" placeholder="Adresse Mail" aria-describedby="basic-addon2">
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
                <h4 class="text-center">Identifiez-vous sur le site pour donner votre avis</h4>
                <% }%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
