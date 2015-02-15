<!DOCTYPE html>
<head>
	<meta charset="utf-8"/>
	<script type="text/javascript" src="js/jquery.js"  charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/style-accueil.css"/>
	<link rel="stylesheet" type="text/css" href="css/ecrirearticle.css"/>
	<!--<link rel="stylesheet" type="text/css" href="css/style-menu.css"/>-->
	<script type="text/javascript" src="js/menu.js"></script>
	<title>Ecrire un article</title>
</head>
<body>
	<div id="blocktotal">
		<header>
			<!-- BANNIERE -->
			<img src="Images/banniere.png">
		</header>
		<div id="blocCentral">
			<nav id="menu">
				<ul>
					<li class="lienMenu"><a href="page-accueil.html">Accueil</a></li>

					<li class="lienMenu pucePrincipales" id="liAumonerie"><a onclick="Aumonerie()">L'aumônerie</a></li>
					<ul id="lienAumonerie" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="">Le bureau</a></li>
						<li class="lienMenu"><a href="">Qui vient ?</a></li>
						<li class="lienMenu"><a href="">C'est où ?</a></li>
						<li class="lienMenu"><a href="">Lien WEB</a></li>
					</ul>
					<li class="lienMenu pucePrincipales" id="liAnnonce" ><a onclick="Annonces()">Annonces</a></li>
					<ul id="lienAnnonce" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="">En général</a></li>
						<li class="lienMenu"><a href="">La semaine</a></li>
						<li class="lienMenu"><a href="">Dans le mois</a></li>
						<li class="lienMenu"><a href="">Au delà de l'aumônerie</a></li>
					</ul>
					<li class="lienMenu pucePrincipales" id="liActivite"><a onclick="Activites()">Les activites</a></li>
					<ul id="lienActivite" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="">L'emploi du temps de la semaine</a></li>
						<li class="lienMenu"><a href="">Les Mercredis</a></li>
						<li class="lienMenu"><a href="">Le Ch'ti repas</a></li>
						<li class="lienMenu"><a href="">Tout les midis</a></li>
						<li class="lienMenu"><a href="">Prier dans la semaine</a></li>
						<li class="lienMenu"><a href="">Atelier biblique</a></li>
						<li class="lienMenu"><a href="">Les grands évenements</a></li>
						<li class="lienMenu"><a href="">Chorale</a></li>
					</ul>
					<li class="lienMenu pucePrincipales" id="liAntenne"><a onclick="Antennes()">Les antennes</a></li>	
					<ul id="lienAntenne" class="blocLienMenu puceSecondaires">
						<li class="lienMenu"><a href="">Ingénieur</a></li>
						<li class="lienMenu"><a href="">Commerce</a></li>
						<li class="lienMenu"><a href="">Santé</a></li>
						<li class="lienMenu"><a href="">Droit</a></li>
						<li class="lienMenu"><a href="">ICAM</a></li>
					</ul>
					<li class="lienMenu"><a href="">Galerie</a></li>
					<li class="lienMenu"><a href="">Contact</a></li>
				</ul>
			</nav>
			<section id="gadgets">
					<!-- GADGET -->
					<table id="tablegadget">
						<tr>
							<td><p>Mercredi 10 Décembre 2014<br/>Sainte Romaric</p></td>
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
					<h1>Ecrire un article</h1>
				</article>
				<form>
					<table>
						<tr><td><label for="titre">Titre :</label></td><td><input type="text" id="titre" /></td></tr>
						<tr><td></td><td id='boutonedition'>
							<input type="button" class="petitbouton" value="I" onclick="insertTag('<i>', '</i>', 'textarea')" /> 
							<input type="button" class="petitbouton" value="S" onclick="insertTag('<u>', '</u>', 'textarea')" />
							<input type="button" class="petitbouton" value="G" onclick="insertTag('<b>', '</b>', 'textarea')" />
							<input type="button" class="boutont10" value="Saut de ligne" onclick="insertTag('','<br/>','textarea')" />
							<input type="button" class="boutont4" value="Lien" onclick="insertTag('', '', 'textarea', 'lien')" />
							<input type="button" class="boutont4" value="Image" onclick="insertTag('&lt;image&gt;', '&lt;/image&gt;', 'textarea')" />
							<input type="button" class="boutont8" value="Citation" onclick="insertTag('', '', 'textarea', 'citation')" />
						</td></tr>
						<tr><td><label for="contenu">Votre article :</label></td><td><textarea id="contenu"></textarea></td></tr>
						<tr><td><label for="pageassocie">Page où poster cet article :</label>
						</td><td> 
							<select name="pageassocie">
								<option value="value1">Antenne ingénieur</option> 
								<option value="value2" selected>Antenne droit</option>
								<option value="value3">Antenne commerce</option>
								<option value="value4">Le bureau</option>
							</select>
						</td></tr><tr><td>
									<label for="visibleaccueil">Visible dans l'accueil :</label></td><td>
									<input type="radio" name="visibleaccueil" value="Oui" checked /><span>Oui</span>
									<input type="radio" name="visibleaccueil" value="Non"/> <span>Non</span>
							</td></tr>
						<tr><td colspan="2"><input id="envoyer" type="button" onclick="popup()" value="Poster l'article" width="100px;"></td></tr>
					</table>
				</form>
			</section>
		</div>
		<footer>
			<!-- COPYRIGHT -->
			<p>Créé par Michel GUIGNIER et Romain SOENEN.</p>
		</footer>
	</div>
</body>