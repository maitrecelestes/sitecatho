
var RecupererListeArticle = function(nomPageEnCours) {
	// Ecrire requête Ajax
	$.ajax({
		url:"ServletArticle",
		type:"GET",
		dataType: "json",
		data:{
			leNomDeMaPageChoisie:nomPageEnCours,
		},
	
		success:function(data, textStatus, xhr){
			$("#titrePageClassique").text(data[0].page);
			$("#leBlocDesArticles").append("<article class='monArticleParticulier'>Il y a en tout "+data.length+" article(s)</article>");
			var monarticle="";
			for (var i = 0; i < data.length; i++) {
				monarticle=monarticle+"<article class='monArticleParticulier'>";
				monarticle=monarticle+"<h3 class='titreArticle'>"+data[i].titre+"</h3>";
				monarticle=monarticle+"<h4 class='dateArticle'>"+data[i].date+"</h4>";
				monarticle=monarticle+"<p class='contenuArticle'>"+data[i].contenu+"</p>";
				monarticle=monarticle+"</article>";
				//Ici il faut organiser la vue d'un article
				
			}
			$("#leBlocDesArticles").append(monarticle);
		}
	})
}
$(document).ready(function() {
	var pageEnCours = window.location.href.split('/')[[window.location.href.split('/').length - 1]];
	RecupererListeArticle(getParam("nompage",pageEnCours));
});

function getParam(param_name, url) {
	var param_value = decodeURI(
	(RegExp(param_name + "=" + "(.+?)(&|$)").exec(url)||[,null])[1]
	);
	return param_value;
	}
