package edu.ucc.gestionestudiantes.servicios.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudianteEvento;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Evento;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEstudianteEvento;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEstudiantePrograma;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEvento;
import edu.ucc.gestionestudiantes.servicios.ServicioEvento;

@Service
public class ServicioEventoDB implements ServicioEvento {
	
	@Autowired
	private RepositorioEstudianteEvento repoEstudianteEven;
	
	@PersistenceContext
    private EntityManager manager;
	
	@Autowired
	private RepositorioEvento repoEvento;

	@Override
	public Evento buscarEvento(int idEvento) {
		// TODO Auto-generated method stub
		return repoEvento.findOne(idEvento);
	}

	@Override
	public Evento crearEvento(Evento nuevoEvento) {
		// TODO Auto-generated method stub
		return repoEvento.save(nuevoEvento);
	}

	@Override
	public Evento actualizarEvento(int idEvento, Evento Evento) throws Exception {
		// TODO Auto-generated method stub
		Evento p = repoEvento.findOne(idEvento);
		if (p != null) {
			if(idEvento != Evento.getNumeroIdentificacion()){
				Evento nuevo = this.buscarEvento(Evento.getNumeroIdentificacion());
				if(nuevo != null){
					
					throw new Exception("Evento "+Evento.getNumeroIdentificacion()+" ya existe en el sistema, no se puede atualizar con dicho numero de identificacion");
				}
				
				p.setNumeroIdentificacion(Evento.getNumeroIdentificacion());
			}
			p.setNumeroIdentificacion(Evento.getNumeroIdentificacion());
			p.setAreaFormacion(Evento.getAreaFormacion());
			p.setContacto(Evento.getContacto());
			p.setHabilitado(Evento.isHabilitado());
			p.setNombre(Evento.getNombre());
			p.setPerfilOcupacional(Evento.getPerfilOcupacional());
			p.setPerfilProfesional(Evento.getPerfilProfesional());
			p.setPropositoFormacion(Evento.getPropositoFormacion());
			p.setRequisitos(Evento.getRequisitos());
			
			repoEvento.save(p);
		}else{
			
			throw new Exception("Evento "+idEvento+" no se encuentra en el sistema");
		}	
		
		return p;
	}

	
	@Override
	public List<Evento> listarEvento(int pagina, int cantidadResultados) {
		return (List<Evento>) repoEvento.findAll();
	}
	
	@Override
	public List<Evento> listarEventosIns(int pagina, int cantidadResultados) {
		return (List<Evento>) repoEvento.findByHabilitado(true);
	}

	@Override
	public Evento desHabilitar(int idEvento) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> listarEventoEstudiante(Integer idEvento) {
		List<Estudiante> estudiante= manager.createNamedQuery("queryevento", Estudiante.class)
				.setParameter(1, idEvento)
               .getResultList();
           return estudiante;
		
	}
	@Override
	  public List<EstudianteEvento> listarEstudianteEventoEtapa(Integer idP) {
		 
		  List<EstudianteEvento> estudianteEvento = manager.createNamedQuery("queryeventop", EstudianteEvento.class)
				  .setParameter(1, idP)
               .getResultList();
           return estudianteEvento;
	  }

	@Override
	public EstudianteEvento actualizarEstudianteEven(Estudiante est, Evento even, int etapa) throws Exception {
   EstudianteEvento EE = repoEstudianteEven.findByEstudianteAndEvento(est, even);
  
	System.out.println("21212121"+EE);
		if (EE != null) {
			EE.setEtapa(etapa);			
			
			repoEstudianteEven.save(EE);
		}else{
			
			throw new Exception("No es posible asignar etapa");
		}	
		
		return EE;
	}

	
	

}
