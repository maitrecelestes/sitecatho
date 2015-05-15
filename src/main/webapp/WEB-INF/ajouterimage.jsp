<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/pageClassique.css" />
<link rel="stylesheet" type="text/css" href="css/galerie.css" />
<title>Ajouter des images</title>
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


			<h1 id="entete">Ajouter des images à la galerie</h1>

			<div id="blocArticle">
				<p>
					Si vous ne savez pas comment ajouter une image à la galerie, nous
					vous invitons à suivre le tutorial en cliquant <a
						href="tutorialajoutimage">ici</a>
				</p>
				<form method="POST">
					<a href="http://www.casimages.com/">Héberger les images</a><br /> <input
						type="hidden" name="categorie" value="${idCategorie}" /> <input
						type="hidden" id="nombrelien" name="nombrelien" value="3" />
					<div id="mesinput">
						<label for="lien1">Lien pour l'image 1 :</label><input type="text"
							id="lien1" name="lien1" /><br /> <label for="lien2">Lien
							pour l'image 2 :</label><input type="text" id="lien2" name="lien2" /><br />
						<label for="lien3">Lien pour l'image 3 :</label><input type="text"
							id="lien3" name="lien3" /><br />
					</div>
					<input type="button" id="ajouterinput"
						value="Ajouter une autre image" /> <br /> <input type="submit"
						value="Enregistrez les images">
				</form>
			</div>
		</section>
	</section>
	<c:import url="footer.jsp">
	</c:import>

	<script type="text/javascript" src="js/administrationMenu.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/galerie.js"></script>
</body>