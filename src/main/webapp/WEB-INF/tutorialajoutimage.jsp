<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/pageClassique.css" />
<link rel="stylesheet" type="text/css" href="css/galerie.css" />
<title>Tutorial : comment ajouter une image à la galerie</title>
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
			<h1 id="entete">Tutorial : Ajouter des images à galerie</h1>

			<div id="blocArticle">
				<p>Pour ajouter une ou plusieurs image(s), suivez les
					instructions ci-contre :</p>
				<ul id="tutorial">
					<li>Cliquez sur le lien <a href="http://www.casimages.com/">ici</a></li>
					<li>Cliquez sur SELECTIONNER UNE IMAGE <br /> <img
						class="imageTutoriel" src="Images/tutohebergementimage1.png" />
					</li>
					<li>Séléctionnez toutes les images que vous souhaitez mettre
						dans la galerie, puis cliquez sur Ouvrir.<br /> <img
						class="imageTutoriel" src="Images/tutohebergementimage2.png" /><br />
						Vous pouvez refaire cette opération autant de fois que vous le
						souhaitez ou vous pouvez directement séléctionner plusieurs images
						en gardant la touche CRTL appuyée quand vous séléctionnez vos
						images.
					</li>
					<li>Une fois toutes les images, cliquez sur Upload (vous
						pouvez vérifier que toutes vos images sont présentes en regardant
						la liste juste en dessous du bouton Upload)<br /> <img
						class="imageTutoriel" src="Images/tutohebergementimage3.png" />
					</li>

					<li>Copiez le lien de l'image (Prenez le lien HTML code comme
						indiqué ci dessous)<br /> <img class="imageTutoriel"
						src="Images/tutohebergementimage4.png" /><br /> Et collez là dans
						le champs adéquat
					</li>
					<li>Répétez l'étape précédente pour chaque photo a affiché.</li>
				</ul>
				<a href="ajouterimage">Revenir à la page pour ajouter des images</a>
			</div>
		</section>
	</section>
	<c:import url="footer.jsp">
	</c:import>

	<script type="text/javascript" src="js/administrationMenu.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>