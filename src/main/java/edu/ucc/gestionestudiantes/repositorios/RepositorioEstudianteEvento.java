package edu.ucc.gestionestudiantes.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.ucc.gestionestudiantes.domain.EstudianteEvento;

public interface RepositorioEstudianteEvento extends CrudRepository<EstudianteEvento, Integer>{

}
