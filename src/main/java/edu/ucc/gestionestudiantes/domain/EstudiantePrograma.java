package edu.ucc.gestionestudiantes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;


@NamedNativeQuery(name = "findByTitleIsEP",
query="SELECT estudiante_programa.id, "
		+ "estudiante_programa.homologa, estudiante_programa.estudiante, "
		+ "estudiante_programa.programa, estudiante_programa.etapa "+
"FROM estudiante_programa "+ 
"WHERE estudiante_programa.programa=? "+
"ORDER BY estudiante_programa.estudiante",
resultClass = EstudiantePrograma.class
)

@Entity
public class EstudiantePrograma {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	
	@OneToOne
	private Programa programa;	
	
	@OneToOne
	private Estudiante estudiante;
	
	private boolean homologa;
	
	private int etapa;
	
	
	public int getEtapa() {
		return etapa;
	}
	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}
	public int getId() {
		return Id;
	}	
	public void setId(int id) {
		Id = id;
	}
	
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public boolean isHomologa() {
		return homologa;
	}
	public void setHomologa(boolean homologa) {
		this.homologa = homologa;
	}
	
	
//	public int getIdEstudiante() {
//		return IdEstudiante;
//	}
//	public void setIdEstudiante(int idEstudiante) {
//		IdEstudiante = idEstudiante;
//	}	
//	public int getIdPrograma() {
//		return IdPrograma;
//	}
//	public void setIdPrograma(int idPrograma) {
//		IdPrograma = idPrograma;
//	}
	
	public EstudiantePrograma(){
		
	}
	
	public EstudiantePrograma(Programa programa, Estudiante estudiante, boolean homologa){
		this.programa = programa;
		this.estudiante = estudiante;
		this.homologa = homologa;
		this.etapa = 1;
	}
	
	
	
}
