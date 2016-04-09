package edu.ucc.gestionestudiantes.seguridad.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.seguridad.modelo.RolUsuario;
import edu.ucc.gestionestudiantes.seguridad.modelo.Usuario;
import edu.ucc.gestionestudiantes.seguridad.repositorio.RepositorioRolUsuario;
import edu.ucc.gestionestudiantes.seguridad.repositorio.RepositorioUsuario;

@Service
@Qualifier("customUserDetailsService")
public class ServicioUsuario implements UserDetailsService, InterfazServicioUsuario{
    @Autowired
    private RepositorioUsuario userRepository;
    
    @Autowired
    private RepositorioRolUsuario rolRepository;
    
    
    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        Usuario user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);

    }

    private User buildUserForAuthentication(Usuario user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<RolUsuario> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (RolUsuario userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getNombreRol()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }

	@Override
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		
		return userRepository.save(nuevoUsuario);
	}
	
	@Override
	public RolUsuario guardarRolUsuario(RolUsuario nuevoRol){
		return rolRepository.save(nuevoRol);		
	}

	@Override
	public Usuario cargarUsuario(String userName) {
		Usuario user = userRepository.findByUsername(userName);
		return user;
	}
	
	public Usuario eliminarUsuario(String userName) throws Exception{
		Usuario u = userRepository.findByUsername(userName);
		
		if (u != null) {
			rolRepository.delete(u.getRoles());
			userRepository.delete(u);
		}else{
			
			throw new Exception("Usuario "+userName+" no se encuentra en el sistema");
		}	
		
		return u;
	}
	
	
    
}

