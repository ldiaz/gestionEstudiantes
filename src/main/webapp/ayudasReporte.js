
window.onload = detectarCarga;
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
})

function inhab(checkpro,textpro){
	
	if (checkpro.checked){
		textpro.disabled=false;
		document.getElementById("textpro").style.backgroundColor="#ffffff";
	}
	else {		
		textpro.disabled=true;
		document.getElementById("textpro").style.backgroundColor="#C1BFBF";
	
	}
	
}
function inhabeve(checkeve,texteve){
	
	if (checkeve.checked){
		texteve.disabled=false;
		document.getElementById("texteve").style.backgroundColor="#ffffff";
	}
	else {		
		texteve.disabled=true;
		document.getElementById("texteve").style.backgroundColor="#C1BFBF";
	}
	
}
function detectarCarga(){
	  document.getElementById("texteve").style.backgroundColor="#C1BFBF";
	  document.getElementById("textpro").style.backgroundColor="#C1BFBF";	  
	 }