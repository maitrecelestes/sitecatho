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
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
		<c:import url="blocDeGauche.jsp">
		</c:import>
	 </section>

	 
	 <section id="blocDroitPrincipalPage"> <!--Partie droite de la page : articles-->		  
		  <div id="blocArticle">
				<h1>Connexion réussi !!!</h1>
				<a href="accueil">Revenir à l'accueil</a>
		  </div>
	 </section>
	</section>
					
		<c:import url="blocDeGauche.jsp">
		</c:import>
		
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>