$(document).ready(function() {
	var pageEnCours = window.location.href.split('/')[[window.location.href.split('/').length - 1]];
	var idArticle = recuperationId(pageEnCours);
	afficherElementModificationArticle(idArticle);
});



function recuperationId(url){
	var id="";
	var i=url.length;
	while(i>1 && url.charAt(i-1)!='='){
		id=url.charAt(i-1)+id;
		i--;
	}
	return id;
}

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
function afficherElementModificationArticle(idArticle){
	$.ajax({
		url:"ServletArticle",
		type:"GET",
		dataType: "json",
		data:{
			monid:idArticle,
			maFonction:"unArticle"
		},
		success:function(data, textStatus, xhr){
			$("#modificationArticleTitre").val(data.titre);
			$("#modificationArticleContenu").val(data.contenu);
			if(data.visiblePage){
				$('#visiblitetrue').attr('checked','checked')
			}else{
				$('#visiblitefalse').attr('checked','checked')
			}	
		}
	});
}


	