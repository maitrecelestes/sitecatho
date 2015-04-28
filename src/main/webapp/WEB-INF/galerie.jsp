<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/galerie.css"/>
	<title>Galerie photo</title>

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
	
		<h1>Galerie</h1>
		<c:if test="${rangUtilisateur =='administrateur'}">
		  	<input type="button" id="boutonAjoutCategorie" value="Ajouter une catégorie"/><br/>
			<div id="ajoutCategorie">
				<form method="POST">
					<input type="text" name="nomNouvelleCategorie"/>
					<input type="submit" value="enregistrer"/>
				</form>
			</div>
		 </c:if>
		
		
		<c:forEach var="listeCategorie" items="${listeCategorie}">
			<a href="categorieGalerie?idpage=${listeCategorie.getId()}">${listeCategorie.getNomCategorie()}</a><br/>
			<c:if test="${rangUtilisateur =='administrateur'}">
				<input type="button" class="supprimerCategorie" id="id${listeCategorie.getId()}" value="supprimer cette categorie"/>
			</c:if>	
		</c:forEach>
	 </section>
	</section>			

		<c:import url="footer.jsp">
		</c:import>
		

	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/galerie.js"></script>
</body>