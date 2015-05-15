
function recuperationNomPage(pageEnCours){
	var page="";
	for(var i=21;i<pageEnCours.length;i++){
		page=page+pageEnCours.charAt(i);
	}
	return page;
}


//Aller sur la page modification d'un article
function bouttonOuvrirModificationArticleUnique(event){
	
	var nomPage=recuperationNomPage(event.id);
	$.ajax({
		url:"modifierarticleUnique",
		type:"POST",
		dataType: "json",
		data:{
			nomPage:nomPage,
		}
	});
}