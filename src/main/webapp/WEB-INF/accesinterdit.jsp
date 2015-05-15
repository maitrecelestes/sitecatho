<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<title>Accès interdit</title>
</head>
<body>
	<header id="header">
	</header>
	
	<section id="blocPrincipalPage">
		<section id="blocGauchePrincipalPage"> <!--Partie gauche de la page : Menu + information-->
			<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
			<c:import url="blocDeGauche.jsp">
			</c:import>
		</section>
		<section id="blocDroitPrincipalPage"> <!--Partie droite de la page : articles-->		  
			<div id="blocArticle">
					<h1>Vous n'avez pas les droits nécéssaires pour ce connecter à cette page !!!</h1>
				<a href="accueil"><button class='bouttonArticle bouttonArticleBlocDeGauche' type='button'>Revenir à l'accueil</button></a>
			</div>
		</section>
	</section>	
		
	<c:import url="footer.jsp">
	</c:import>
		
	<script type="text/javascript" src="js/connexion.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>