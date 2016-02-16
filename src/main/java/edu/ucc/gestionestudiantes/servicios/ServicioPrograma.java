package edu.ucc.gestionestudiantes.servicios;

import java.util.List;

import edu.ucc.gestionestudiantes.domain.Programa;

public interface ServicioPrograma {
	
	public Programa buscarPrograma(int idPrograma);
	
	public Programa crearPrograma(Programa nuevoPrograma);
	
	public Programa actualizarPrograma(int idPrograma, Programa programa) throws Exception;
	
	public List<Programa> listarProgramas(int pagina, int cantidadResultados);
	
	public List<Programa> listarProgramasIns(int pagina, int cantidadResultados);
	
	public Programa desHabilitar(int idPrograma) throws Exception;

}
