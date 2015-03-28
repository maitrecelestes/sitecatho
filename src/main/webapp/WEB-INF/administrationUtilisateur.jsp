<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/administrationUtilisateur.css"/>
	<title>Administration des utilisateurs</title>	
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
				<h3>Liste des utilisateurs</h3>
						<table id="tabListeUtilisateur">
						<tr>
							<th>  Mail  </th>
							<th>  Nom  </th>								
							<th>  Prenom </th>
							<th>  Rang </th>
							<th>  Page gérée </th>
							<th>  Ecole </th>
							
						</tr>
						<c:forEach var="listeUtilisateur" items="${listeMessageUtilisateur}">
								<tr>
									<td>${listeUtilisateur.getMail()}</td>
									<td>${listeUtilisateur.getNom()}</td>
									<td>${listeUtilisateur.getPrenom()}</td>
									<td>${listeUtilisateur.getRang()}</td>
									<td>${listeUtilisateur.getPageGere()}</td>
									<td>${listeUtilisateur.getEcole()}</td>
									<td class= "caseModifierUtilisateur" id="caseModifierUtilisateur${listeUtilisateur.getMail()}"><img src="Images/FlecheBas.png"/></td>
									<td class="casesupprimer" id="${listeUtilisateur.getMail()}"><img src="Images/croix_supprimer.png"/></td>
								</tr>
						</c:forEach>
						</table>
						<input type="button" value="Creer un utilisateur" id="montrerFormCreationUtilisateur"/>
						<div id="ajoutUtilisateur">
							<h3>Creer un nouvel utilisateur</h3>
							<table>
								<tr><td><label for="newMail">Mail :</label></td><td><input type="email" id="newMail"/><br/></td></tr>
								<tr><td><label for="newPrenom">Prenom :</label></td><td><input type="text" id="newPrenom"/><br/></td></tr>
								<tr><td><label for="newNom">Nom :</label></td><td><input type="text" id="newNom"/><br/></td></tr>
								<tr><td><label for="newMdp">Mot de passe :</label></td><td><input type="password" id="newMdp"/><br/></td></tr>
								<tr><td><label for="newConfMdp"> Retapez le mot de passe :</label></td><td><input type="password" id="newConfMdp"/><br/></td></tr>
								<tr><td><label for="newRang">Rang :</label></td><td><select id="newRang"><option id="administrateur">administrateur</option><option id="redacteur" selected>redacteur</option></select><br/></td></tr>
								<tr><td><label for="newEcole">Ecole :</label></td><td><input type="text" id="newEcole"/><br/></td></tr>
								<tr id="pageGeretr"><td><label for="pageGere">Page gérée :</label></td><td><input type="text" id="pageGere"/><br/></td></tr>
								<tr><td colspan="2" id="caseajouterUtilisateur"><input type="button" value="ajouter cet Utilisateur"/></td></tr>
							</table>
						</div>	
						<div id="modifierUtilisateur">
							<h3>Modifier le rang d'un utilisateur</h3>
							<table>
								<tr><td><label for="modMail">Mail :</label></td><td><input type="email" id="modMail"/><br/></td></tr>
								<tr><td><label for="modRang">Rang :</label></td><td><select id="modRang"><option id="administrateur">administrateur</option><option id="redacteur" selected>redacteur</option></select><br/></td></tr>
								<tr id="modpageGeretr"><td><label for="modPageGere">Page gérée :</label></td><td><input type="text" id="modPageGere"/><br/></td></tr>
								<tr><td><label for="modEcole">Ecole :</label></td><td><input type="text" id="modEcole"/><br/></td></tr>
								<tr><td colspan="2" id="casemodifierUtilisateur"><input type="button" value="modifier cet Utilisateur"/></td></tr>
							</table>
						</div>

		  </div>
	 </section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Créé par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/administrationUtilisateur.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>