function recuperationid(nomid){
	var centaine="",dizaine="",unite=0;
	if(nomid.length >13){
		centaire=nomid[11];
		dizaine=nomid[12];
		unite=nomid[11];
	} else if(nomid.length > 12){
		dizaine=nomid[11];
		unite=nomid[12];
	}else {
		unite=nomid[11];
	}
	return centaine+dizaine+unite;
}

function montrerMessage(event){
	$(".cacher").hide();
	
	var id=recuperationid(event.currentTarget.id);
	
	$("#contenu"+id).show();
}
$(".caseVoirMessage").click(function(){montrerMessage(event);}); //NE MARCHE PAS AVEC MOZILLA
$(".cacher").hide();

function supprimerMessage(event){
	var id=recuperationid(event.currentTarget.id);
	var confirmation= confirm("Etes vous sur de vouloir supprimer ce message?");
	if(confirmation){
		$.ajax({
			url:"administrationContact",
			type:"POST",
			dataType:"json",
			data:{
				idMessage:id
			}
		})
		alert("Le message a bien été supprimé");
		window.location.replace("administrationContact");
	}
}
$(".casesupprimer").click(function(){supprimerMessage(event);});