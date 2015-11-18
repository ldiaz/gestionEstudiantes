package edu.ucc.gestionestudiantes.seguridad.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ucc.gestionestudiantes.seguridad.modelo.RolUsuario;
import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;
import edu.ucc.gestionestudiantes.seguridad.service.InterfazServicioUsuario;

@Controller
public class ControladorUsuario {
	
	@Autowired
	private InterfazServicioUsuario servicioUsuario;

	@RequestMapping(value="/admin/usuarios/nuevo", method=RequestMethod.GET)
	public String formularioUsuario(Model modelo){
		
		Usuario u = new Usuario();
	
		
		modelo.addAttribute("usuario", u);
		
		return "seguridad/admin/formularioUsuario";
	}

	@RequestMapping(value="/admin/usuarios/crear", method=RequestMethod.POST)
	public String crearUsuario(@ModelAttribute Usuario datosUsuario, Model modelo){
		
		Usuario u = Usuario.createUsuario(datosUsuario.getUsername(), datosUsuario.getEmail(), datosUsuario.getPassword());
		
		RolUsuario r1 = new RolUsuario();
		r1.setNombreRol("Admin");
		u.getRoles().add(r1);
		servicioUsuario.guardarUsuario(u);
		
		modelo.addAttribute("usuario", u);
		
		return "seguridad/admin/detalleUsuario";
	}
}