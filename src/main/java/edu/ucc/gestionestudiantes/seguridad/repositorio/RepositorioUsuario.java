package edu.ucc.gestionestudiantes.seguridad.repositorio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;

@Repository
@Qualifier(value = "userRepository")
public interface RepositorioUsuario extends CrudRepository<Usuario, String> {
	public Usuario findByUsername(String username);
	public Usuario findByEmail(String username);
    
   
}