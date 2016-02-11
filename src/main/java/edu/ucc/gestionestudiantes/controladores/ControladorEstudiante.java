package edu.ucc.gestionestudiantes.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.seguridad.modelo.RolUsuario;
import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;
import edu.ucc.gestionestudiantes.seguridad.service.InterfazServicioUsuario;
import edu.ucc.gestionestudiantes.servicios.ServicioEstudiante;
import org.springframework.validation.BindingResult;

@Controller
public class ControladorEstudiante {
	
	@Autowired
	private ServicioEstudiante servEstudiante;
	
	@Autowired
	private InterfazServicioUsuario servicioUsuario;

	@RequestMapping(value="estudiante/nuevo", method=RequestMethod.GET)
	public String formularioEstudiante(Model modelo){
		
		System.out.println("Obteniendo el formulario");
		modelo.addAttribute("estudiante", new Estudiante());
		
		return "formularioEstudiante"; 
	}
	

	@RequestMapping(value="estudiantesss/crear", method=RequestMethod.POST)
	public String crearEstudiante(@ModelAttribute @Valid Estudiante estudiante, BindingResult bindingResult, Model modelo){
		
		System.out.println("posteando desde el formulario");
		estudiante.setNombre(estudiante.getNombre());
		
		servEstudiante.crearEstudiante(estudiante);
		
		Usuario u = Usuario.createUsuario(estudiante.getEmail(), estudiante.getEmail(), estudiante.getContrasena());
		
		RolUsuario r1 = new RolUsuario();
		r1.setNombreRol("Estudiante");
		r1.setUsuario(u);
		u.getRoles().add(r1);
		servicioUsuario.guardarUsuario(u);
		servicioUsuario.guardarRolUsuario(r1);
		
		modelo.addAttribute("usuario", u);

		return "vistaEstudiante";
	}
	
	@RequestMapping(value="estudiantes", method=RequestMethod.GET)
	public String listarEstudiantes(Model modelo){
		
		List<Estudiante> listado = servEstudiante.listarEstudiantes(1, 5);
		
		modelo.addAttribute("estudiantes", listado);
		
		
		return "listadoEstudiantes";
	}
	
	@RequestMapping(value="estudiantes/{idEstudiante}/editar", method=RequestMethod.GET)
	public String editarEstudiante(@PathVariable Integer idEstudiante, Model modelo){
		
		System.out.println("idEstudiante= "+ idEstudiante);
		
		Estudiante e = servEstudiante.buscarEstudiante(idEstudiante);
		
		modelo.addAttribute("estudiante", e);
		
		return "formularioEstudianteActualizar";
	}
	
	@RequestMapping(value="estudiantes/{idEstudiante}/actualizar", method=RequestMethod.POST)
	public String actualizarEstudiante(@PathVariable Integer idEstudiante, @ModelAttribute Estudiante estudiante, Model modelo){
		
		Estudiante e = null;
		
		try {
			e = servEstudiante.actualizarEstudiante(idEstudiante, estudiante);
		} catch (Exception er) {
			modelo.addAttribute("error", er.getMessage());
			e = estudiante;
		}
		
		modelo.addAttribute("estudiante", e);
		
		return "vistaEstudiante";
	}
	
	@RequestMapping(value="estudiantes/{idEstudiante}/eliminar", method=RequestMethod.GET)
	public String eliminarEstudiante(@PathVariable Integer idEstudiante, Model modelo){
		
		Estudiante e = null;
		try {
			e = servEstudiante.eliminarEstudiante(idEstudiante);
		} catch (Exception e1) {
			modelo.addAttribute("error", e1.getMessage());
			e = new Estudiante();
		}
		
		modelo.addAttribute("estudiante", e);
		
		return "vistaEstudiante";
	}
	
}
