<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/pageClassique.css" />
<link rel="stylesheet" type="text/css" href="css/galerie.css" />
<title>Galerie</title>
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
			<h1 id="entete">${maCategorie.getNomCategorie()}</h1>
			ss
			<div id="blocArticle">
				<a href="galerie">Retourner à la galerie</a>
				<c:if test="${rangUtilisateur =='administrateur'}">
					<a href="ajouterimage?id=${maCategorie.getId()}">Ajouter des
						images</a>
					<br />
				</c:if>
				<%
					int i = 0;
					pageContext.setAttribute("i", new Integer(i));
				%>
				<table class="tableAffichageImage">
					<!--  <tr><td class="tdImageGalerie"><img src="Images/dj_sona_1.png"></td><td class="tdImageGalerie"><img src="Images/poney.png"></td><td class="tdImageGalerie"><img src="Images/photo-serieuse.png"></td></tr>-->
					<c:forEach var="listeImage" items="${listeImage}">
						<c:if test="${i%3 == 0}">
							<tr>
						</c:if>
						<td class="tdImageGalerie">${listeImage.getLienImage()}<br />
							<c:if test="${rangUtilisateur =='administrateur'}">
								<input type="button" class="supprimerImage"
									onclick="supprimerImage('id=${listeImage.getId()}','${maCategorie.getId()}')"
									value="supprimer cette image" />
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


				<a href="galerie">Retourner à la galerie</a>
			</div>
		</section>
	</section>

	<c:import url="footer.jsp">
	</c:import>

	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/galerie.js"></script>
</body>