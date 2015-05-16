<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/monArticle.css"/>
	<title>Accueil</title>
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
			<div id="blocPhoto">
				${lienPhotoEntete.getLienPhoto()}
				<c:if test="${rangUtilisateur =='administrateur'}"><!-- Ajouter la page géré par le rédacteur -->
					<form method="POST">
						Lien de l'image :<input type="text" name="newPhoto"/>
						<input type="submit" value="Changez la photo"/>
						<p>
					Si vous ne savez pas comment ajouter une image à la galerie, nous
					vous invitons à suivre le tutorial en cliquant <a
						href="tutorialajoutimage">ici</a>
				</p>
					</form>
				</c:if>
			</div>
			  
			<div id="blocArticle">
				<div class='unArticleDeLaPage'>	
					<article class='monArticleParticulier'>
						<div class='cacherConnexion'>
							<c:if test="${rangUtilisateur =='administrateur'}">
								 <a id="lienModifierArticleAccueil"  href="modifierarticleunique?nompage=accueil"><button class='bouttonArticle bouttonModifierArticle' onclick='bouttonOuvrirModificationArticleUnique(this)' id='modifierArticleUniqueAccueil' type='button'>Modifier l'article</button></a>
							</c:if>
						</div>
						<h3 class='titreArticle'>${listeArticleUnique.getTitre()}</h3>
						<p class='contenuArticle'>${listeArticleUnique.getContenu()}</p>		
					</article>	
				</div>		
			  </div>
		 </section>
	</section>
					
	<c:import url="footer.jsp">
	</c:import>
		
	<script type="text/javascript" src="js/administrationMenu.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/articleUnique.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>