
  function RevisarFormulario(formularioEstudiante)
  {
	  if(formularioEstudiante.nombre.value == "") {
	      alert("Error: Debe ingresar el nombre de usuario!");
	      formularioEstudiante.nombre.focus();
	      return false;
	    }
	  
	  if(formularioEstudiante.email.value == "") {
	      alert("Error: Debe ingresar su correo electronico!");
	      formularioEstudiante.email.focus();
	      return false;
	    }
	  
	  if(formularioEstudiante.fechaNacimiento.value == "") {
	      alert("Error: Debe ingresar la fecha de nacimiento!");
	      formularioEstudiante.fechaNacimiento.focus();
	      return false;
	    }
	  
	    re="/^\w+$/";
	    if(!re.test(formularioEstudiante.nombre.value)) {
	      alert("Error: El nombre de usuario solo debe contener letras!");
	      formularioEstudiante.nombre.focus();
	      return false;
	    }
	    
	    if(!re.test(formularioEstudiante.apellido.value)) {
		      alert("Error: El apellido de usuario solo debe contener letras!");
		      formularioEstudiante.apellido.focus();
		      return false;
		    }

	    if(formularioEstudiante.contrasena.value != "" && formularioEstudiante.contrasena.value == formularioEstudiante.contrasena2.value) {
	      if(formularioEstudiante.contrasena.value.length < 6) {
	        alert("Error: Su contraseña debe contener mas de 6 caracteres!");
	        formularioEstudiante.contrasena.focus();
	        return false;
	      }
	      if(formularioEstudiante.contrasena.value == formularioEstudiante.nombre.value) {
	        alert("Error: la contraseña no puede ser igual al nombre de usuario!");
	        formularioEstudiante.contrasena.focus();
	        return false;
	      }
	      re = /[0-9]/;
	      if(!re.test(formularioEstudiante.contrasena.value)) {
	        alert("Error: la contraseña debe contener al menos un numero (0-9)!");
	        formularioEstudiante.contrasena.focus();
	        return false;
	      }
	      re = /[a-z]/;
	      if(!re.test(formularioEstudiante.contrasena.value)) {
	        alert("Error: la contraseña debe contener almenos una letra(a-z)!");
	        formularioEstudiante.contrasena.focus();
	        return false;
	      }
	      re = /[A-Z]/;
	      if(!re.test(formularioEstudiante.contrasena.value)) {
	        alert("Error: la contraseña debe contener almenos una letra mayúscula(A-Z)!");
	        formularioEstudiante.contrasena.focus();
	        return false;
	      }
	    } else {
	      alert("Error: Por favor diligencie su contraseña y verifique que coincida con la confirmación!");
	      formularioEstudiante.contrasena.focus();
	      return false;
	    }

	    alert("Ha completado satisfactoriamente el formulario: " + formularioEstudiante.contrasena.value);
	    return true;

  }
