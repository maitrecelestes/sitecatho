<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/ecrirearticle.css"/>
	<title>Ecrire un article</title>	
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
		  <h1>Ecrire un article</h1>
			<form>
				<table>
					<tr><td><label for="titre">Titre :</label></td><td><input type="text" id="titre" /></td></tr>
					<tr><td></td><td id='boutonedition'>
						<input type="button" class="petitbouton" value="I" onclick="insertTag('<i>', '</i>', 'textarea')" /> 
						<input type="button" class="petitbouton" value="S" onclick="insertTag('<u>', '</u>', 'textarea')" />
						<input type="button" class="petitbouton" value="G" onclick="insertTag('<b>', '</b>', 'textarea')" />
						<input type="button" class="boutont10" value="Saut de ligne" onclick="insertTag('','<br/>','textarea')" />
						<input type="button" class="boutont4" value="Lien" onclick="insertTag('', '', 'textarea', 'lien')" />
						<input type="button" class="boutont4" value="Image" onclick="insertTag('&lt;image&gt;', '&lt;/image&gt;', 'textarea')" />
						<input type="button" class="boutont8" value="Citation" onclick="insertTag('', '', 'textarea', 'citation')" />
					</td></tr>
					<tr><td><label for="contenu">Votre article :</label></td><td><textarea id="contenu"></textarea></td></tr>
					<tr><td><label for="pageassocie">Page o√π poster cet article :</label>
					</td><td> 
					<select name="pageassocie">
						<option value="value1">Antenne ing√©nieur</option> 
							<option value="value2" selected>Antenne droit</option>
							<option value="value3">Antenne commerce</option>
							<option value="value4">Le bureau</option>
						</select>
					</td></tr><tr><td>
								<label for="visibleaccueil">Visible dans l'accueil :</label></td><td>
								<input type="radio" name="visibleaccueil" value="Oui" checked /><span>Oui</span>
								<input type="radio" name="visibleaccueil" value="Non"/> <span>Non</span>
						</td></tr>
					<tr><td colspan="2"><input id="envoyer" type="button" onclick="popup()" value="Poster l'article" width="100px;"></td></tr>
				</table>
			</form>
		</section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			CrÈÈ par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/connexion.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>