<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/style-accueil.css"/>
	<!--<link rel="stylesheet" type="text/css" href="css/style-menu.css"/>-->
	<script type="text/javascript" src="js/menu.js"></script>
	<title>Accueil</title>
</head>
<body>
	<div id="blocktotal">
		<header>
			<!-- BANNIERE -->
			<img src="Images/banniere.png">
		</header>
		<div id="blocCentral">
				<!-- MENU -->
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
			<c:import url="menu.jsp">
		</c:import>
				<section id="gadgets">
					<!-- GADGET -->
					<table id="tablegadget">
						<tr>
							<td><p>Mercredi 10 Décembre 2014<br/>Sainte Romaric</p></td>
							<td><p><img id="diapo" src="Images/crechenoel.png" /></p></td>
							<td>
								<a href="https://www.facebook.com/AumonerieUniversiteCatholiqueDeLille?fref=ts"><img id="iconefacebook" src="Images/iconefacebook.png"/></a>
								<a href="https://twitter.com/auclille"><img id="iconetwitter" src="Images/iconetwitter.png"/></a><br/>
								<a href="http://www.univ-catholille.fr/index.asp"> <img id="logocatho" src="Images/logocatho.png"/></a>
								<a href="https://www.youtube.com/channel/UCc8J3Ztfts4Exaas2pDWUrA"> <img id="iconeyoutube" src="Images/iconeyoutube.png"/></a>
							</td>
							<td><a href="page-accueil-connection.html"><input type="button" value="Se connecter"/></a></td>
						</tr>
					</table>
				</section>
				<section id="articles"> 
					<!-- ARTICLES -->
					<article>
						<h1 class="titreActicle">Réunion Antenne Ingé</h1>
						<img src="Images/logoAntenneInge.jpg"/><br/>
						<p class="paragrapheArticle">
							Nous vous donnons rendez-vous <b>le mardi 18 novembre à 20h</b> à l’aumônerie pour une nouvelle réunion de l'antenne Ingé.<br>
							Pour le dîner : <br>  - les garçons = un plat salé, <br>  - les filles = un plat sucré. <br>Merci d’apporter des boissons en plus de votre plat ;-)<br><br>
							RDV à <b>20h PRECISES</b> devant l’aumônerie de la Catho (2 Rue Norbert Segard).
						</p>
					</article>
					<article>
						<h1 class="titreActicle">Mercredi</h1>
						<img src="Images/afficheLApotre.jpg"/><br/>
						<p class="paragrapheArticle"></p>
					</article>
				</section>
		</div>
		<footer>
			<!-- COPYRIGHT -->
			<p>Créé par Michel GUIGNIER et Romain SOENEN.</p>
		</footer>
	</div>
</body>