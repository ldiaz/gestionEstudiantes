package edu.ucc.gestionestudiantes.seguridad.service;

import edu.ucc.gestionestudiantes.seguridad.modelo.RolUsuario;
import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;

public interface InterfazServicioUsuario {

	public Usuario guardarUsuario(Usuario nuevo);
	
	public RolUsuario guardarRolUsuario(RolUsuario nuevoRol);
	
	public Usuario cargarUsuario(String userName);

}
