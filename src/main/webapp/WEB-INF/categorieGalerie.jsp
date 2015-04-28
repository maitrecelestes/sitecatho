<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<title>Galerie</title>
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
		  <h1>${maCategorie.getNomCategorie()}</h1>
		  <div id="blocArticle">
				<c:forEach var="listeImage" items="${listeImage}">
					${listeImage.getLienImage()}<br/>
					<c:if test="${rangUtilisateur =='administrateur'}">
				<form method="POST">
					<input type="hidden" name="supprimerImage" value="${listeImage.getId()}"/>
					<input type="submit" value="supprimer cette image"/>
				</form>
			</c:if>				
				</c:forEach>
				<c:if test="${rangUtilisateur =='administrateur'}">
		  			<a href="ajouterimage?id=${maCategorie.getId()}">Ajouter des images</a><br/>
		  		</c:if>
				
				<a href="galerie">Retourner à la galerie</a>
		  </div>
	 </section>
	</section>
					
		<c:import url="footer.jsp">
		</c:import>
		
	<script type="text/javascript" src="js/connexion.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>