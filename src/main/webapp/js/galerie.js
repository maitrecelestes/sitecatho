function ajouterinput(){
	var numerobase=$("#nombrelien").val();
	var numero=parseInt(numerobase)+1;
	var label = $("<label>").text("Lien pour l'image "+numero+" :");
	var input = $('<input type="text">').attr({id: 'lien'+numero, name: 'lien'+numero});
	var br=$('<br/>');
	input.appendTo(label);
	$('#mesinput').append(label);
	$('#mesinput').append(br);
	$("#nombrelien").val(numero);
}
$("#ajouterinput").click(function(){ajouterinput();});

function afficherAjoutCategorie(){
	$("#ajoutCategorie").show();
}


function supprimerCategorie(idCategorie){
	var confirmation= confirm("\312tes vous s\373r de vouloir supprimer cette cat\351gorie?");
	if(confirmation){
		$.ajax({
			url:"galerie",
			type:"POST",
			dataType:"json",
			data:{
				action:"suppressionCategorie",
				idCategorieSupprimer:idCategorie
			}
		})
		alert("La cat\351gorie a bien \351t\351 supprim\351e");
		window.location.replace("galerie");
	}
}


function supprimerImage(idImage,idCategorie){
	
	
	var confirmation= confirm("\312tes vous s\373r de vouloir supprimer cette image?");
	if(confirmation){
		$.ajax({
			url:"categorieGalerie",
			type:"POST",
			dataType:"json",
			data:{
				action:"suppressionImage",
				idImageSupprimer:idImage
			}
		})
		alert("L'image a bien \351t\351 supprim\351e");
		window.location.replace("categorieGalerie?idpage="+idCategorie);
	}
}
