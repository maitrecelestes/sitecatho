$(document)
		.ready(
				function() {
					var pageEnCours = window.location.href.split('/')[[ window.location.href
							.split('/').length - 1 ]];
					afficherElementModificationArticleUnique(recuperationNomPage(pageEnCours));
				});

function recuperationNomPage(pageEnCours) {
	var page = "";
	for (var i = 30; i < pageEnCours.length; i++) {
		page = page + pageEnCours.charAt(i);
	}
	return page;
}

// Recuperer les modification d'un article
function afficherElementModificationArticleUnique(nomPage) {
	$.ajax({
		url : "ServletArticleUnique",
		type : "GET",
		dataType : "json",
		data : {
			nompage : nomPage,
		},
		success : function(data, textStatus, xhr) {
			$("#modifierArticleUniqueTitre").val(data.titre);
			$("#modifierArticleUniqueContenu").val(data.contenu);
		}
	});
}
