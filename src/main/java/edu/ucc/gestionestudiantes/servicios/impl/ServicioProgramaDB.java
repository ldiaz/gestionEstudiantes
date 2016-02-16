package edu.ucc.gestionestudiantes.servicios.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.repositorios.RepositorioPrograma;
import edu.ucc.gestionestudiantes.servicios.ServicioPrograma;

@Service
public class ServicioProgramaDB implements ServicioPrograma {
	
	@Autowired
	private RepositorioPrograma repoPrograma;

	@Override
	public Programa buscarPrograma(int idPrograma) {
		// TODO Auto-generated method stub
		return repoPrograma.findOne(idPrograma);
	}

	@Override
	public Programa crearPrograma(Programa nuevoPrograma) {
		// TODO Auto-generated method stub
		return repoPrograma.save(nuevoPrograma);
	}

	@Override
	public Programa actualizarPrograma(int idPrograma, Programa programa) throws Exception {
		// TODO Auto-generated method stub
		Programa p = repoPrograma.findOne(idPrograma);
		if (p != null) {
			if(idPrograma != programa.getNumeroIdentificacion()){
				Programa nuevo = this.buscarPrograma(programa.getNumeroIdentificacion());
				if(nuevo != null){
					
					throw new Exception("Programa "+programa.getNumeroIdentificacion()+" ya existe en el sistema, no se puede atualizar con dicho numero de identificacion");
				}
				
				p.setNumeroIdentificacion(programa.getNumeroIdentificacion());
			}
			p.setNumeroIdentificacion(programa.getNumeroIdentificacion());
			p.setAreaFormacion(programa.getAreaFormacion());
			p.setContacto(programa.getContacto());
			p.setHabilitado(programa.isHabilitado());
			p.setNombre(programa.getNombre());
			p.setPerfilOcupacional(programa.getPerfilOcupacional());
			p.setPerfilProfesional(programa.getPerfilProfesional());
			p.setPropositoFormacion(programa.getPropositoFormacion());
			p.setRequisitos(programa.getRequisitos());
			
			repoPrograma.save(p);
		}else{
			
			throw new Exception("Programa "+idPrograma+" no se encuentra en el sistema");
		}	
		
		return p;
	}

	@Override
	public List<Programa> listarProgramas(int pagina, int cantidadResultados) {
		return (List<Programa>) repoPrograma.findAll();
	}
	
	@Override
	public List<Programa> listarProgramasIns(int pagina, int cantidadResultados) {
		return (List<Programa>) repoPrograma.findByHabilitado(true);
	}

	@Override
	public Programa desHabilitar(int idPrograma) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
