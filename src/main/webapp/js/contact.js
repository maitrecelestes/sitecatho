$("#envoyer").click(function(){envoieContact();});

function envoieContact(){
	
	if(true){
		$.ajax({
			url:"contact",
			type:"POST",
			dataType:"json",
			data:{
				prenom:$("#prenom").val(),
				nom:$("#nom").val(),
				objet:""+$("#objet").val(),
				mail:""+$("#mail").val(),
				contenu:""+$("#contenu").val(),
			}
		})
		alert("Votre message a bien été envoyé");
		window.location.replace("contact")
	} else {
		alert("Vous n'avez pas remplis vos champs correctement");
	}
	
}
$("#valider").click(function(){newHighScore();});