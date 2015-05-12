<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/monArticle.css"/>
	<title id="titrePageClassique">Une page classique</title>
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
		</div>
		<c:if test="${rangUtilisateur =='administrateur' || (rangUtilisateur == 'redacteur' && pageGere == urlPage)}"><!-- Ajouter la page géré par le rédacteur -->
			 <a id="lienNouvelArticle" class="bouttonAjoutArticle" href="nouvelarticle?nompage=${urlPage}">Ecrire un nouvel article</a>
		</c:if>
		 
		  <div id="blocArticle">
				<c:forEach var="listeArticle" items="${listeArticle}">
					<c:if test="${listeArticle.getArchive()==false}"> 
						<c:if test="${listeArticle.getVisiblePage()==true || (rangUtilisateur =='administrateur' || (rangUtilisateur == 'redacteur' && pageGere == urlPage))}"> 
							<div class='unArticleDeLaPage'>
								<div class='cacherConnexion'>
								<c:if test="${rangUtilisateur =='administrateur' || (rangUtilisateur == 'redacteur' && pageGere == urlPage)}"><!-- Ajouter la page géré par le rédacteur -->
									 <a href='modifierarticle?nompage=${urlPage}&idArticle=${listeArticle.getIdArticle()}'><button class='bouttonArticle bouttonModifierArticle' onclick='bouttonOuvrirModificationArticle(this)' id='modifierArticle${listeArticle.getIdArticle()}' type='button'>Modification</button></a>
									<button class='bouttonArticle bouttonVisibiliteArticle' onclick='visibleArticle(this)' id='visibiliteArticle${listeArticle.getIdArticle()}' type='button'>Visible</button>
									<button class='bouttonArticle bouttonSupprimerArticle' onclick='archiverArticle(this)' id='suppressionArticle${listeArticle.getIdArticle()}' type='button'>Suppression</button>
								</c:if>
									
								</div>
				
								<article class='monArticleParticulier' id='monArticleParticulier${listeArticle.getIdArticle()}'>
									<h3 class='titreArticle'>${listeArticle.getTitre()}</h3>
									<h4 class='dateArticle'>${listeArticle.getDate()}</h4>
									<p class='contenuArticle'>${listeArticle.getContenu()}</p>
								</article>	
							</div>
						</c:if>
					</c:if>
				</c:forEach>
				
		  </div>		  
		  
		  
	 </section>
	</section>
					
		<c:import url="footer.jsp">
		</c:import>
		
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>