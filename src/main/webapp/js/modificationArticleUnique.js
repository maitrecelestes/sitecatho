$(document).ready(function() {
	var pageEnCours = window.location.href.split('/')[[window.location.href.split('/').length - 1]];
	alert("page en cours : "+pageEnCours);
	//alert(recuperationNomPage(pageEnCours));
	//afficherElementModificationArticleUnique(recuperationNomPage(pageEnCours));
});



function recuperationpage(arguments){
	var page="";
	var i=0;
	while(i<arguments.length-1 && arguments.charAt(i)!='&'){
		page=page+arguments.charAt(i);
		i++;
	}
	return page;
}


//Recuperer les modification d'un article
function afficherElementModificationArticleUnique(nomPage){
	$.ajax({
		url:"ServletArticle",
		type:"GET",
		dataType: "json",
		data:{
			maPage:nomPage,
			maFonction:"unArticleUnique"
		},
		success:function(data, textStatus, xhr){
			$("#modificationArticleUniqueTitre").val(data.titre);
			$("#modificationArticleUniqueContenu").val(data.contenu);
		}
	});
}



	