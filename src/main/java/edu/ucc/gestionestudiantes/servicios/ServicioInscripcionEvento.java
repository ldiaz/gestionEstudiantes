package edu.ucc.gestionestudiantes.servicios;

import edu.ucc.gestionestudiantes.domain.EstudianteEvento;

public interface ServicioInscripcionEvento {

	EstudianteEvento crearEstudianteEvento(EstudianteEvento nuevoEstudianteEvento);

	void EliminarEstudianteEvento(EstudianteEvento nuevoEstudianteEvento);

}
