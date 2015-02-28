function popup(){
	alert("Votre message a bien été envoyé.");
}


$("#ajouterMenu").click(function(){ajouteMenu();});

function ajouteMenu(){
	
	if(true){
		$.ajax({
			url:"administrationMenu",
			type:"POST",
			dataType:"json",
			data:{
				nompage:$("#nompage").val(),
				nompageprecedente:$("#nompageprecedente").val(),
				rang:isChecked($('#rang1')),
				
				visibilite:$("#visibilite").val(),
			}
		})
		alert("Votre menu a bien été ajouté");
		window.location.replace("administrationMenu")
	} else {
		alert("Vous n'avez pas remplis vos champs correctement");
	}
	
}
$("#valider").click(function(){newHighScore();});


function isChecked(checkbox) {
    if(checkbox.is(':checked')) {
        return true;
    }
    else { return false; }
}