package edu.ucc.gestionestudiantes.servicios.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucc.gestionestudiantes.domain.Estudiante;
import edu.ucc.gestionestudiantes.domain.EstudiantePrograma;
import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEstudiante;
import edu.ucc.gestionestudiantes.repositorios.RepositorioEstudiantePrograma;
import edu.ucc.gestionestudiantes.servicios.ServicioEstudiante;

@Service
public class ServicioEstudianteDB implements ServicioEstudiante{
	
	@PersistenceContext
    private EntityManager manager;
	
	@Autowired
	private RepositorioEstudiante repoEstudiante;
	
	@Autowired
	private RepositorioEstudiantePrograma repoEstudianteProg;

	@Override
	public Estudiante buscarEstudiante(int idEstudiante) {
		
		return repoEstudiante.findOne(idEstudiante);
	}
	
	@Override
	public Estudiante buscarPorCorreo(String Correo) {
		
		return repoEstudiante.findByemail(Correo);
	}

	@Override
	public Estudiante crearEstudiante(Estudiante nuevoEstudiante) {
		
		return repoEstudiante.save(nuevoEstudiante);
	}
	
	@Override
	public Estudiante actualizarEstudiante(int idEstudiante, Estudiante estudiante) throws Exception {
		Estudiante e = repoEstudiante.findOne(idEstudiante);
		
		if (e != null) {
			
			if(idEstudiante != estudiante.getNumeroIdentificacion()){
				Estudiante nuevo = this.buscarEstudiante(estudiante.getNumeroIdentificacion());
				if(nuevo != null){
					
					throw new Exception("Estudiante "+estudiante.getNumeroIdentificacion()+" ya existe en el sistema, no se puede atualizar con dicho numero de identificacion");
				}
				
				e.setNumeroIdentificacion(estudiante.getNumeroIdentificacion());
			}

			e.setNombre(estudiante.getNombre());
			e.setApellido(estudiante.getApellido());
			e.setTipoDocumentoIdentificacion(estudiante.getTipoDocumentoIdentificacion());
			
			repoEstudiante.save(e);
		}else{
			
			throw new Exception("Estudiante "+idEstudiante+" no se encuentra en el sistema");
		}	
		
		return e;
	}
	
	@Override
	public EstudiantePrograma actualizarEstudianteProg(Estudiante Est, Programa Prog, int Etapa) throws Exception {
		EstudiantePrograma EP = repoEstudianteProg.findByEstudianteAndPrograma(Est, Prog);
		
		if (EP != null) {
			EP.setEtapa(Etapa);			
			
			repoEstudianteProg.save(EP);
		}else{
			
			throw new Exception("Imposible asignar etapa");
		}	
		
		return EP;
	}

	@Override
	public List<Estudiante> listarEstudiantes(int pagina, int cantidadResultados) {
		
		return (List<Estudiante>) repoEstudiante.findAll();
	}

	
	@Override
	public Estudiante eliminarEstudiante(int idEstudiante) throws Exception {
		Estudiante e = repoEstudiante.findOne(idEstudiante);
		
		if (e != null) {
			repoEstudiante.delete(e);
		}else{
			
			throw new Exception("Estudiante "+idEstudiante+" no se encuentra en el sistema");
		}	
		
		return e;
	}

	//public List<Object[]> byIncidencialimit(int incidencia_id);
	
	 @Override
	  public List<Estudiante> listarEstudiantePrograma(Integer id) {
		  List<Estudiante> estudiante = manager.createNamedQuery("findByTitleIs", Estudiante.class)
				  .setParameter(1, id)
                  .getResultList();
              return estudiante;
	  }
	 
	 @Override
	  public List<EstudiantePrograma> listarEstudianteProgramaEtapa(Integer idP) {
		 
		  List<EstudiantePrograma> estudiantePrograma = manager.createNamedQuery("findByTitleIsEP", EstudiantePrograma.class)
				  .setParameter(1, idP)
                 .getResultList();
             return estudiantePrograma;
	  }

	
	 
//	 @Override
//	  public List<AuxiliarEtapa> listarAuxiliarEtapa(Integer id) {
//		  List<AuxiliarEtapa> auxiliar = manager.createNamedQuery("findByTitleIs", AuxiliarEtapa.class)
//				  .setParameter(1, id)
//                 .getResultList();
//             return auxiliar;
//	  }
	 
	 /* @Override
	  public List<Object[]> listarEstudianteProgramaOb(Integer id) {
		  { List<Object[]> Object = manager.createNamedQuery("findByTitleIs")
				  .setParameter(1, id)
                 .getResultList();             
		  		return Object;
	  }*/

	

}