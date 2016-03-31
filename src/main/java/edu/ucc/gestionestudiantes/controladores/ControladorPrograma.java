package edu.ucc.gestionestudiantes.controladores;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;
import edu.ucc.gestionestudiantes.seguridad.service.InterfazServicioUsuario;
import edu.ucc.gestionestudiantes.servicios.ServicioEstudiante;
import edu.ucc.gestionestudiantes.servicios.ServicioInscripcionPrograma;
import edu.ucc.gestionestudiantes.servicios.ServicioPrograma;


@Controller
public class ControladorPrograma {
	
	@Autowired
	private ServicioPrograma servPrograma;
	
	@Autowired
	private ServicioEstudiante servEstudiante;
	
	@Autowired
	private InterfazServicioUsuario servUsuario;
	
	@Autowired
	private ServicioInscripcionPrograma servInsPrograma;

	@RequestMapping(value="programa/nuevo", method=RequestMethod.GET)
	public String formularioPrograma(Model modelo){
		
		System.out.println("Obteniendo el formulario");
		modelo.addAttribute("programa", new Programa());
		
		return "formularioPrograma"; 
	}
	

	@RequestMapping(value="programa/crear", method=RequestMethod.POST)
	public String crearPrograma(@ModelAttribute Programa programa, Model modelo){
		
		System.out.println("posteando desde el formulario");
		programa.setNombre(programa.getNombre());
		
		servPrograma.crearPrograma(programa);

		return "vistaPrograma";
	}
	
	@RequestMapping(value="programas", method=RequestMethod.GET)
	public String listarPrograma(Model modelo){
		
		List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		
		return "listadoProgramas";
	}
	

	@RequestMapping(value="programasInscripcion", method=RequestMethod.GET)
	public String listarProgramaInscripcion(Model modelo){
		
		List<Programa> listado = servPrograma.listarProgramasIns(1, 8);
		modelo.addAttribute("programa", listado);
		
		
		return "listadoProgramasInscripcion";
	}
	
	@RequestMapping(value="programas/{idPrograma}/editar", method=RequestMethod.GET)
	public String editarPrograma(@PathVariable Integer idPrograma, Model modelo){
		
		System.out.println("idPrograma= "+ idPrograma);
		
		Programa p = servPrograma.buscarPrograma(idPrograma);
		
		modelo.addAttribute("programa", p);
		
		return "formularioProgramaActualizar";
	}
	
//	@RequestMapping(value="programas/{idPrograma}/inscribir", method=RequestMethod.GET)
//	public String inscribirPrograma(final HttpServletRequest request, @PathVariable Integer idPrograma, Principal principal, Model modelo){
//		
//		String currentUser = request.getUserPrincipal().getName();
//		
//		Usuario user = servUsuario.cargarUsuario(currentUser);
//		Programa prog = servPrograma.buscarPrograma(idPrograma);
//		
//		Estudiante e = servEstudiante.buscarPorCorreo(user.getUsername());
//		
//		System.out.println("idPrograma= "+ idPrograma);
//		System.out.println("idEstudiante= "+ e.getNumeroIdentificacion());
//		
//		EstudiantePrograma EP = new EstudiantePrograma(prog, e);
//		servInsPrograma.crearEstudiantePrograma(EP);
//						
//		modelo.addAttribute("estudianteprograma", EP);
//		
//		return "Inscrito";
//	}
	
	
	@RequestMapping(value="programas/{idPrograma}/inscribir", method=RequestMethod.GET)
	public String inscribirPrograma(final HttpServletRequest request, @PathVariable Integer idPrograma, Principal principal, Model modelo){
String currentUser = request.getUserPrincipal().getName();
		
		Usuario user = servUsuario.cargarUsuario(currentUser);
		Programa prog = servPrograma.buscarPrograma(idPrograma);
		
		Estudiante e = servEstudiante.buscarPorCorreo(user.getUsername());
		
		if (validaInscripcion(prog, e)){
			return "YaInscrito";		
		}else{			
			System.out.println("idPrograma= "+ idPrograma);
			System.out.println("idEstudiante= "+ e.getNumeroIdentificacion());
			
			EstudiantePrograma EP = new EstudiantePrograma(prog, e, false);
			servInsPrograma.crearEstudiantePrograma(EP);
							
			modelo.addAttribute("estudianteprograma", EP);
			
			return "ConfirmacionInscrito";
		}
	}
	
	@RequestMapping(value="programas/{idPrograma}/homologa", method=RequestMethod.GET)
	public String homologaPrograma(final HttpServletRequest request, @PathVariable Integer idPrograma, Principal principal, Model modelo){
		
		String currentUser = request.getUserPrincipal().getName();
		
		Usuario user = servUsuario.cargarUsuario(currentUser);
		Programa prog = servPrograma.buscarPrograma(idPrograma);
		
		Estudiante e = servEstudiante.buscarPorCorreo(user.getUsername());
		
		if (validaInscripcion(prog, e)){
			return "YaInscrito";		
		}else{			
			System.out.println("idPrograma= "+ idPrograma);
			System.out.println("idEstudiante= "+ e.getNumeroIdentificacion());
			
			EstudiantePrograma EP = new EstudiantePrograma(prog, e, true);
			servInsPrograma.crearEstudiantePrograma(EP);
							
			modelo.addAttribute("estudianteprograma", EP);
			
			return "ConfirmacionInscrito";
		}
	}
	
	@RequestMapping(value="programas/{idPrograma}/actualizar", method=RequestMethod.POST)
	public String actualizarPrograma(@PathVariable Integer idPrograma, @ModelAttribute Programa programa, Model modelo){
		
		Programa p = null;
		
		try {
			p = servPrograma.actualizarPrograma(idPrograma, programa);
		} catch (Exception er) {
			modelo.addAttribute("error", er.getMessage());
			p = programa;
		}
		
		modelo.addAttribute("programa", p);
		
		return "vistaPrograma";
	}
	
	public boolean validaInscripcion(Programa programa, Estudiante estudiante){
		if (servInsPrograma.estaInscrito(estudiante, programa))
			return true;
		else
			return false;
		
	}
	
//	@RequestMapping(value="programas/{idEstudiantePrograma}/confirmar", method=RequestMethod.POST)
//	private String HomeUsuario(Model modelo, EstudiantePrograma EP){		
//		        
//		return "/ConfirmaInscritoPrograma";
//	}
//	
	/*
	@RequestMapping(value="programas/{idPrograma}/eliminar", method=RequestMethod.GET)
	public String eliminarPrograma(@PathVariable Integer idPrograma, Model modelo){
		
		Programa p = null;
		try {
			p = servPrograma.eliminarEstudiante(idEstudiante);
		} catch (Exception e1) {
			modelo.addAttribute("error", e1.getMessage());
			e = new Estudiante();
		}
		
		modelo.addAttribute("estudiante", e);
		
		return "vistaEstudiante";
	}*/
	
}