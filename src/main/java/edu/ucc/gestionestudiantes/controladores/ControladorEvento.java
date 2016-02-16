package edu.ucc.gestionestudiantes.controladores;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.Evento;
import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;
import edu.ucc.gestionestudiantes.seguridad.service.ServicioUsuario;
import edu.ucc.gestionestudiantes.servicios.ServicioEstudiante;
import edu.ucc.gestionestudiantes.servicios.ServicioEvento;
import edu.ucc.gestionestudiantes.servicios.impl.ServicioInscripcionEventoDB;

@Controller
public class ControladorEvento {
	@Autowired
	private ServicioEvento servEvento;
	
	@Autowired
	private ServicioEstudiante servEstudiante;
	
	//@Autowired
	private ServicioUsuario servUsuario;
	
	@Autowired
	private ServicioInscripcionEventoDB servInsEvento;
	
	@RequestMapping(value="evento/nuevo", method=RequestMethod.GET)
	public String formularioEvento(Model modelo){
		
		System.out.println("Obteniendo el formulario");
		modelo.addAttribute("evento", new Evento());
		
		return "formularioEvento"; 
	}
	

	@RequestMapping(value="evento/crear", method=RequestMethod.POST)
	public String crearEvento(@ModelAttribute Evento evento, Model modelo){
		
		System.out.println("posteando desde el formulario");
		evento.setNombre(evento.getNombre());
		
		servEvento.crearEvento(evento);

		return "vistaEvento";
	}
	
	@RequestMapping(value="eventos", method=RequestMethod.GET)
	public String listarEvento(Model modelo){
		
		List<Evento> listado = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado);
		
		
		return "listadoEventos";
	}
	

	@RequestMapping(value="eventosInscripcion", method=RequestMethod.GET)
	public String listarEventoInscripcion(Model modelo){
		
		List<Evento> listado = servEvento.listarEventosIns(1, 8);
		modelo.addAttribute("evento", listado);
		
		
		return "listadoEventosInscripcion";
	}
	
	@RequestMapping(value="eventos/{idEvento}/editar", method=RequestMethod.GET)
	public String editarEvento(@PathVariable Integer idEvento, Model modelo){
		
		System.out.println("idEvento= "+ idEvento);
		
		Evento p = servEvento.buscarEvento(idEvento);
		
		modelo.addAttribute("evento", p);
		
		return "formularioEventoActualizar";
	}
	
	@RequestMapping(value="eventos/{idEvento}/inscribir", method=RequestMethod.GET)
	public String inscribirEvento(@PathVariable Integer idEvento, Principal currentUser, Model modelo){
		String nombre = currentUser.getName();
		//Usuario user = servUsuario.cargarUsuario(currentUser.getName());
		Usuario user = servUsuario.cargarUsuario(nombre);
		Estudiante e = servEstudiante.buscarPorCorreo(user.getUsername());
		//Estudiante e = servEstudiante.buscarPorCorreo("cpipe");
		
		System.out.println("idEvento= "+ idEvento);
		System.out.println("idEstudiante= "+ e.getNumeroIdentificacion());
		
		EstudianteEvento EP = new EstudianteEvento(idEvento, e.getNumeroIdentificacion());
		servInsEvento.crearEstudianteEvento(EP);
						
		modelo.addAttribute("estudianteEvento", EP);
		
		return "HomeEstudiante";
	}
	
	@RequestMapping(value="eventos/{idEvento}/actualizar", method=RequestMethod.POST)
	public String actualizarEvento(@PathVariable Integer idEvento, @ModelAttribute Evento evento, Model modelo){
		
		Evento p = null;
		
		try {
			p = servEvento.actualizarEvento(idEvento, evento);
		} catch (Exception er) {
			modelo.addAttribute("error", er.getMessage());
			p = evento;
		}
		
		modelo.addAttribute("evento", p);
		
		return "vistaEvento";
	}
	
	/*
	@RequestMapping(value="Eventos/{idEvento}/eliminar", method=RequestMethod.GET)
	public String eliminarEvento(@PathVariable Integer idEvento, Model modelo){
		
		Evento p = null;
		try {
			p = servEvento.eliminarEstudiante(idEstudiante);
		} catch (Exception e1) {
			modelo.addAttribute("error", e1.getMessage());
			e = new Estudiante();
		}
		
		modelo.addAttribute("estudiante", e);
		
		return "vistaEstudiante";
	}*/
	
}