function connexionUtilisateur(event){
		$.ajax({
			url:"connexion",
			type:"POST",
			dataType:"json",
			data:{
				requete:"connexion",
				mail:$("#mail").val(),
				mdp:$("#mdp").val()
			}
		})
		
	}
$("#seconnecter").click(function(){connexionUtilisateur(event);});