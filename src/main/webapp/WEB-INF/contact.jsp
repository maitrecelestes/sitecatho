<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	
	<link rel="stylesheet" type="text/css" href="css/contact.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-accueil.css"/>
	<!--<link rel="stylesheet" type="text/css" href="css/style-menu.css"/>-->
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/contact.js"></script>
	<title>Contact</title>
</head>
<body>
	<div id="blocktotal">
		<header>
			<!-- BANNIERE -->
			<img src="Images/banniere.png">
		</header>
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
						<h1>CONTACTEZ MOI</h1>
						<p>Vous pouvez poster ici un message à l'attention de l'aumônerie. Ce message sera lu par les responsables qui vous recontacterons au besoin.</p>
						<form>
							<table>
								<tr><td><label for="Nometprenom">Nom :</label></td><td><input type="text" id="Nometprenom" /></td></tr>
								<tr><td><label for="prenom">Prenom :</label></td><td><input type="text" id="prenom" /></td></tr>
								<tr><td><label for="mail">Mail :</label></td><td><input type="mail" id="mail" /></td></tr>
								<tr><td><label for="objet">Objet :</label></td><td><input type="text" id="objet" /></td><td><span id="facultatif">(facultatif)</span></td></tr>
								<tr><td><label for="contenu">Votre message :</label></td><td><textarea id="contenu"></textarea></td></tr>
								<tr><td colspan="2"><input id="envoyer" type="button" onclick="popup()" value="Envoyer le message" width="100px;"></td></tr>
							</table>
						</form>						
					</article>
				</section>
		</div>
		<footer>
			<!-- COPYRIGHT -->
			<p>Créé par Michel GUIGNIER et Romain SOENEN.</p>
		</footer>
	</div>
</body>