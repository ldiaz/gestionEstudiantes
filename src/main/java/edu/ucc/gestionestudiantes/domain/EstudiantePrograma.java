package edu.ucc.gestionestudiantes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EstudiantePrograma {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	
	@OneToOne
	private Programa programa;	
	
	@OneToOne
	private Estudiante estudiante;
	
	
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
	
	public EstudiantePrograma(Programa programa, Estudiante estudiante){
		this.programa = programa;
		this.estudiante = estudiante;
	}
	
	
	
}
