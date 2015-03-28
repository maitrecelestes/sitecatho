<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<link href="css/menuDropdown.vertical.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="css/menuDefault.css" media="screen" rel="stylesheet" type="text/css" />

<section>

	<div id="blocLogo">
		<a href="accueil"><img src="Images/LogoAumonerie.png"></a>
	</div>
	  
	<div id="blocMenu">
		<div id="menu">
			<div>
				<ul id='nav' class='dropdown dropdown-vertical'>
					<li><a href="accueil">Accueil</a></li>
				</ul>
			</div>
		
			<div><span id="monmenuchange"></span></div>	
			
			<div>
				<ul id='nav' class='dropdown dropdown-vertical'>
					<li><a href="contact">Contact</a></li>
					<li class='dir'>Administration<ul>
						<li><a href="administrationContact">Contact</a></li>
						<li><a href="administrationMenu">Menu</a></li>
						<li><a href="administrationUtilisateur">Utilisateur</a></li>
					</ul></li>
					<li id="bouttonConnexion"><a href="connexion">Connexion</a></li>
					<li id="bouttonDeconnexion"><a href="deconnexion">Deconnexion</a></li>
					
					
				</ul>
			</div>
		</div>
	</div>
	  
	<div id="blocLienInternet">
		<table id=tableauLienInternet> 
			<tr> 
				<td> <a href="https://www.facebook.com/AumonerieUniversiteCatholiqueDeLille?fref=ts"><img id="iconefacebook" src="Images/iconefacebook.png"/></a> </td> 
				<td> <a href="https://twitter.com/auclille"><img id="iconetwitter" src="Images/iconetwitter.png"/></a><br/> </td> 
				<td> <a href="https://www.youtube.com/channel/UCc8J3Ztfts4Exaas2pDWUrA"> <img id="iconeyoutube" src="Images/iconeyoutube.png"/></a> </td> 
				<td> <a href="http://www.univ-catholille.fr/index.asp"> <img id="logocatho" src="Images/logocatho.png"/></a> </td> 
			</tr> 
		</table>
	</div>
	  
	<div id="blocInformation">
		mes informations
	</div>






























</section>	 