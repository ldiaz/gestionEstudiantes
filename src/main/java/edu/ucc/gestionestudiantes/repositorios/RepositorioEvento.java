package edu.ucc.gestionestudiantes.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.ucc.gestionestudiantes.domain.Evento;

public interface RepositorioEvento extends CrudRepository<Evento, Integer>{
	//buscar estudiantes menores de cierta edad
	public List<Evento> findByNombre(String nombre);
	
	public List<Evento> findByHabilitado(boolean estado);

}
