
/**
 * Function created to validate if the drop down fields are being properly 
 * populated before call to the server 
 */
function validateNullsAndEmpty(){

	var formValid = false;
    var j =0;
  
    	//alert($( "input:checked" ).val());
    	
    	if ($( "input:checked" ).val() != undefined)
        {
            formValid = true;
            j++;
        }
  
    return formValid
     
}

function capture()
{
    var resultado="ninguno";

    var values=document.getElementsByName("deacuerdo");
    // Recorremos todos los valores del radio button para encontrar el
    // seleccionado
    for(var i=0;i<porNombre.length;i++)
    {
        if(porNombre[i].checked)
            resultado=porNombre[i].value;
    }

    document.getElementById("resultado").innerHTML=" \
        Por Nombre: "+resultado;
}

		
//RadiobuttonsCreation

function createRadioElement( name, checked ) {
	   var radioInput;
	   try {
	        var radioHtml = '<input type="radio" name="' + name + '"';
	        if ( checked ) {
	            radioHtml += ' checked="checked"';
	        }
	        radioHtml += '/>';
	        radioInput = document.createElement(radioHtml);
	    } catch( err ) {
	        radioInput = document.createElement('input');
	        radioInput.setAttribute('type', 'radio');
	        radioInput.setAttribute('name', name);
	        if ( checked ) {
	            radioInput.setAttribute('checked', 'checked');
	        }
	    }
	    return radioInput;}
	
	
function showLoading(){
	
	$("#chart_label").css("visibility", "hidden");
	$("#loading_div").css("visibility", "visible");
	
}