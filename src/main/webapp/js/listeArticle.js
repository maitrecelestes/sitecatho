/*var RecupererListeArticle = function(nomPageEnCours) {
	// Ecrire requête Ajax
	$.ajax({
		url:"ServletGestionSession", 
		type:"GET", 
		dataType: "json", 
		success:function(data, textStatus, xhr){  //Si connecté
			$.ajax({
				url:"ServletArticle",
				type:"GET",
				dataType: "json",
				data:{
					leNomDeMaPageChoisie:nomPageEnCours,
					maFonction:"tousLesArticle"
				},
			
				success:function(data, textStatus, xhr){ // Donne les articles visibles et non visibles
					var monarticle="";
					var page = window.location.href.split('?')[[window.location.href.split('?').length - 1]];				
					for (var i = 0; i < data.length; i++) {
						if(!data[i].archive){
							monarticle=monarticle+"<div class='unArticleDeLaPage'>";
							monarticle=monarticle+"<div class='cacherConnexion'>";
							monarticle=monarticle+"<a href='modifierarticle?"+page+"&idArticle="+data[i].idArticle+"'><button class='bouttonArticle bouttonModifierArticle' onclick='bouttonOuvrirModificationArticle(this)' id='modifierArticle"+data[i].idArticle+"' type='button'>Modification</button></a>";
							monarticle=monarticle+"<button class='bouttonArticle bouttonVisibiliteArticle' onclick='visibleArticle(this)' id='visibiliteArticle"+data[i].idArticle+"' type='button'>Visible</button>";
							monarticle=monarticle+"<button class='bouttonArticle bouttonSupprimerArticle' onclick='archiverArticle(this)' id='suppressionArticle"+data[i].idArticle+"' type='button'>Suppression</button>";
							monarticle=monarticle+"</div>";
							monarticle=monarticle+"<article class='monArticleParticulier' id='monArticleParticulier"+data[i].idArticle+"'>";
							monarticle=monarticle+"<h3 class='titreArticle'>"+data[i].titre+"</h3>";
							monarticle=monarticle+"<h4 class='dateArticle'>"+data[i].date+"</h4>";
							monarticle=monarticle+"<p class='contenuArticle'>"+data[i].contenu+"</p>";
							monarticle=monarticle+"</article>";	
							monarticle=monarticle+"</div>";	
						}			
					}
					//Organisation de la vue d'un article
					$("#leBlocDesArticles").append(monarticle);
					$(".cacherConnexion").hide();
					$("#lienNouvelArticle").hide();
					$.ajax({
						url:"ServletGestionSession", 
						type:"GET", 
						dataType: "json", 
						success:function(data, textStatus, xhr){ 
							$(".cacherConnexion").show();
							$("#lienNouvelArticle").show();
						}
					});
					affichageVisibiliteAuLancement(nomPageEnCours);
				}
			});
		},
		error:function(){ // si non connecté
			$.ajax({
				url:"ServletArticle",
				type:"GET",
				dataType: "json",
				data:{
					leNomDeMaPageChoisie:nomPageEnCours,
					maFonction:"tousLesArticle"
				},
			
				success:function(data, textStatus, xhr){ // Donne les articles visibles
					var monarticle="";
					for (var i = 0; i < data.length; i++) {
						if(!data[i].archive && data[i].visiblePage){
							monarticle=monarticle+"<article class='monArticleParticulier' id='monArticleParticulier"+data[i].idArticle+"'>";
							monarticle=monarticle+"<h3 class='titreArticle'>"+data[i].titre+"</h3>";
							monarticle=monarticle+"<h4 class='dateArticle'>"+data[i].date+"</h4>";
							monarticle=monarticle+"<p class='contenuArticle'>"+data[i].contenu+"</p>";
							monarticle=monarticle+"</article>";	
						}			
					}
					//Organisation de la vue d'un article
					$("#leBlocDesArticles").append(monarticle);
					$(".cacherConnexion").hide();
					$("#lienNouvelArticle").hide();
					$.ajax({
						url:"ServletGestionSession", 
						type:"GET", 
						dataType: "json", 
						success:function(data, textStatus, xhr){ 
							$(".cacherConnexion").show();
							$("#lienNouvelArticle").show();
						}
					});
				}
			});
		}
	});
	
}*/


function affichageVisibiliteAuLancement(nomPageEnCours){
	$.ajax({
		url:"ServletArticle",
		type:"GET",
		dataType: "json",
		data:{
			leNomDeMaPageChoisie:nomPageEnCours,
			maFonction:"tousLesArticle"
		},
		success:function(data, textStatus, xhr){
			for (var i = 0; i < data.length; i++) {
				if (data[i].visiblePage) {
					$("#visibiliteArticle"+data[i].idArticle).css({ opacity: 1 });
					$("#visibiliteArticle"+data[i].idArticle).text("Visible");
				}else{
					$("#visibiliteArticle"+data[i].idArticle).css({ opacity: 0.5 });
					$("#visibiliteArticle"+data[i].idArticle).text("Invisible");
				}	
				
			}
		}
	});
}

/*
$(document).ready(function() {
	var pageEnCours = window.location.href.split('/')[[window.location.href.split('/').length - 1]];
	var page = window.location.href.split('?')[[window.location.href.split('?').length - 1]];
	var dirNouvelArticle="nouvelarticle?"+page;	
	$("#lienNouvelArticle").attr("href",dirNouvelArticle);
	RecupererListeArticle(getParam("nompage",pageEnCours));
	
});
*/
function getParam(param_name, url) {
	var param_value = decodeURI(
	(RegExp(param_name + "=" + "(.+?)(&|$)").exec(url)||[,null])[1]
	);
	return param_value;
}

//Recuperer id
function recuperationid(nomid){
	var newid="";
	var i= nomid.length;
	while (nomid[i-2]!="l" && nomid[i-1]!="e" && i>0) {
		i--;
		newid=nomid[i]+newid;
	}
	return newid;
}


//Archiver un article
function archiverArticle(event){
	var id=recuperationid(event.id);
	var confirmation= confirm("Etes vous sur de vouloir supprimer cet article ?");
	if(confirmation){
		$.ajax({
			url:"ServletArticle",
			type:"POST",
			dataType:"json",
			data:{
				idarticle:id,
				maFonction:"archiveArticle"
			}
		})
	}
	location.reload();
}


//Visibilite d'un article
function visibleArticle(event){
	var id=recuperationid(event.id);
	$.ajax({
		url:"ServletArticle",
		type:"GET",
		dataType: "json",
		data:{
			monid:id,
			maFonction:"unArticle"
		},
		success:function(data, textStatus, xhr){
			if (data.visiblePage) {
				$("#visibiliteArticle"+data.idArticle).css({ opacity: 0.5 });
				$("#visibiliteArticle"+data.idArticle).text("Invisible");
			}else{
				$("#visibiliteArticle"+data.idArticle).css({ opacity: 1 });
				$("#visibiliteArticle"+data.idArticle).text("Visible");
			}		
		}
	});
	$.ajax({
		url:"ServletArticle",
		type:"POST",
		dataType:"json",
		data:{
			idarticle:id,
			maFonction:"visibleArticle"
		}
	})	
}


//Aller sur la page modification d'un article
function afficherPourModificationArticle(event){
	var id=recuperationid(event.id);
	$.ajax({
		url:"modifierarticle",
		type:"POST",
		dataType: "json",
	});
}