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
				rang:$('#rang').val(),
				visibilite:$("#visibilite").val(),
			}
		})
		alert("Votre menu a bien été ajouté");
		window.location.replace("http://localhost:8080/projet_catho/administrationMenu")
	} else {
		alert("Vous n'avez pas remplis vos champs correctement");
	}
	
}
$("#valider").click(function(){newHighScore();});