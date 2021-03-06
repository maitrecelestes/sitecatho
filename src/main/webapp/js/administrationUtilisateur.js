// Ajouter utilisateur

function ajouterUtilisateur() {

	if (verificationConditionAjout($("#newMail").val(), $("#newNom").val(), $(
			"#newPrenom").val(), $("#newMdp").val(), $("#newConfMdp").val(), $(
			"#newEcole").val()/* ,$("#pageGere").val() */)) {
		var confirmation = confirm("Etes vous sur de vouloir creer cet utilisateur ?");
	} else {
		alert(textVerificationConditionAjout($("#newMail").val(), $("#newNom")
				.val(), $("#newPrenom").val(), $("#newMdp").val(), $(
				"#newConfMdp").val(), $("#newEcole").val()/* ,$("#pageGere").val() */));
	}
	var pageGerer = "X";
	if ($("#newRang").val() == "redacteur") {
		pageGerer = $("#pageGere").val();
	}

	if (confirmation) {
		$.ajax({
			url : "administrationUtilisateur",
			type : "POST",
			dataType : "json",
			data : {
				requete : "inscription",
				mail : $("#newMail").val(),
				nom : $("#newNom").val(),
				prenom : $("#newPrenom").val(),
				mdp : $("#newMdp").val(),
				rang : $("#newRang").val(),
				ecole : $("#newEcole").val(),
				pageGere : pageGerer
			}
		})
		alert("L'utilisateur a bien \351t\351 ajout\351");
		window.location.replace("administrationUtilisateur");
	}
}
$("#caseajouterUtilisateur").click(function() {
	ajouterUtilisateur();
});

function verificationConditionAjout(mail, nom, prenom, motDePasse1,
		motDePasse2, ecole/* ,pageGere */) {
	var rep = true;
	if (!verificationMailExistance(mail) || nom.length < 2 || prenom.length < 2
			|| motDePasse1.length < 4 || motDePasse1 != motDePasse2
			|| ecole.length < 2) {
		var rep = false;
	}
	return rep;
}

function textVerificationConditionAjout(mail, nom, prenom, motDePasse1,
		motDePasse2, ecole/* ,pageGere */) {
	var rep = "ok";
	var nbProbleme = 0;
	// Verification du mail
	if (!verificationMailExistance(mail)) {
		nbProbleme++;
		var rep = "Il y a un probl\350me dans votre mail";
	}
	// Verification nom
	if (nom.length < 2) {
		nbProbleme++;
		var rep = "Il y a un probl\350me dans votre nom";
	}
	// Verification prenom
	if (prenom.length < 2) {
		nbProbleme++;
		var rep = "Il y a un probl\350me dans votre pr\351nom";
	}
	// Verification motDePasse1
	if (motDePasse1.length < 4) {
		nbProbleme++;
		var rep = "Votre mot de passe n'est pas assez long";
		// Verification motDePasse2
	} else if (motDePasse1 != motDePasse2) {
		nbProbleme++;
		var rep = "Vos 2 mots de passe ne sont pas identiques";
	}
	// Verification ecole
	if (ecole.length < 2) {
		nbProbleme++;
		var rep = "Il y a un probl\350me dans votre \351cole";
	}
	// Verification plusieurs problèmes
	if (nbProbleme > 1) {
		var rep = "Vous avez plusieurs probl\350mes dans votre formulaire";
	}
	return rep;
}

// verificationMail
function verificationMailExistance(mail) {
	var rep = true;
	var verif = /^([a-z0-9_\.-]+)@([a-z0-9\.-]+)\.([a-z\.]{2,6})$/
	if (verif.exec(mail) == null) {
		rep = false;
	}
	return rep;
}

function montrerFormulaireCreationUtilisateur() {
	$("#ajoutUtilisateur").show();
	// $("#montrerFormCreationUtilisateur").hide();
	$("#modifierUtilisateur").hide();
}
$("#montrerFormCreationUtilisateur").click(function() {
	montrerFormulaireCreationUtilisateur();
});

// Supprimer utilisateur
function supprimerUtilisateur(idUtilisateur) {
	var mail = $("#mail" + idUtilisateur).text();
	var confirmation = confirm("Etes vous sur de vouloir supprimer cet utilisateur : "
			+ mail);
	if (confirmation) {
		$.ajax({
			url : "administrationUtilisateur",
			type : "POST",
			dataType : "json",
			data : {
				requete : "suppression",
				mail : mail
			}
		})
		alert("L'utilisateur a bien \351t\351 supprim\351!");
		window.location.replace("administrationUtilisateur");
	}
}

// MODIFIER UTILISATEUR
function montrerFormulaireModifierUtilisateur(idUtilisateur) {
	var mail = $("#mail" + idUtilisateur).text();
	var pagegerer = $("#pagegerer" + idUtilisateur).text();
	var ecole = $("#ecole" + idUtilisateur).text();
	var rang = $("#rang" + idUtilisateur).text();

	$("#modifierUtilisateur").show();
	$("#ajoutUtilisateur").hide();

	if (rang == "redacteur") {
		$("#modRedacteur").attr("selected", "selected");
	} else {
		$("#modAdministrateur").attr("selected", "selected");
		$("#modpageGeretr").hide();
	}
	$("#modMail").text(mail);
	$("#modPageGere").val(pagegerer);
	$("#modEcole").val(ecole);
}

function cacherNewGerePage() {
	if ($("#newRang option:selected").val() == "administrateur") {
		$("#pageGeretr").hide();
	} else {
		$("#pageGeretr").show();
	}
}
$("#newRang").change(function() {
	cacherNewGerePage();
});

function cacherModifGerePage() {
	if ($("#modRang option:selected").val() == "administrateur") {
		$("#modpageGeretr").hide();
	} else {
		$("#modpageGeretr").show();
	}
}
$("#modRang").change(function() {
	cacherModifGerePage();
});
function modifierUtilisateur() {
	if ($("#modmdp").val()!=$("#confmodmdp").val()){
		alert ("Les deux mots de passes que vous avez entrés sont différents");
	} else {
		var pageGerer = "X";
		if ($("#modRang").val() == "redacteur") {
			pageGerer = $("#modPageGere").val();
		}
		if ($("#modRang").val() != "redacteur" || $("#modPageGere").val() != null) {
			if ($("#modEcole").val() != "") {
				var confirmation = confirm("Etes vous sur de vouloir modifier cet utilisateur ?");
				if (confirmation) {
					$.ajax({
						url : "administrationUtilisateur",
						type : "POST",
						dataType : "json",
						data : {
							requete : "modification",
							mail : $("#modMail").text(),
							rang : $("#modRang").val(),
							ecole : $("#modEcole").val(),
							mdp: $("#modmdp").val(),
							pageGere : pageGerer
						}
					})
					alert("L'utilisateur a bien \351t\351 modifi\351 !");
					window.location.replace("administrationUtilisateur");
				}
			} else {
				alert("L'\351cole n'est pas renseign\351e !");
			}
		} else {
			alert("Vous n'avez pas choisi la page g\351r\351e.");
		}
	}

}
$("#casemodifierUtilisateur").click(function() {
	modifierUtilisateur();
});
