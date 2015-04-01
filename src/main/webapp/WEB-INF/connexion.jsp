<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<title>Connexion</title>
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
		  <c:if test="${dejaConnecter =='vrai'}">
		  		<p>Vous �tes d�j� connect�</p>
		  		<a href="accueil">Retourner � l'accueil</a><br/>
		  		<a href="deconnexion">Se d�connecter</a>
		  
		  </c:if>
		  <c:if test="${dejaConnecter =='faux'}">
				<h1>Se connecter</h1>
				<form method="POST">
					<table>
					<c:if test="${testConnexion =='faux'}">
   							<tr><td colspan="2">Combinaison mail/mot de passe fausse</td></tr>
					</c:if>
						<tr><td><label for="mail">Mail :</label></td><td><input type="email" id="mail" name="mail" /></td></tr>
						<tr><td><label for="mdp">Mot de passe :</label></td><td><input type="password" id="mdp" name="mdp" /></td></tr>
						<tr><td colspan="2"><input id="seconnecter" type="submit" value="Se connecter" width="100px;"></td></tr>
					</table>
				</form>
		</c:if>
		  </div>
	 </section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Cr�� par Michel GUIGNIER et Romain SOENEN.
		</footer>
		

	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>