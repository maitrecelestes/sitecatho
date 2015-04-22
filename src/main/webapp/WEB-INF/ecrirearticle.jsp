<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/ecrirearticle.css"/>
	<!-- Make sure the path to CKEditor is correct. -->
    <script src="ckeditor/ckeditor.js"></script>
	<title>Ecrire un article</title>	
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
	         <form method="POST">
	        	<label for="titre">Titre de l'article :</label><textarea name="titre" id="titre" rows="1" cols="200">titre </textarea>
	       		<textarea name="contenu" id="contenu" rows="10" cols="80">
	                Contenu de l'article
	            </textarea><br/>
	            <script>CKEDITOR.replace( 'contenu' );</script>
	            <label for="visibiliteArticle">Voulez vous que l'article soit visible pour tout le monde :</label>
	            <input type="radio" name="visibiliteArticle" value="oui" checked/>OUI
	            <input type="radio" name="visibiliteArticle" value="non"/>NON<br/>
	            <input type="submit" id="envoyerArticle" value="Publier l'article"/>
	        </form>
		</section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Créé par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/connexion.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>