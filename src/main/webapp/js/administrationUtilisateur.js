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

function ajouterUtilisateur(event){
	if($("#newMail").val().length>3&&$("#newNom").val().length>2&&$("#newPrenom").val().length>3&&$("#newEcole").val().length>1){
		var confirmation= confirm("Etes vous sur de vouloir creer cet utilisateur");
	} else {
		alert("Veuillez remplir tous les champs de textes");
	}
	
	
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				requete:"inscription",
				mail:$("#newMail").val(),
				nom:$("#newNom").val(),
				prenom:$("#newPrenom").val(),
				mdp:"mdp",
				dateDeNaissance:$("#newDateNaissance").val(),
				rang:$("#newRang").val(),
				ecole:$("#newEcole").val()
			}
		})
		alert("L'utilisateur a bien été ajouté!");
		window.location.replace("administrationUtilisateur");
	}
}
$("#caseajouterUtilisateur").click(function(){ajouterUtilisateur(event);});

function supprimerUtilisateur(event){
	var confirmation= confirm("Etes vous sur de vouloir creer cet utilisateur : "+event.currentTarget.id);
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				requete:"suppression",
				mail:event.currentTarget.id
			}
		})
		alert("L'utilisateur a bien été ajouté!");
		window.location.replace("administrationUtilisateur");
	}
}
$(".casesupprimer").click(function(){supprimerUtilisateur(event);});
