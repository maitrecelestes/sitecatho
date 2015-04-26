<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<!--<link rel="stylesheet" type="text/css" href="css/administrationMenu.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-accueil.css"/>-->
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<title id="titrePageClassique">Un page classique</title>
</head>
<body>
	<header id="header">
			<!-- BANNIERE -->
			<!-- <img src="Images/banniere.png"> -->
	</header>
		
		
		
	<section id="blocPrincipalPage">
	
	 <section id="blocGauchePrincipalPage"> <!--Partie gauche de la page : Menu + information-->
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
		<c:import url="blocDeGauche.jsp">
		</c:import>
	 </section>

	 
	 <section id="blocDroitPrincipalPage"> <!--Partie droite de la page : articles-->
		  <div id="blocPhoto">
		  </div>
		  <a id="lienNouvelArticle" class="bouttonArticle" href="">Ecrire un nouvel article</a>
		  <div id="blocArticle">
				<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
				<c:import url="affichageArticle.jsp">
				</c:import>
		  </div>		  
		  
		  
	 </section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Créé par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/administrationMenu.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>