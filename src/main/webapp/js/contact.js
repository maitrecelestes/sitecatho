$("#envoyer").click(function() {
	envoieContact();
});

// verificationMail
function verificationMailExistance(mail) {
	var rep = true;
	var verif = /^([a-z0-9_\.-]+)@([a-z0-9\.-]+)\.([a-z\.]{2,6})$/
	if (verif.exec(mail) == null) {
		rep = false;
	}
	return rep;
}

function envoieContact() {
	if ($("#contenu").val() != "") {
		if (verificationMailExistance($("#mail").val())) {
			$.ajax({
				url : "contact",
				type : "POST",
				dataType : "json",
				data : {
					prenom : $("#prenom").val(),
					nom : $("#nom").val(),
					objet : "" + $("#objet").val(),
					mail : "" + $("#mail").val(),
					contenu : "" + $("#contenu").val(),
				}
			})
			alert("Votre message a bien \351t\351 envoy\351");
			window.location.replace("contact")
		} else {
			alert("Vous avez fait une erreur dans votre adresse mail.");
		}
	} else {
		alert("Votre message est vide.");
	}

}
$("#valider").click(function() {
	newHighScore();
});