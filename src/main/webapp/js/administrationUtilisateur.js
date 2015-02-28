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
function ajouterMessage(event){
	var confirmation= confirm("Etes vous sur de vouloir creer cet utilisateur");
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				mail:$("#newMail").val(),
				nom:$("#newNom").val(),
				prenom:$("#newPrenom").val(),
				dateDeNaissance:$("#newDateNaissance").val(),
				rang:$("#newRang").val(),
				ecole:$("#newEcole").val()
			}
		})
		alert("L'utilisateur a bien été ajouté!");
		window.location.replace("administrationUtilisateur");
	}
}
$("#caseajouterUtilisateur").click(function(){ajouterMessage(event);});

