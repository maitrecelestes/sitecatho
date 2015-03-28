<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<link href="css/menuDropdown.vertical.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="css/menuDefault.css" media="screen" rel="stylesheet" type="text/css" />

<section>
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
				<li><a href="administrationMenu">AdministrationMenu</a></li>
				<li><a href="administrationUtilisateur">AministrationUtilisateur</a></li>
				<li><a href="administrationContact">AdministrationContact</a></li>
			</ul></li>
			<li id="bouttonConnexion"><a href="connexion">Connexion</a></li>
			<li id="bouttonDeconnexion"><a href="deconnexion">Deconnexion</a></li>
			
			
		</ul>
	</div>
</div>
</section>	 