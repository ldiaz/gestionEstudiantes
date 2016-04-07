package edu.ucc.gestionestudiantes.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.Evento;

public interface ServicioEvento {
	
	public Evento buscarEvento(int idEvento);
	
	public Evento crearEvento(Evento nuevoEvento);
	
	public Evento actualizarEvento(int idEvento, Evento Evento) throws Exception;
	
	public List<Evento> listarEvento(int pagina, int cantidadResultados);
	
	public List<Evento> listarEventosIns(int pagina, int cantidadResultados);
	
	public Evento desHabilitar(int idEvento) throws Exception;

	@Query(nativeQuery=true)
	public List<Estudiante> listarEventoEstudiante(Integer idEvento);
    
	@Query(nativeQuery=true)
	public List<EstudianteEvento> listarEstudianteEventoEtapa(Integer idP);

	public EstudianteEvento actualizarEstudianteEven(Estudiante est, Evento even, int etapa) throws Exception;

	
}
