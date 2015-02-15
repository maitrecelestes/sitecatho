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


