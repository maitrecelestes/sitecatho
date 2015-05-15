<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/pageClassique.css" />
<link rel="stylesheet" type="text/css" href="css/ecrirearticle.css" />


<!-- Make sure the path to CKEditor is correct. -->
<script src="ckeditor/ckeditor.js"></script>
<title>Modifier un article Unique</title>
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
			<form method="POST">
				<label for="titre" class="textCouleurBlanche">Titre de l'article :</label>
				<textarea name="titre" id="modifierArticleUniqueTitre" rows="1"
					cols="200">titre </textarea>
				<textarea name="contenu" id="modifierArticleUniqueContenu" rows="10"
					cols="80">
	                Contenu de l'article
	            </textarea>
				<br />
				<script>
					CKEDITOR.replace('contenu');
				</script>

				<input class="bouttonAjoutModificationArticle" type="submit" id="envoyerArticle"
					value="Enregistrer les modifications" />
			</form>
		</section>
	</section>

	<c:import url="footer.jsp">
	</c:import>

	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/modificationArticleUnique.js"></script>
</body>