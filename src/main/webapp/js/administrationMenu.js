

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
$("#bouttonPourAjouterMenu").click(function(){ajouteMenu();});

function ModifierMenu(){
	
	if(true){
		$.ajax({
			url:"administrationMenu",
			type:"POST",
			dataType:"json",
			data:{
				idModif:$("#idpageModif").text(),
				nompageModif:$("#nompageModif").val(),
				nompageprecedenteModif:$("#nompageprecedenteModif").val(),
				rangModif:isChecked($('#rang0Modif')),
				visibiliteModif:$("#visibiliteModif").val(),
				maFonction:"fonctionModification"
			}
		})
		alert("Votre menu a bien été modifié");
		window.location.replace("administrationMenu")
	} else {
		alert("Vous n'avez pas remplis vos champs correctement");
	}
	
}
$("#bouttonPourModifierMenu").click(function(){ModifierMenu();});



function isChecked(checkbox) {
    if(checkbox.is(':checked')) {
        return true;
    }
    else { return false; }
}

function supprimerMenu(event){
	var id=recuperationid(event.currentTarget.id);
	var confirmation= confirm("Etes vous sur de vouloir supprimer cette page ?");
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
$(".casesupprimer").click(function(){supprimerMenu(event);});



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
	$(".bouttonModifierMenu").hide();
	$(".classModificationMenu").hide();
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
	$(".classAjoutMenu").hide();
	$(".bouttonModifierMenu").show();
	$(".classModificationMenu").show();
	var id=recuperationid(event.currentTarget.id);
	$("#idpageModif").text(id);
	$("#nompageModifBrut").text("");
	$("#nompageModifBrut").append($("#idnompage"+id).text());
	$("#nompageModif").attr("value",$("#idnompage"+id).text());
	var rangChoisi =$("#idrang"+id).text(); 
	$("#rang"+rangChoisi+"Modif").prop('checked', true);
	if($("#idvisibilite"+id).text()=="false"){
		$("#visibiliteModif").prop('checked', false);
	}else{
		$("#visibiliteModif").prop('checked', true);
	}	
	var id1=id-1;
	$("#nompageprecedenteModif"+id1).attr('selected',"selected");
	
}


function cacherModifierMenu(event){
	$(".classAjoutMenu").hide();
	$(".bouttonModifierMenu").hide();
	$(".classModificationMenu").hide();
}
$(".casemodifier").click(function(){montrerModifierMenu(event);});
$(".bouttonModifierMenu").click(function(){cacherModifierMenu(event);});
