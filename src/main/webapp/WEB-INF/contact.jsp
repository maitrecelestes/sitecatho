<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/contact.css"/>
	<title id>Contact</title>
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
		  
		  <div id="blocArticle">
				<h1>CONTACTEZ MOI</h1>
				<p>Vous pouvez poster ici un message à l'attention de l'aumonerie. Ce message sera lu par les responsables qui vous recontacterons au besoin.</p>
				<form>
					<table>
						<tr><td><label for="nom">Nom :</label></td><td><input type="text" id="nom" /></td></tr>
						<tr><td><label for="prenom">Prenom :</label></td><td><input type="text" id="prenom" /></td></tr>
						<tr><td><label for="mail">Mail :</label></td><td><input type="mail" id="mail" /></td></tr>
						<tr><td><label for="objet">Objet :</label></td><td><input type="text" id="objet" /></td><td><span id="facultatif">(facultatif)</span></td></tr>
						<tr><td><label for="contenu">Votre message :</label></td><td><textarea id="contenu"></textarea></td></tr>
						<tr><td colspan="2"><input id="envoyer" type="button" value="Envoyer le message" width="100px;"></td></tr>
					</table>
				</form>
		  </div>
	 </section>
	</section>
					
		<c:import url="footer.jsp">
		</c:import>
		
	<script type="text/javascript" src="js/contact.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>