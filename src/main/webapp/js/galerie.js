function ajouterinput(){
	var numerobase=$("#nombrelien").val();
	var numero=parseInt(numerobase)+1;
	var label = $("<label>").text("Lien pour l'image "+numero);
	var input = $('<input type="text">').attr({id: 'lien'+numero, name: 'lien'+numero});
	var br=$('<br/>');
	input.appendTo(label);
	$('#mesinput').append(label);
	$('#mesinput').append(br);
	$("#nombrelien").val(numero);
}
$("#ajouterinput").click(function(){ajouterinput();});

function afficherAjoutCategorie(event){
	$("#ajoutCategorie").show();
}
$("#boutonAjoutCategorie").click(function(){afficherAjoutCategorie(event);});

function supprimerCategorie(event){
	var id=event.currentTarget.id;
	var confirmation= confirm("Etes vous sur de vouloir supprimer cette catégorie?");
	if(confirmation){
		$.ajax({
			url:"galerie",
			type:"POST",
			dataType:"json",
			data:{
				action:"suppressionCategorie",
				idCategorieSupprimer:id
			}
		})
		alert("La categorie a bien ete supprimee");
		window.location.replace("galerie");
	}
}
$(".supprimerCategorie").click(function(){supprimerCategorie(event);});