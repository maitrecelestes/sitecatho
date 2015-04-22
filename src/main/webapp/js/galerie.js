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