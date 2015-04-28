// Ajouter utilisateur

function ajouterUtilisateur(event){

	if(verificationConditionAjout($("#newMail").val(),$("#newNom").val(),$("#newPrenom").val(),$("#newMdp").val(),$("#newConfMdp").val(),$("#newEcole").val()/*,$("#pageGere").val()*/)){
		var confirmation= confirm("Etes vous sur de vouloir creer cet utilisateur ?");
	} else {
		alert(textVerificationConditionAjout($("#newMail").val(),$("#newNom").val(),$("#newPrenom").val(),$("#newMdp").val(),$("#newConfMdp").val(),$("#newEcole").val()/*,$("#pageGere").val()*/));
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
				mdp:$("#newMdp").val(),
				rang:$("#newRang").val(),
				ecole:$("#newEcole").val(),
				pageGere:$("#pageGere").val()
			}
		})
		//alert("L'utilisateur a bien été ajouté!");
		window.location.replace("administrationUtilisateur");
	}
}
$("#caseajouterUtilisateur").click(function(){ajouterUtilisateur(event);});

function verificationConditionAjout(mail,nom,prenom,motDePasse1,motDePasse2,ecole/*,pageGere*/){
	var rep=true;
	if(!verificationMailExistance(mail) || nom.length<2 || prenom.length<2 
			|| motDePasse1.length<4 || motDePasse1!=motDePasse2 || ecole.length<2){
		var rep=false;
	}
	return rep;
}

function textVerificationConditionAjout(mail,nom,prenom,motDePasse1,motDePasse2,ecole/*,pageGere*/){
	var rep="ok";
	var nbProbleme=0;
	//Verification du mail
	if(!verificationMailExistance(mail)){
		nbProbleme++;
		var rep="probleme mail";
	}
	//Verification nom
	if(nom.length<2){
		nbProbleme++;
		var rep="probleme nom";
	}
	//Verification prenom
	if(prenom.length<2){
		nbProbleme++;
		var rep="probleme prenom";
	}
	//Verification motDePasse1
	if(motDePasse1.length<4){
		nbProbleme++;
		var rep="probleme motDePasse1";
	}
	//Verification motDePasse2
	if(motDePasse1!=motDePasse2){
		nbProbleme++;
		var rep="probleme motDePasse2";
	}
	//Verification motDePasse2
	if(ecole.length<2){
		nbProbleme++;
		var rep="probleme ecole";
	}
	//Verification plusieurs problèmes
	if(nbProbleme>1){
		var rep="plusieurs problemes";
	}
	return rep;
}



//verificationMail
function verificationMailExistance(mail){
	var rep=false;
	var positionArobase=1;
	while(mail.charAt(positionArobase)!='@' && positionArobase<mail.length){
		positionArobase++;
	}
	var positionPoint=positionArobase;
	while(mail.charAt(positionPoint)!='.' && positionPoint<mail.length){
		positionPoint++;
	}
	if(0<positionArobase && positionArobase<(positionPoint-1) && positionPoint<(mail.length-1)){
		rep=true;
	}
	return rep;
}

function montrerFormulaireCreationUtilisateur(event){
	$("#ajoutUtilisateur").show();
	$("#montrerFormCreationUtilisateur").hide();
	$("#modifierUtilisateur").hide();
}
$("#montrerFormCreationUtilisateur").click(function(){montrerFormulaireCreationUtilisateur(event);});


// Supprimer utilisateur
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

// MODIFIER UTILISATEUR
function montrerFormulaireModifierUtilisateur(event){
	$("#modifierUtilisateur").show();
	$("#ajoutUtilisateur").hide();
	var mail="";
	for (var i=23;i<event.currentTarget.id.length;i++){
		mail=mail+event.currentTarget.id[i];
	}
	$("#modMail").val(mail);
}
$(".caseModifierUtilisateur").click(function(){montrerFormulaireModifierUtilisateur(event);});


function cacherNewGerePage(){
	if ($("#newRang option:selected").val()=="administrateur"){
		$("#pageGeretr").hide();
	} else {
		$("#pageGeretr").show();
	}	
}
$( "#newRang" ).change(function() {
	cacherGerePage();
});

function cacherModifGerePage(){
	if ($("#modRang option:selected").val()=="administrateur"){
		$("#modpageGeretr").hide();
	} else {
		$("#modpageGeretr").show();
	}	
}
$( "#modRang" ).change(function() {
	cacherModifGerePage();
});
function modifierUtilisateur(event){
	var confirmation= confirm("Etes vous sur de vouloir modifier cet utilisateur ?");
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				requete:"modification",
				mail:$("#modMail").val(),
				rang:$("#modRang").val(),
				ecole:$("#modEcole").val(),
				pageGere:$("#modPageGere").val()
			}
		})
		alert("L'utilisateur a bien été modifié!");
		window.location.replace("administrationUtilisateur");
	}
}
$("#casemodifierUtilisateur").click(function(){modifierUtilisateur(event);});

