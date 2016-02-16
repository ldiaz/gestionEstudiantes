package edu.ucc.gestionestudiantes.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.ucc.gestionestudiantes.domain.Programa;

public interface RepositorioPrograma extends CrudRepository<Programa, Integer>{
	//buscar estudiantes menores de cierta edad
	public List<Programa> findByNombre(String nombre);
	
	public List<Programa> findByHabilitado(boolean estado);

}
