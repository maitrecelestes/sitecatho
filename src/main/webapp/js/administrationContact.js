function montrerMessage(event){
	$(".cacher").hide();
	var centaine="",dizaine="",unite=0;
	var nomid=event.currentTarget.id;;
	
	if(nomid.length==14){
		centaire=nomid[13];
	}
	if(nomid.length >= 13){
		dizaine=nomid[12];
	}
	unite=nomid[11];
	$("#contenu"+centaine+dizaine+unite).show();
}
$(".ligneContact").click(function(){montrerMessage(event);});
$(".cacher").hide();