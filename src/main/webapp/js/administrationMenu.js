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
				maFonction:"fonctionAjout"
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

function supprimerMessage(event){
	var id=recuperationid(event.currentTarget.id);
	var confirmation= confirm("Etes vous sur de vouloir supprimer ce message?");
	if(confirmation){
		$.ajax({
			url:"administrationMenu",
			type:"POST",
			dataType:"json",
			data:{
				idpage:id,
				maFonction:"fonctionSuppression"
			}
		})
		alert("Le message a bien été supprimé");
		window.location.replace("administrationMenu");
	}
}
$(".casesupprimer").click(function(){supprimerMessage(event);});

//Recuperer id
function recuperationid(nomid){
	
	var centaine="",dizaine="",unite=0;
	var nom=nomid[0]+nomid[1]+nomid[2]+nomid[3];
	
	if(nom=="supp"){
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
	}else if(nom=="modi"){
		
		if(nomid.length >12){
			centaire=nomid[10];
			dizaine=nomid[11];
			unite=nomid[10];
		} else if(nomid.length > 11){
			dizaine=nomid[10];
			unite=nomid[11];
		}else {
			unite=nomid[10];
		}
		return centaine+dizaine+unite;
	}	
}

//Ajout Menu
var afficheAjoutMenu=true;
function montrerAjoutMenu(event){

	if(afficheAjoutMenu){
		$(".classAjoutMenu").show();
		afficheAjoutMenu=false;
	}else{
		$(".classAjoutMenu").hide();
		afficheAjoutMenu=true;
	}
}
$(".bouttonAjoutMenu").click(function(){montrerAjoutMenu(event);});
$(".classAjoutMenu").hide();

//Modifier Menu


function montrerModifierMenu(event){
	$(".bouttonModifierMenu").show();
	$(".classModificationMenu").show();
	var id=recuperationid(event.currentTarget.id);
	var idnom="idnompage"+id;
	alert(idnom);
	var montext1=$("#"+idnom);
	alert(montext1);
	var montext=$("#idnompage2").val();
	alert(montext);
	
}
function cacherModifierMenu(event){
	$(".bouttonModifierMenu").hide();
	$(".classModificationMenu").hide();
}
$(".casemodifier").click(function(){montrerModifierMenu(event);});
$(".bouttonModifierMenu").click(function(){cacherModifierMenu(event);});



