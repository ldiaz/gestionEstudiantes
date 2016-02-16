package edu.ucc.gestionestudiantes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EstudianteEvento {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	private int IdEvento;	
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
	public int getIdEvento() {
		return IdEvento;
	}
	public void setIdPrograma(int idEvento) {
		IdEvento = idEvento;
	}
	
	public EstudianteEvento(){
		
	}
	
	public EstudianteEvento(int idEvento, int idEstudiante){
		this.IdEvento = idEvento;
		this.IdEstudiante = idEstudiante;
	}
	
	
	
}
