package edu.ucc.gestionestudiantes.servicios;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.Evento;

public interface ServicioInscripcionEvento {

	EstudianteEvento crearEstudianteEvento(EstudianteEvento nuevoEstudianteEvento);

	void EliminarEstudianteEvento(EstudianteEvento nuevoEstudianteEvento);

	boolean estaInscrito(Estudiante e, Evento p);

	
}
