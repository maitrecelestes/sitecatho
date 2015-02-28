<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	
	<link rel="stylesheet" type="text/css" href="css/administrationContact.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-accueil.css"/>
	<!--<link rel="stylesheet" type="text/css" href="css/style-menu.css"/>-->
	<script type="text/javascript" src="js/menu.js"></script>
	<title>Administration des messages envoyé via contact</title>
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
						<h3>Liste des messages envoyés</h3>
						<table id="tabListeContact">
						<tr>
							<th>  Mail  </th>
							<th>  Nom  </th>								
							<th>  Prenom </th>
							<th>  Date de naissance  </th>
							<th>  Rang </th>
							<th>  Ecole </th>
							
						</tr>
						<c:forEach var="listeUtilisateur" items="${listeMessageUtilisateur}">
								<tr>
									<td>${listeUtilisateur.getMail()}</td>
									<td>${listeUtilisateur.getNom()}</td>
									<td>${listeUtilisateur.getPrenom()}</td>
									<td>${listeUtilisateur.getDateDeNaissance()}</td>
									<td>${listeUtilisateur.getRang()}</td>
									<td>${listeUtilisateur.getEcole()}</td>
									<td class="caseVoirMessage"><img src="Images/FlecheBas.png"/></td>
									<td class="casesupprimer"><img src="Images/croix_supprimer.png"/></td>
								</tr>
						</c:forEach>
								<tr>
									<td><input type="email" id="newMail"/></td>
									<td><input type="text" id="newNom"/></td>
									<td><input type="text" id="newPrenom"/></td>
									<td><input type="date" id="newDateNaissance"/></td>
									<td><input type="text" id="newRang"/></td>
									<td><input type="text" id="newEcole"/></td>
									<td colspan="2" id="caseajouterUtilisateur"><b><strong>+</strong></b></td>
								</tr>
							
						</table>
				</section>
		</div>
		<footer>
			<!-- COPYRIGHT -->
			<p>CrÃ©Ã© par Michel GUIGNIER et Romain SOENEN.</p>
		</footer>
	</div>
	<script type="text/javascript" src="js/administrationUtilisateur.js"></script>
</body>