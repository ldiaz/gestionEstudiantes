package edu.ucc.gestionestudiantes.servicios;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Programa;

public interface ServicioInscripcionPrograma {

	EstudiantePrograma crearEstudiantePrograma(EstudiantePrograma nuevoEstudiantePrograma);

	void EliminarEstudiantePrograma(EstudiantePrograma nuevoEstudiantePrograma);
	
	boolean estaInscrito(Estudiante e, Programa p);
	
}
