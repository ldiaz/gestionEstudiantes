package edu.ucc.gestionestudiantes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class EstudiantePrograma {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	private int IdPrograma;	
	private int IdEstudiante;
	
	
	public int getId() {
		return Id;
	}	
	public void setId(int id) {
		Id = id;
	}	
	public int getIdEstudiante() {
		return IdEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		IdEstudiante = idEstudiante;
	}	
	public int getIdPrograma() {
		return IdPrograma;
	}
	public void setIdPrograma(int idPrograma) {
		IdPrograma = idPrograma;
	}
	
	public EstudiantePrograma(){
		
	}
	
	public EstudiantePrograma(int idPrograma, int idEstudiante){
		this.IdPrograma = idPrograma;
		this.IdEstudiante = idEstudiante;
	}
	
	
	
}
