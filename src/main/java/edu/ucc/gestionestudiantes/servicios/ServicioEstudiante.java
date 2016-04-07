package edu.ucc.gestionestudiantes.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;


import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Evento;
import edu.ucc.gestionestudiantes.domain.Programa;

public interface ServicioEstudiante {
	
	public Estudiante buscarEstudiante(int idEstudiante);
	
	public Estudiante buscarPorCorreo(String correo);
	
	public Estudiante crearEstudiante(Estudiante nuevoEstudiante);
	
	public Estudiante actualizarEstudiante(int idEstudiante, Estudiante estudiante) throws Exception;
	
	public List<Estudiante> listarEstudiantes(int pagina, int cantidadResultados);
	
	public Estudiante eliminarEstudiante(int idEstudiante) throws Exception;

	@Query(nativeQuery=true)
	public List<Estudiante> listarEstudiantePrograma(Integer id);
	
	@Query(nativeQuery=true)
	public List<EstudiantePrograma> listarEstudianteProgramaEtapa(Integer idP);
	
	public EstudiantePrograma actualizarEstudianteProg(Estudiante Est, Programa Prog, int Etapa) throws Exception;

	
	
//	@Query(nativeQuery=true)
//	public List<AuxiliarEtapa> listarAuxiliarEtapa(Integer id);
//	
	/*@Query(nativeQuery=true)
	public List<Object[]> listarEstudianteProgramaOb(Integer id);*/

	
	

	
}
