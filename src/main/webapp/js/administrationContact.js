$(".cacher").hide();
function montrerMessage(id) {
	$(".cacher").hide();
	$("#contenu" + id).show();
}

function supprimerMessage(id) {
	var confirmation = confirm("Etes vous sur de vouloir supprimer ce message?");
	if (confirmation) {
		$.ajax({
			url : "administrationContact",
			type : "POST",
			dataType : "json",
			data : {
				idMessage : id
			}
		})
		alert("Le message a bien \351t\351 supprim\351");
		window.location.replace("administrationContact");
	}
}
