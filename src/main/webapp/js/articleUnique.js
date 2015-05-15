
/*function affichageVisibiliteAuLancement(nomPageEnCours){
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
}*/
/*
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
*/

function recuperationNomPage(pageEnCours){
	var page="";
	for(var i=21;i<pageEnCours.length;i++){
		page=page+pageEnCours.charAt(i);
	}
	return page;
}


//Aller sur la page modification d'un article
function bouttonOuvrirModificationArticleUnique(event){ //////////????????????????????????????
	
	var nomPage=recuperationNomPage(event.id);
	$.ajax({
		url:"modifierarticleUnique",
		type:"POST",
		dataType: "json",
		data:{
			nomPage:nomPage,
			maFonction:"articleAccueil"
		}
	});
}