package edu.ucc.gestionestudiantes.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.ucc.gestionestudiantes.domain.Estudiante;

public interface RepositorioEstudiante extends CrudRepository<Estudiante, Integer>{
	
	//buscar estudiantes menores de cierta edad
	public List<Estudiante> findByFechaNacimientoAfter(Date fechaConsulta);

}