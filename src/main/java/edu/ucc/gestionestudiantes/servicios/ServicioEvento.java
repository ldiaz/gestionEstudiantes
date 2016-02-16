package edu.ucc.gestionestudiantes.servicios;

import java.util.List;

import edu.ucc.gestionestudiantes.domain.Evento;

public interface ServicioEvento {
	
	public Evento buscarEvento(int idEvento);
	
	public Evento crearEvento(Evento nuevoEvento);
	
	public Evento actualizarEvento(int idEvento, Evento Evento) throws Exception;
	
	public List<Evento> listarEvento(int pagina, int cantidadResultados);
	
	public List<Evento> listarEventosIns(int pagina, int cantidadResultados);
	
	public Evento desHabilitar(int idEvento) throws Exception;

}
