package edu.ucc.gestionestudiantes.seguridad.repositorio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ucc.gestionestudiantes.seguridad.modelo.RolUsuario;

@Repository
@Qualifier(value = "rolRepository")
public interface RepositorioRolUsuario extends CrudRepository<RolUsuario, Long> {
	public RolUsuario findBynombreRol(String nombreRol);

}
