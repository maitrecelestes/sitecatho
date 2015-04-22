<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/pageClassique.css"/>
	<link rel="stylesheet" type="text/css" href="css/administrationContact.css"/>
	<title>Administration des messages envoyé via contact</title>
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
				<h3>Liste des messages reçues via Contact</h3>
						<table id="tabListeContact">
						<tr>
							<th>  Nom  </th>
							<th>  Prenom  </th>								
							<th>  Mail  </th>
							<th>  Objet  </th>
							<th>  Date d'envoi </th>
							
						</tr>
						<c:forEach var="listeContact" items="${listeMessageContact}">
								<tr>
									<td id="test">${listeContact.getNom()}</td>
									<td>${listeContact.getPrenom()}</td>
									<td>${listeContact.getMail()}</td>
									<td>${listeContact.getObjet()}</td>
									<td>${listeContact.getDatePoste()} ${listeContact.getHeurePoste()}</td>
									<td class="caseVoirMessage" id="information${listeContact.getIdMessage()}"><img src="Images/FlecheBas.png"/></td>
									<td class="casesupprimer" id="supprimerid${listeContact.getIdMessage()}"><img src="Images/croix_supprimer.png"/></td>
								</tr>
								<tr class="cacher" id="contenu${listeContact.getIdMessage()}">
									<td colspan="7">${listeContact.getContenu()}</td>
								</tr>

						</c:forEach>
						</table>

		  </div>
	 </section>
	</section>
					
		<footer id="footer">
			<!-- COPYRIGHT -->
			Créé par Michel GUIGNIER et Romain SOENEN.
		</footer>
		
	<script type="text/javascript" src="js/administrationContact.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/listeArticle.js"></script>
</body>