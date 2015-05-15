<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/monArticle.css" />

<link href="css/menuDropdown.vertical.css" media="screen"
	rel="stylesheet" type="text/css" />
<link href="css/menuDefault.css" media="screen" rel="stylesheet"
	type="text/css" />

<section>

	<div id="blocLogo">
		<a href="accueil"><img id="imageLogo"
			src="Images/LogoAumonerie.png" /></a>
	</div>

	<div id="blocMenu">
		<div id="menu">
			<div>
				<ul class='dropdown dropdown-vertical'>
					<a href="accueil"><li>Accueil</li></a>
				</ul>
			</div>

			<div>
				<span id="monmenuchange"></span>
			</div>

			<div>
				<ul class='dropdown dropdown-vertical'>
					<a href="galerie"><li>Galerie</li></a>
					<a href="contact"><li>Contact</li></a>
					<li id="administration" class='dir'>Administration
						<ul>
							<a href="administrationContact"><li>Contact</li></a>
							<a href="administrationMenu"><li>Menu</li></a>
							<a href="administrationUtilisateur"><li>Utilisateur</li></a>
						</ul>
					</li>
					<a href="connexion"><li id="bouttonConnexion">Connexion</li></a>
					<a href="deconnexion"><li id="bouttonDeconnexion">Déconnexion</li></a>


				</ul>
			</div>
		</div>
	</div>

	<div id="blocLienInternet">
		<p>Suivez nous sur nos réseaux sociaux :</p>
		<table id=tableauLienInternet class="lienInternetcentre">
			<tr>
				<td><a
					href="https://www.facebook.com/AumonerieUniversiteCatholiqueDeLille?fref=ts"><img
						id="iconefacebook" src="Images/iconefacebook.png" /></a></td>
				<td><a href="https://twitter.com/auclille"><img
						id="iconetwitter" src="Images/iconetwitter.png" /></a><br /></td>
				<td><a href="http://www.univ-catholille.fr/index.asp"> <img
						id="logocatho" src="Images/logocatho.png" /></a></td>
			</tr>
		</table>

	</div>


	<div id="blocInformation">
		<div id="connexionNomPrenom"></div>
		<div>
			<article
				class='monArticleParticulier monArticleParticulierBlocGauche'>
				<c:if test="${rangUtilisateur =='administrateur'}">
					<a id="lienModifierArticleInformationBlocGauche"
						href="modifierarticleunique?nompage=informationBlocGauche"><button
							class='bouttonArticle bouttonArticleBlocDeGauche bouttonModifierArticle'
							onclick='bouttonOuvrirModificationArticleUnique(this)'
							id='modifierArticleUniqueInformationBlocGauche' type='button'>Modifier
							l'article</button></a>
				</c:if>
				<h3 id="articleBlocDeGaucheTitre" class='titreArticle'></h3>
				<p id="articleBlocDeGaucheContenu" class='contenuArticle'></p>
			</article>
		</div>
		<iframe id="carteMap"
			src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d1265.3311477444552!2d3.0470809999999995!3d50.633390000000006!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47c2d57923e8039f%3A0x256ba6df9160eeff!2s2+Rue+Norbert+Segard%2C+Universit%C3%A9+Catholique+de+Lille%2C+59800+Lille!5e0!3m2!1sfr!2sfr!4v1427560757737"></iframe>
	</div>






























</section>
