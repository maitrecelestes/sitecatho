<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/pageClassique.css" />
<link rel="stylesheet" type="text/css" href="css/galerie.css" />
<link rel="stylesheet" type="text/css" href="css/administrationboutton.css"/>
<title>Galerie photo</title>

</head>
<body>
	<header id="header">
		<!-- BANNIERE -->
		<!-- <img src="Images/banniere.png"> -->
	</header>



	<section id="blocPrincipalPage">

		<section id="blocGauchePrincipalPage">
			<!--Partie gauche de la page : Menu + information-->
			<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<c:import url="blocDeGauche.jsp">
			</c:import>
		</section>


		<section id="blocDroitPrincipalPage">
			<!--Partie droite de la page : articles-->

			<h1 id="entete">Galerie</h1>
			<section id="listeCategorie">
				<c:if test="${rangUtilisateur =='administrateur'}">
					<input type="button" class="bouttonAdm" id="boutonAjoutCategorie"
						onclick="afficherAjoutCategorie()" value="Ajouter une cat�gorie" />
					
					<div id="ajoutCategorie">
						<form method="POST">
							<input type="text"  name="nomNouvelleCategorie" /> <input
								type="submit" class="bouttonAdm" value="enregistrer" />
						</form>
					</div>
				</c:if>
				<%
					int i = 0;
					pageContext.setAttribute("i", new Integer(i));
				%>
				<table class="tableAffichageImage">
					<c:forEach var="listeCategorie" items="${listeCategorie}"
						varStatus="status">
						<c:if test="${i%3 == 0}">
							<tr>
						</c:if>
						<td>${listePremiereImage[status.index].getLienImage()}<br />
							<c:if
								test="${listePremiereImage[status.index].getLienImage()==null}">CATEGORIE VIDE<br />
							</c:if> 
							${listeCategorie.getNomCategorie()}<br />
							<a href="categorieGalerie?idpage=${listeCategorie.getId()}"><input type="button" class="bouttonAdm" value="Voir la cath�gorie" /></a>
							<c:if test="${rangUtilisateur =='administrateur'}">
								<input type="button" class="bouttonAdm" class="supprimerCategorie"
									onclick="supprimerCategorie('id${listeCategorie.getId()}')"
									value="Supprimer cette categorie" />
							</c:if>
						</td>
						<c:if test="${i%3 == 2}">
							</tr>
						</c:if>
						<%
							i++;
								pageContext.setAttribute("i", new Integer(i));
						%>
					</c:forEach>
				</table>
			</section>
		</section>
	</section>

	<c:import url="footer.jsp">
	</c:import>


	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/galerie.js"></script>
</body>