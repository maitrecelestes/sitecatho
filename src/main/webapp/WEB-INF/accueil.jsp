<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<title>Accueil</title>
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
		  <div id="blocPhoto">
		 ${lienPhotoEntete.getLienPhoto()}
			<c:if test="${rangUtilisateur =='administrateur'}"><!-- Ajouter la page géré par le rédacteur -->
			 <form method="POST">
			Lien de l'image :<input type="text" name="newPhoto"/>
			<input type="submit" value="Changez la photo"/>
		</form>
		</c:if>
		  </div>
		  
		  <div id="blocArticle">
		  	<div id="blocArticle">
				<c:forEach var="listeArticleUnique" items="${listeArticleUnique}">
					  
					<div class='unArticleDeLaPage'>
							
						<article class='monArticleParticulier'>
							<!--<div class='cacherConnexion'>
								<c:if test="${rangUtilisateur =='administrateur'}">
									  <a href='modifierarticle?nompage=${urlPage}&idArticle=${listeArticle.getIdArticle()}'><button class='bouttonArticle bouttonModifierArticle' onclick='bouttonOuvrirModificationArticle(this)' id='modifierArticle${listeArticle.getIdArticle()}' type='button'>Modification</button></a>
									<button class='bouttonArticle bouttonVisibiliteArticle' onclick='visibleArticle(this)' id='visibiliteArticle${listeArticle.getIdArticle()}' type='button'>Visible</button>
									<button class='bouttonArticle bouttonSupprimerArticle' onclick='archiverArticle(this)' id='suppressionArticle${listeArticle.getIdArticle()}' type='button'>Suppression</button>
								</c:if>
							</div> -->
							<c:if test="${rangUtilisateur =='administrateur'}">
								 <a id="lienModifierArticleAccueil" class="bouttonAjoutArticle" href="modifierarticleunique?nompage=accueil"><button class='bouttonArticle bouttonModifierArticle' onclick='bouttonOuvrirModificationArticleUnique(this)' id='modifierArticleUniqueAccueil' type='button'>Modifier l'article</button></a>
							</c:if>
							
							<h3 class='titreArticle'>${listeArticleUnique.getTitre()}</h3>
							<h4 class='dateArticle'>${listeArticleUnique.getDateCreation()}</h4>
							<p class='contenuArticle'>${listeArticleUnique.getContenu()}</p>
							
						</article>	
					</div>
					
				</c:forEach>
				
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