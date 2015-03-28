<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<title>Connexion</title>
</head>
<body>
	<header id="header">
			<!-- BANNIERE -->
			<!-- <img src="Images/banniere.png"> -->
	</header>
		
		
		
	<section id="blocPrincipalPage">
	
	 <section id="blocGauchePrincipalPage"> <!--Partie gauche de la page : Menu + information-->
		  <div id="blocLogo">
			<img src="Images/LogoAumonerie.png">
		  </div>
	  
		  <div id="blocMenu">
			<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
				<c:import url="menu.jsp">
			</c:import>
		  </div>
	  
		  <div id="blocLienInternet">
			  <table id=tableauLienInternet> 
			  <tr> 
				 <td> <a href="https://www.facebook.com/AumonerieUniversiteCatholiqueDeLille?fref=ts"><img id="iconefacebook" src="Images/iconefacebook.png"/></a> </td> 
				 <td> <a href="https://twitter.com/auclille"><img id="iconetwitter" src="Images/iconetwitter.png"/></a><br/> </td> 
				 <td> <a href="https://www.youtube.com/channel/UCc8J3Ztfts4Exaas2pDWUrA"> <img id="iconeyoutube" src="Images/iconeyoutube.png"/></a> </td> 
				 <td> <a href="http://www.univ-catholille.fr/index.asp"> <img id="logocatho" src="Images/logocatho.png"/></a> </td> 
			  </tr> 
			  </table>
		  </div>
	  
		  <div id="blocInformation">
			mes informations
		  </div>
	  
	 </section>

	 
	 <section id="blocDroitPrincipalPage"> <!--Partie droite de la page : articles--> 
		  <div id="blocArticle">
				<h1>Se connecter</h1>
				<form>
					<table>
						<tr><td><label for="mail">Mail :</label></td><td><input type="email" id="mail" /></td></tr>
						<tr><td><label for="mdp">Mot de passe :</label></td><td><input type="password" id="mdp" /></td></tr>
						<tr><td colspan="2"><input id="seconnecter" type="button" value="Se connecter" width="100px;"></td></tr>
					</table>
				</form>
		  </div>
	 </section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Créé par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/connexion.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>