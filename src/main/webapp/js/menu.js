
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
				if(i<data.length-1 && data[i].rang==0 && data[i+1].rang==0 && data[i].visibilite){
					montext=montext+"<a href='"+choixPage(data[i].nompage)+"?nompage="+choixPagenom(data[i].nompage)+"'><li>"+data[i].nompage+"</li></a>";
					nb=nb+1;
				//Si Titre principal et des sous liens
				} else if (i < data.length - 1 && data[i].rang == 0
						&& data[i + 1].rang == 1 && data[i].visibilite) {
					montext =montext+"<li class='dir'>"+data[i].nompage;
					montext=montext+"<ul>";
					var nbAjout=1;
					while (i+nbAjout<=data.length-1 && data[i+nbAjout].rang==1) {
						if(data[i+nbAjout].visibilite){
							montext=montext+"<a href='"+choixPage(data[i+nbAjout].nompage)+"?nompage="+choixPagenom(data[i+nbAjout].nompage)+"'><li>"+data[i+nbAjout].nompage+"</li></a>";
						}
						nbAjout=nbAjout+1;
						nb=nb+1;
					}
					nb=nb+1;
					montext=montext+"</ul></li>";

				}else if(i==data.length-1 && data[i].rang==0 && data[i].visibilite){
					montext=montext+"<a href='"+choixPage(data[i].nompage)+"?nompage="+choixPagenom(data[i].nompage)+"'><li>"+data[i].nompage+"</li></a>";
				}
			}
			montext=montext+"</ul>";
			$(monid).append(montext);
		}
	})
}
$(document).ready(function() {
	afficherLeVraiMenu();
	afficherArticleMenuDeGauche();
});


function choixPage(nomDepage){
	
	var urlPage="maPageClassique";
	return urlPage;
	
}

function choixPagenom(nomDepage){
	
	var urlPage=nomDepage;
	return urlPage;
	
}


var cacherPage = function() {
	$("#bouttonDeconnexion").hide();
	$("#bouttonConnexion").show();
	$("#administration").hide();
	$.ajax({
		url:"ServletGestionSession", 
		type:"GET", 
		dataType: "json", 
		success:function(data, textStatus, xhr){ 
			var nb=0; 
			var monid="#monmenuchange"; 
			var existanceJson=data.length; 
			if (existanceJson==5){
				$("#bouttonDeconnexion").show(); 
				$("#bouttonConnexion").hide(); 
				if(data[3]=="administrateur"||data[3]=="super administrateur"){
					$("#administration").show();
					
				}
			} 
			var montextNomPrenom="Bonjour "+data[2]+" "+data[1];
			$('#connexionNomPrenom').append(montextNomPrenom);
		}
	}) 
} 

$(document).ready(function() { cacherPage(); });



var afficherArticleMenuDeGauche = function() {
	// Ecrire requête Ajax
	$.ajax({
		url:"ServletBlocDeGauche",
		type:"GET",
		dataType: "json",
		success:function(data, textStatus, xhr){
			$(articleBlocDeGaucheTitre).text(data.titre);
			$(articleBlocDeGaucheContenu).append(data.contenu);
		}
	})
}