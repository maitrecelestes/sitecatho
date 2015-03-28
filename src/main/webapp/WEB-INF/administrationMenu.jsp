<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/administrationMenu.css"/>
	<title>Administration du menu</title>
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
				<h3>Tableau indiquant toutes les pages</h3>
						<table>
						<tr>
							<th>  ID de la page  </th>
							<th>  Nom de la page  </th>								
							<th>  Rang de la page  </th>
							<th>  Visibilité de la page  </th>
							<th>  Modifier la page  </th>
							<th>  Supprimer la page  </th>
						</tr>
						<c:forEach var="administrationMenu" items="${listeMenu}">
								<tr>
									<td id="idpage${administrationMenu.idpage}">${administrationMenu.idpage}</td>
									<td id="idnompage${administrationMenu.idpage}">${administrationMenu.nompage}</td>
									<td id="idrang${administrationMenu.idpage}">${administrationMenu.rang}</td>
									<td id="idvisibilite${administrationMenu.idpage}">${administrationMenu.visibilite}</td>
									<td class="casemodifier" id="modifierid${administrationMenu.idpage}"><img src="Images/pointdinterrogation_modifier.png"/></td>
									<td class="casesupprimer" id="supprimerid${administrationMenu.idpage}"><img src="Images/croix_supprimer.png"/></td>
								</tr>

						</c:forEach>
						</table>

						
						
						<button class="bouttonAjoutMenu" type="button">Pour ajouter une page</button>
						<button class="bouttonModifierMenu" type="button">Cacher panneau modification</button>
						
		
						<form class="classModificationMenu">
							<h3>Pour modifier un menu</h3>
							<table>
								<tr><td><label for="idPageModif">Id de la page : </label></td><td><label id="idpageModif"/></td></tr>
								<tr><td><label for="nompageModif">Nom de la page : </label></td><td><input type="text" id="nompageModif" value=""/></td></tr>
								<tr><td><label for="nompageprecedenteModif">Nom de la page precedente : </label></td>
								<td><select name="nompageprecedenteModif" id="nompageprecedenteModif">
									<option value="page_0">Accueil</option>
						       		<c:forEach var="administrationMenu" items="${listeMenu}">
										<option id="nompageprecedenteModif${administrationMenu.idpage}" value="${administrationMenu.idpage}" ${administrationMenu.idpage}>${administrationMenu.nompage}</option>
									</c:forEach>  
						       	</select></td></tr>
						 		<tr><td><label name="rang">Rang : </label></td><td>
								<input type="radio" name="rangModif" id="rang0Modif" /><label for="rang1">Primaire</label>
								<input type="radio" name="rangModif" id="rang1Modif" /><label for="rang2">Secondaire</label>
								</td></tr>
								<tr><td><label for="visibiliteModif">Visibilité :</label></td><td><input type="checkbox" onchange="if(this.checked) this.value='true'; else this.value='false';" id="visibiliteModif" /></td></tr>
								<tr><td colspan="2"><input id="bouttonPourModifierMenu" type="button" value="Modifier le menu" width="100px;"></td></tr>
									 
							</table>
						</form>

						
						
						
						

						<form class="classAjoutMenu">
							<h3>Pour rajouter un menu</h3>
							<table>
								<tr><td><label for="nompage">Nom de la nouvelle page : </label></td><td><input type="text" id="nompage" /></td></tr>
								<tr><td><label for="nompageprecedente">Nom de la page precedente : </label></td>
								 <td><select name="nompageprecedente" id="nompageprecedente">
								 	<option value="page_0">Accueil</option>
						       		<c:forEach var="administrationMenu" items="${listeMenu}">
										<option value="nompageprecedente${administrationMenu.idpage}" ${administrationMenu.idpage}>${administrationMenu.nompage}</option>
									</c:forEach>  
						       	</select></td></tr>
								
						 		<tr><td><label name="rang">Rang : </label></td><td>
								
								<input type="radio" name="rang" id="rang1"  checked/><label for="rang1">Primaire</label>
								<input type="radio" name="rang" id="rang2" /><label for="rang2">Secondaire</label>
								
								</td></tr>
						 
								<tr><td><label for="visibilite">Visibilité :</label></td><td><input type="checkbox" onchange="if(this.checked) this.value='true'; else this.value='false';" id="visibilite" /></td></tr>
								<tr><td colspan="2"><input id="bouttonPourAjouterMenu" type="button" value="Envoyer le message" width="100px;"></td></tr>
							</table>
						</form>

		  </div>
	 </section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Créé par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/administrationMenu.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>