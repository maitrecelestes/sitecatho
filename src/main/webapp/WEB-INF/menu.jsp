<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu">
	
	<c:forEach var="menu" items="${listeMenu}">
		3
		${menu.nompage}
		4
	</c:forEach>
	
	
	
	<!-- <li class="${param.pageSelectionnee == 'accueil' ? 'active' : ''}"><a href="accueil">Accueil</a></li>
				<li class="${param.pageSelectionnee == 'film' ? 'active' : ''}"><a href="listefilms">Liste des films</a></li>
				<li class="${param.pageSelectionnee == 'ajouter' ? 'active' : ''}"><a href="ajouterfilm">Ajouter un film</a></li>
				<li class="${param.pageSelectionnee == 'genre' ? 'active' : ''}"><a href="listegenres">Liste des genres</a></li>
	
	 -->
	
				<ul>
					<li class="lienMenu"><a href="accueil">Accueil</a></li>

					<li class="lienMenu pucePrincipales" id="liAumonerie"><a onclick="Aumonerie()">L'aumÃ´nerie</a></li>
					<ul id="lienAumonerie" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="accueil">Le bureau de Romain</a></li>
						<li class="lienMenu"><a href="accueil">Qui vient ?</a></li>
						<li class="lienMenu"><a href="accueil">C'est où  ma maison ?</a></li>
						<li class="lienMenu"><a href="accueil">Lien WEB</a></li>
					</ul>
					<li class="lienMenu pucePrincipales" id="liAnnonce" ><a onclick="Annonces()">Annonces</a></li>
					<ul id="lienAnnonce" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="accueil">En gÃ©nÃ©ral</a></li>
						<li class="lienMenu"><a href="accueil">La semaine prochaine</a></li>
						<li class="lienMenu"><a href="accueil">Dans le mois de l'année</a></li>
						<li class="lienMenu"><a href="accueil">Au delÃ  de l'aumÃ´nerie</a></li>
					</ul>
					<li class="lienMenu pucePrincipales" id="liActivite"><a onclick="Activites()">Les activites</a></li>
					<ul id="lienActivite" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="accueil">L'emploi du temps de la semaine</a></li>
						<li class="lienMenu"><a href="accueil">Les Mercredis</a></li>
						<li class="lienMenu"><a href="accueil">Le Ch'ti repas</a></li>
						<li class="lienMenu"><a href="accueil">Tout les midis</a></li>
						<li class="lienMenu"><a href="accueil">Prier dans la semaine</a></li>
						<li class="lienMenu"><a href="accueil">Atelier biblique</a></li>
						<li class="lienMenu"><a href="accueil">Les grands Ã©venements</a></li>
						<li class="lienMenu"><a href="accueil">Chorale</a></li>
					</ul>
					<li class="lienMenu pucePrincipales" id="liAntenne"><a onclick="Antennes()">Les antennes</a></li>	
					<ul id="lienAntenne" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="accueil">IngÃ©nieur</a></li>
						<li class="lienMenu"><a href="accueil">Commerce</a></li>
						<li class="lienMenu"><a href="accueil">SantÃ©</a></li>
						<li class="lienMenu"><a href="accueil">Droit</a></li>
						<li class="lienMenu"><a href="accueil">ICAM</a></li>
					</ul>
					<li class="lienMenu"><a href="accueil">Galerie</a></li>
					<li class="lienMenu"><a href="page-contact.html">Contact</a></li>
				</ul>
			</nav>