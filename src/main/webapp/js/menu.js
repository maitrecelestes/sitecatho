
var afficherLeVraiMenu = function() {
	// Ecrire requête Ajax
	$.ajax({
		url:"ServletMenu",
		type:"GET",
		dataType: "json",
		success:function(data, textStatus, xhr){
			var nb=0;
			var monid="#monmenuchange";
			var longueurListeMenu=data.length;
			var montext="<ul id='nav' class='dropdown dropdown-vertical'>";
			
			
			
			for (var i = 0; i < data.length; i++) {
				//Si Titre principal sans sous lien
				if(i<data.length-1 && data[i].rang==0 && data[i+1].rang==0){
					montext=montext+"<li><a href='"+choixPage(data[i].nompage)+"?nompage="+choixPagenom(data[i].nompage)+"'>"+data[i].nompage+"</a></li>";
					nb=nb+1;
				//Si Titre principal et des sous liens
				}else if(i<data.length-1 && data[i].rang==0 && data[i+1].rang==1){
					montext=montext+"<li class='dir'>"+data[i].nompage;
					montext=montext+"<ul>";
					var nbAjout=1;
					while (i+nbAjout<=data.length-1 && data[i+nbAjout].rang==1) {
						montext=montext+"<li><a href='"+choixPage(data[i+nbAjout].nompage)+"?nompage="+choixPagenom(data[i+nbAjout].nompage)+"'>"+data[i+nbAjout].nompage+"</a></li>";
						nbAjout=nbAjout+1;
						nb=nb+1;
					}
					nb=nb+1;
					montext=montext+"</ul></li>";

				}else if(i==data.length-1 && data[i].rang==0){
					montext=montext+"<li><a href='"+choixPage(data[i].nompage)+"?nompage="+choixPagenom(data[i].nompage)+"'>"+data[i].nompage+"</a></li>";
				}
			}
			montext=montext+"</ul>";
			$(monid).append(montext);
		}
	})
}
$(document).ready(function() {
	afficherLeVraiMenu();
});


function choixPage(nomDepage){
	
	var urlPage="maPageClassique";
	if(nomDepage=="AdministrationMenu"){
		urlPage= "administrationMenu";
	}else	if(nomDepage=="AdministrationContact"){
		urlPage= "administrationContact";
	}else	if(nomDepage=="Administrationutilisateur"){
		urlPage= "administrationUtilisateur";
	}else	if(nomDepage=="Accueil"){
		urlPage= "acceuil";
	}
	////////////////////////////////////////////A completer pour les pages predefinies
	return urlPage;
	
}

function choixPagenom(nomDepage){
	
	var urlPage="";
	if(nomDepage=="AdministrationMenu"){
		urlPage= "administrationMenu";
	}else	if(nomDepage=="AdministrationContact"){
		urlPage= "administrationContact";
	}else	if(nomDepage=="Administrationutilisateur"){
		urlPage= "administrationUtilisateur";
	}else	if(nomDepage=="Accueil"){
		urlPage= "acceuil";
	}else{
		urlPage=nomDepage;
	}
	////////////////////////////////////////////A completer pour les pages predefinies
	return urlPage;
	
}

function revoietextRang(elementListe){
	var montext="zzzz";
	if(elementListe.rang==0 && elementListe.rang==0){
		montext="<li>"+elementListe.nompage+"</li>";
	}else{
		montext="<li>rjbgoolbzglvire</li><ul><li class='lienMenu'>"+elementListe.nompage+"</li></ul>";
	}
	return montext;
}


function Aumonerie(){
	if (!$('#lienAumonerie').is(":visible")){
		$('.blocLienMenu').hide();
		$('#lienAumonerie').show();
		$('#liAumonerie').toggleClass('pucePrincipales puceFlecheBas');
	} else {
		$('#lienAumonerie').hide();
		$('#liAumonerie').toggleClass('puceFlecheBas pucePrincipales');
	}
	/*$( ".pucePrincipales" ).css({
		'list-style-image':'url(../Images/FlecheBas.png)'});*/
}

function Annonces(){
	if (!$('#lienAnnonce').is(":visible")){
		$('.blocLienMenu').hide();
		$('#lienAnnonce').show();
		$('#liAnnonce').toggleClass('pucePrincipales puceFlecheBas');
	} else {
		$('#lienAnnonce').hide();
		$('#liAnnonce').toggleClass('puceFlecheBas pucePrincipales');
	}
}
function Activites(){
	if (!$('#lienActivite').is(":visible")){
		$('.blocLienMenu').hide();
		$('#lienActivite').show();
		$('#liActivite').toggleClass('pucePrincipales puceFlecheBas');
	} else {
		$('#lienActivite').hide();
		$('#liActivite').toggleClass('puceFlecheBas pucePrincipales');
	}
}
function Antennes(){
	if (!$('#lienAntenne').is(":visible")){
		$('.blocLienMenu').hide();
		$('#lienAntenne').show();
		$('#liAntenne').toggleClass('pucePrincipales puceFlecheBas');
	} else {
		$('#lienAntenne').hide();
		$('#liAntenne').toggleClass('puceFlecheBas pucePrincipales');
	}
}


