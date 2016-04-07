package edu.ucc.gestionestudiantes.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.Evento;


public interface RepositorioEstudianteEvento extends CrudRepository<EstudianteEvento, Integer>{
	public EstudianteEvento findByEstudianteAndEvento(Estudiante E, Evento V);
}
