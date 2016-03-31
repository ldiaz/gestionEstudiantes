package edu.ucc.gestionestudiantes.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEstudiantePrograma;
import edu.ucc.gestionestudiantes.servicios.ServicioInscripcionPrograma;

@Service
public class ServicioInscripcionProgramaDB implements ServicioInscripcionPrograma{
	
	@Autowired
	private RepositorioEstudiantePrograma repoEstudiantePrograma;

	@Override
	public EstudiantePrograma crearEstudiantePrograma(EstudiantePrograma nuevoEstudiantePrograma) {
		
		return repoEstudiantePrograma.save(nuevoEstudiantePrograma);
	}
	
	@Override
	public void EliminarEstudiantePrograma(EstudiantePrograma nuevoEstudiantePrograma) {
		
		repoEstudiantePrograma.delete(nuevoEstudiantePrograma);
	}
	
	@Override
	public boolean estaInscrito(Estudiante e, Programa p) {
		EstudiantePrograma EP = repoEstudiantePrograma.findByEstudianteAndPrograma(e, p);
		if (EP != null)
			return true;
		else
			return false; 
	}
}
