package edu.ucc.gestionestudiantes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ucc.gestionestudiantes.domain.Evento;
import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.servicios.ServicioEvento;
import edu.ucc.gestionestudiantes.servicios.ServicioPrograma;


@Controller
public class controladorGeneralReportes{
	
	@Autowired
	private ServicioPrograma servPrograma;
	
	@Autowired
	private ServicioEvento servEvento;
	
	@RequestMapping(value="reporteGeneralPrograma",method=RequestMethod.GET)
	public String vistaGeneralPrograma(Model modelo){
	List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteGeneralPrograma";	
	}
	
		
	@RequestMapping(value="reporteHomologantes",method=RequestMethod.GET)
	public String vistaHomologantes(Model modelo){
	List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteHomologantes";
		}
	
	@RequestMapping(value="reporteEstrato",method=RequestMethod.GET)
	public String vistaEstrato(Model modelo){
			
		System.out.println("Obteniendo el formulario");
		return "reporteEstrato";
		}
	
	@RequestMapping(value="reporteGeneralEvento",method=RequestMethod.GET)
	public String vistaGeneralEvento(Model modelo){
	List<Evento> listado = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteGeneralEvento";	
	}
	
	@RequestMapping(value="reporteEtapaPreinscripcionEvento",method=RequestMethod.GET)
	public String vistareporteEtapaPreinscripcionEvento(Model modelo){
	List<Evento> listado = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteEtapaEvento";	
	}
	
	@RequestMapping(value="reporteEtapaPreinscripcionPrograma",method=RequestMethod.GET)
	public String vistareporteEtapaPrograma(Model modelo){
		List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteEtapaPrograma";	
	}
	
	@RequestMapping(value="reporteProgramasEventosInhabilitados",method=RequestMethod.GET)
	public String vistareporteProgramasEventosInhabilitados(Model modelo){
		List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
        
		List<Evento> listado1 = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado1);
		
		System.out.println("Obteniendo el formulario");
		return "reporteProgramasEventosInhabilitados";	
	}
}
