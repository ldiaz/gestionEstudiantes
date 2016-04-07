package edu.ucc.gestionestudiantes.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Evento;
import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEstudianteEvento;
import edu.ucc.gestionestudiantes.servicios.ServicioInscripcionEvento;

@Service
public class ServicioInscripcionEventoDB implements ServicioInscripcionEvento{
	
	@Autowired
	private RepositorioEstudianteEvento repoEstudianteEvento;

	@Override
	public EstudianteEvento crearEstudianteEvento(EstudianteEvento nuevoEstudianteEvento) {
		
		return repoEstudianteEvento.save(nuevoEstudianteEvento);
	}
	
	@Override
	public void EliminarEstudianteEvento(EstudianteEvento nuevoEstudianteEvento) {
		
		repoEstudianteEvento.delete(nuevoEstudianteEvento);
	}
	@Override
	public boolean estaInscrito(Estudiante e, Evento p) {
		EstudianteEvento EP = repoEstudianteEvento.findByEstudianteAndEvento(e, p);
		if (EP != null)
			return true;
		else
			return false; 

	}
}
