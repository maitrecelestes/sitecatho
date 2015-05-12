$(document).ready(function() {
	alert("ok");
	//var pageEnCours = window.location.href.split('/')[[window.location.href.split('/').length - 1]];
	//location.replace("maPageClassique?"+recuperationPage(suppressionid(pageEnCours)));
});



function recuperationId(url){
	var id="";
	var i=url.length;
	while(i>1 && url.charAt(i-1)!='='){
		id=url.charAt(i-1)+id;
		i--;
	}
	return id;
}

function suppressionid(url){
	var page="";
	var i=0;
	while(i<url.length-1 && url.charAt(i)!='&'){
		page=page+url.charAt(i);
		i++;
	}
	return page;
}

function recuperationPage(url){
	var page="";
	var i=url.length;
	while(i>0 && url.charAt(i)!='?'){
		page=url.charAt(i)+page;
		i--;
	}
	return page;
} 

	