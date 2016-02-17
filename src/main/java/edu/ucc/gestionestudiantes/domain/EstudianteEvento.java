package edu.ucc.gestionestudiantes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EstudianteEvento {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	
	@OneToOne
	private Evento evento;
	
	@OneToOne
	private Estudiante estudiante;
	
	
	public int getId() {
		return Id;
	}	
	public void setId(int id) {
		Id = id;
	}	
		
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public EstudianteEvento(){
		
	}
	
	public EstudianteEvento(Evento evento, Estudiante estudiante){
		this.evento = evento;
		this.estudiante = estudiante;
	}
	
	
	
}
