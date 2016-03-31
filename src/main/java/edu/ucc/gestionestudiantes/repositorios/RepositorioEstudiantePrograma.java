package edu.ucc.gestionestudiantes.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Programa;

public interface RepositorioEstudiantePrograma extends CrudRepository<EstudiantePrograma, Integer>{
	public EstudiantePrograma findByEstudianteAndPrograma(Estudiante E, Programa P);
	
//	public boolean findByEstudianteAndPrograma(Estudiante E, Programa P);

}
