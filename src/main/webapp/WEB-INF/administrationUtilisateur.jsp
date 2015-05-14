<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/administrationboutton.css"/>
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
									<td id="mail${listeUtilisateur.getIdUtilisateur()}">${listeUtilisateur.getMail()}</td>
									<td>${listeUtilisateur.getNom()}</td>
									<td>${listeUtilisateur.getPrenom()}</td>
									<td id="rang${listeUtilisateur.getIdUtilisateur()}">${listeUtilisateur.getRang()}</td>
									<td id="pagegerer${listeUtilisateur.getIdUtilisateur()}">${listeUtilisateur.getPageGere()}</td>
									<td id="ecole${listeUtilisateur.getIdUtilisateur()}">${listeUtilisateur.getEcole()}</td>
									<td class= "caseModifierUtilisateur"><button class="bouttonAdm" onclick="montrerFormulaireModifierUtilisateur(${listeUtilisateur.getIdUtilisateur()})">Modifier</button></td>
									<td class="casesupprimer"><button class="bouttonAdm"  onclick="supprimerUtilisateur(${listeUtilisateur.getIdUtilisateur()})">Supprimer</button></td>
								</tr>
						</c:forEach>
						</table>
						<input type="button"  class="bouttonAdm" value="Creer un utilisateur" id="montrerFormCreationUtilisateur"/>
						<div id="ajoutUtilisateur">
							<h3>Creer un nouvel utilisateur</h3>
							<table>
								<tr><td><label for="newMail">Mail :</label></td><td><input type="email" id="newMail"/><br/></td><td>Sous la forme : --@--.--<br/></td></tr>
								<tr><td><label for="newNom">Nom :</label></td><td><input type="text" id="newNom"/><br/></td><td>(obligatoire)<br/></td></tr>
								<tr><td><label for="newPrenom">Prenom :</label></td><td><input type="text" id="newPrenom"/><br/></td><td>(obligatoire)<br/></td></tr>
								<tr><td><label for="newMdp">Mot de passe :</label></td><td><input type="password" id="newMdp"/><br/></td></td><td>(4 caractères minimum)<br/></td></tr>
								<tr><td><label for="newConfMdp"> Retapez le mot de passe :</label></td><td><input type="password" id="newConfMdp"/><br/></td></tr>
								<tr><td><label for="newRang">Rang :</label></td><td><select id="newRang"><option id="administrateur">administrateur</option><option id="redacteur" selected>redacteur</option></select><br/></td></tr>
								<tr><td><label for="newEcole">Ecole :</label></td><td><input type="text" id="newEcole"/><br/></td><td>(obligatoire)<br/></td></tr>
								<tr id="pageGeretr"><td><label for="pageGere">Page gérée :</label></td>
								<td><select name="pageGere" id="pageGere">
						       		<c:forEach var="pageGere" items="${listeMenu}">
										<option id="pageGere${pageGere.idpage}">${pageGere.nompage}</option>
									</c:forEach>  
						       	</select></td></tr>
								<tr><td colspan="2" id="caseajouterUtilisateur"><input type="button" class="bouttonAdm" value="Ajouter cet utilisateur"/></td></tr>
							</table>
						</div>	
						<div id="modifierUtilisateur">
							<h3>Modifier le rang d'un utilisateur</h3>
							<table>
								<tr><td><label for="modMail">Mail :</label></td><td id="modMail"></td></tr>
								<tr><td><label for="modRang">Rang :</label></td><td><select id="modRang"><option id="modAdministrateur">administrateur</option><option id="modRedacteur" selected>redacteur</option></select><br/></td></tr>
								<tr id="modpageGeretr"><td><label for="modPageGere">Page gérée :</label></td>
								<td><select name="modPageGere" id="modPageGere">
						       		<c:forEach var="modPageGere" items="${listeMenu}">
										<option id="modPageGere${modPageGere.idpage}">${modPageGere.nompage}</option>
									</c:forEach>  
						       	</select></td></tr>
								
								
								<tr><td><label for="modEcole">Ecole :</label></td><td><input type="text" id="modEcole"/><br/></td></tr>
								<tr><td colspan="2" id="casemodifierUtilisateur"><input type="button" class="bouttonAdm" value="Modifier cet utilisateur"/></td></tr>
							</table>
						</div>

		  </div>
	 </section>
	</section>
					
		<c:import url="footer.jsp">
		</c:import>
		
	<script type="text/javascript" src="js/administrationUtilisateur.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>