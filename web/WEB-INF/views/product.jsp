<%@ page import="com.jweb.beans.User" %><%--
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
    <%@include file="/WEB-INF/views/nav.jsp" %>

    <p class="big-space"></p>

    <div class="row">
        <div class="container">
            <div class="col-md-6">
                <img src="<%=request.getContextPath()%>/resources/img/pack-phone-ara.png"/>
            </div>
            <div class="col-md-6" style="margin-top: 20%;">
                <h1>Téléphone Ara: le pack à 299 €</h1>
                <h4>Le chassis et les blocs de composant</h4>
                <button class="btn btn-ara-buy center-block">Acheter</button>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="container">
            <h3>Paramètres De Base</h3>
            <div class="col-md-6">
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Couleur:</h5>
                        <p class="col-md-7">Marron</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Dimensions:</h5>
                        <p class="col-md-7">140 x 69 x 6,9 mm</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Poids:</h5>
                        <p class="col-md-7">138 g (4.86 oz</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Système d’exploitation:</h5>
                        <p class="col-md-7">Android 6.0(Marshmallow)</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">UC:</h5>
                        <p class="col-md-7">Processeur Qualcomm© Snapdragon™ 801 avec unité centrale 2,3 GHz Quad-core</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Processeur graphique:</h5>
                        <p class="col-md-7">Qualcomm® Adreno™ 330</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Mémoire vive:</h5>
                        <p class="col-md-7">LPDDR3 3 Go</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Stockage:</h5>
                        <p class="col-md-7">16 Go eMMC v5.0 </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Capteurs:</h5>
                        <p class="col-md-7">Accéléromètre, Gyroscope, Lumière de Proximité et d’Ambiance, HALL</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Batterie:</h5>
                        <p class="col-md-7">Batterie intégrée rechargeable 2 525 mAh LiPo</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">DAS maxi:</h5>
                        <p class="col-md-7">
                            FCC: Head-1.108 W/kg; Body-1.110 W/kg<br/>
                            CE: Head-0.317 W/kg; Body-0.420 W/kg<br/>
                            IN Regulations: Head-0.428 W/kg; Body 0.601 W/kg
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="container">
            <h3>Connectivité</h3>
            <div class="col-md-6">
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">North America:</h5>
                        <p class="col-md-7">
                            GSM: 850, 900, 1800, 1900MHz<br/>
                            WCDMA: Bands 1/2/4/5/8<br/>
                            FDD-LTE: Bands 1/2/4/5/7/8<br/>
                            CDMA EVDO: -<br/>
                        </p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">EU/India:</h5>
                        <p class="col-md-7">
                            GSM: 850, 900, 1800, 1900MHz<br/>
                            TDD-LTE: Bands 38/40<br/>
                            WCDMA: Bands 1/2/5/8<br/>
                            FDD-LTE: Bands 1/3/5/7/8/20<br/>
                            CDMA EVDO: -<br/>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Wi-Fi:</h5>
                        <p class="col-md-7">2,4 Ghz b/g/n WCN3680</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Bluetooth:</h5>
                        <p class="col-md-7">Bluetooth 4.0</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Localisation:</h5>
                        <p class="col-md-7">Supports GPS, GLONASS, et BDS</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="container">
            <div class="col-md-6">
                <h3>Audio</h3>
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Enceintes:</h5>
                        <p class="col-md-7">Enceinte sur la partie inférieure face</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Micros:</h5>
                        <p class="col-md-7">Double microphone avec annulation du bruit</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Radio FM:</h5>
                        <p class="col-md-7">Oui</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <h3>Ecran</h3>
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Taille:</h5>
                        <p class="col-md-7">5.0 inch Corning® Gorilla® Glass 3</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Résolution:</h5>
                        <p class="col-md-7">1080p Full HD, 441 ppp</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Type:</h5>
                        <p class="col-md-7">Active Matrix OLED</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="container">
            <div class="col-md-6">
                <h3>Ports, Fentes, Boutons Et Indicateurs</h3>
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">SIM:</h5>
                        <p class="col-md-7">1 carte Nano SIM et 1 carte MicroSD</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Ports:</h5>
                        <p class="col-md-7">Données et chargement : Micro-USB</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Audio :</h5>
                        <p class="col-md-7">jack 3,5 mm</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Boutons:</h5>
                        <p class="col-md-7">
                            Bouton Power<br/>
                            Boutons Volume<br/>
                            Slider d'alerte<br/>
                            Boutons capacitifs / sur écran
                        </p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Indicateurs:</h5>
                        <p class="col-md-7">1 lumière de notification LED (multicolore)</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <h3>Appareil photo</h3>
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Caméra arrière:</h5>
                        <p class="col-md-7">13 MP</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Ouverture:</h5>
                        <p class="col-md-7">f/2.2</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Caméra avant:</h5>
                        <p class="col-md-7">8 MP</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Ouverture:</h5>
                        <p class="col-md-7">f/2.4</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Vidéo:</h5>
                        <p class="col-md-7">Résolution vidéo 1080p</p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Ralentis :</h5>
                        <p class="col-md-7">720p vidéo à 120ips</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="container">
            <div class="col-md-6">
                <h3>Multimédia</h3>
                <div class="row">
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Formats Audio pris en Charge:</h5>
                        <p class="col-md-7">
                            Playback: MP3, AAC, AAC+, WMA (v9 and v10), AMR-NB, AMR-WB, WAV, FLAC, WAV, OGG<br/>
                            Recording: WAV AAC AMR EVRC QCELP
                        </p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Formats Vidéo pris en Charge:</h5>
                        <p class="col-md-7">
                            Playback: HEVC (H.265), H.264, MPEG-4, DivX, Xvid, MPEG-2, MP4, MOV, 3GP, AVI, MKV, ASF<br/>
                            Recording: AVC
                        </p>
                    </div>
                    <div class="container-fluid">
                        <h5 class="col-md-5" style="margin: 0px;">Formats d’Image Pris en Charge:</h5>
                        <p class="col-md-7">
                            Playback: JPEG, PNG, BMP, GIF<br/>
                            Output: JPEG
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <h3>Dans le pack</h3>
                <p>1x Télephone Ara Pack Edition</p>
                <p>1x Câble Micro-USB</p>
                <p>1x Chargeur</p>
                <p>1x Housse de protection</p>
                <p>1x Éjecteur de carte SIM</p>
                <p>1x Guide de démarrage rapide</p>
                <p>1x Guide utilisateur</p>
            </div>
        </div>
    </div>

</div>
</body>
</html>