<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	
	<link rel="stylesheet" type="text/css" href="css/contact.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-accueil.css"/>
	<!--<link rel="stylesheet" type="text/css" href="css/style-menu.css"/>-->
	<script type="text/javascript" src="js/menu.js"></script>
	<title>AdministrationMenu</title>
</head>
<body>
	<div id="blocktotal">
		<header>
			<!-- BANNIERE -->
			<img src="Images/banniere.png">
		</header>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
			<c:import url="menu.jsp">
		</c:import>
				<section id="gadgets">
					<!-- GADGET -->
					<table id="tablegadget">
						<tr>
							<td><p>Mercredi 10 DÃ©cembre 2014<br/>Sainte Romaric</p></td>
							<td><p><img id="diapo" src="Images/crechenoel.png" /></p></td>
							<td>
								<a href="https://www.facebook.com/AumonerieUniversiteCatholiqueDeLille?fref=ts"><img id="iconefacebook" src="Images/iconefacebook.png"/></a>
								<a href="https://twitter.com/auclille"><img id="iconetwitter" src="Images/iconetwitter.png"/></a><br/>
								<a href="http://www.univ-catholille.fr/index.asp"> <img id="logocatho" src="Images/logocatho.png"/></a>
								<a href="https://www.youtube.com/channel/UCc8J3Ztfts4Exaas2pDWUrA"> <img id="iconeyoutube" src="Images/iconeyoutube.png"/></a>
							</td>
							<td><a href="page-accueil-connection.html"><input type="button" value="Se connecter"/></a></td>
						</tr>
					</table>
				</section>
				<section id="articles"> 
					<!-- ARTICLES -->
					<article>
						<h3>Tableau indiquant toutes les pages</h3>
						<table>
						<tr>
							<th>  ID de la page  </th>
							<th>  Nom de la page  </th>								
							<th>  Rang de la page  </th>
							<th>  Visibilité de la page  </th>
							<th>  Modifier la page  </th>
						</tr>
						<c:forEach var="administrationMenu" items="${listeMenu}">
								<tr>
									<td>${administrationMenu.idpage}</td>
									<td>${administrationMenu.nompage}</td>
									<td>${administrationMenu.rang}</td>
									<td>${administrationMenu.visibilite}</td>
									<td><span id="page_${administrationMenu.idpage}"></span></td>
								</tr>

						</c:forEach>
						</table>
						
						
						<form>
							<h3>Pour rajouter un Menu</h3>
							<table>
								<tr><td><label for="nompage">Nom de la nouvelle page : </label></td><td><input type="text" id="nompage" /></td></tr>
								<tr><td><label for="nompageprecedente">Nom de la page precedente : </label></td>
								<td><input type="text" id="nompageprecedente" /></td></tr>
								<tr><td><label for="rang">Rang : </label></td><td><input type="text" id="rang" /></td></tr>
								<tr><td><label for="visibilite">Visibilité :</label></td><td><input type="checkbox" onchange="if(this.checked) this.value='true'; else this.value='false';" id="visibilite" /></td></tr>
								<tr><td colspan="2"><input id="ajouterMenu" type="button" value="Envoyer le message" width="100px;"></td></tr>
							</table>
						</form>
						
				<!-- 		<h3>Tableau indiquant toutes les pages de rang 0 et visible</h3>
						<table>
						<tr>
							<th>  ID de la page  </th>
							<th>  Nom de la page  </th>								
							<th>  Rang de la page  </th>
							<th>  Visibilité de la page  </th>
						</tr>
						<c:forEach var="administrationMenuRang0" items="${listeMenuRang0}">
								<tr>
									<td>${administrationMenuRang0.idpage}</td>
									<td>${administrationMenuRang0.nompage}</td>
									<td>${administrationMenuRang0.rang}</td>
									<td>${administrationMenuRang0.visibilite}</td>
								</tr>

						</c:forEach>
						</table>	
						
						<h3>Tableau indiquant toutes les pages de rang 1 et visible entre 1 et 3</h3>
						<table>
						<tr>
							<th>  ID de la page  </th>
							<th>  Nom de la page  </th>								
							<th>  Rang de la page  </th>
							<th>  Visibilité de la page  </th>
						</tr>
						<c:forEach var="listerMenuDeRang1Entre2Rang0" items="${listerMenuDeRang1Entre2Rang0}">
								<tr>
									<td>${listerMenuDeRang1Entre2Rang0.idpage}</td>
									<td>${listerMenuDeRang1Entre2Rang0.nompage}</td>
									<td>${listerMenuDeRang1Entre2Rang0.rang}</td>
									<td>${listerMenuDeRang1Entre2Rang0.visibilite}</td>
								</tr>

						</c:forEach>
						</table>		-->	
					</article>
				</section>
		</div>
		<footer>
			<!-- COPYRIGHT -->
			<p>CrÃ©Ã© par Michel GUIGNIER et Romain SOENEN.</p>
		</footer>
	</div>
	<script type="text/javascript" src="js/administrationMenu.js"></script>
</body>