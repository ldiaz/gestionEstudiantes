package edu.ucc.gestionestudiantes.servicios;

import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;

public interface ServicioInscripcionPrograma {

	EstudiantePrograma crearEstudiantePrograma(EstudiantePrograma nuevoEstudiantePrograma);

	void EliminarEstudiantePrograma(EstudiantePrograma nuevoEstudiantePrograma);

}
