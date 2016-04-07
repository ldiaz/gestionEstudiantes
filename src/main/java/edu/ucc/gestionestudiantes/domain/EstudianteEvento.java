package edu.ucc.gestionestudiantes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;

@NamedNativeQuery(name = "queryeventop",
query="SELECT estudiante_evento.id, "
		+ "estudiante_evento.estudiante, "
		+ "estudiante_evento.evento, "
		+ "estudiante_evento.etapa "+
"FROM estudiante_evento "+ 
"WHERE estudiante_evento.evento=? "+
"ORDER BY estudiante_evento.estudiante",
resultClass = EstudianteEvento.class
)

@Entity
public class EstudianteEvento {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
	
	@OneToOne
	private Evento evento;
	
	@OneToOne
	private Estudiante estudiante;
	
	private int etapa;
	
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
	public int getEtapa() {
		return etapa;
	}
	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}
	
	public EstudianteEvento(Evento evento, Estudiante estudiante){
		this.evento = evento;
		this.estudiante = estudiante;
		this.etapa = 1;
	}
	
	
	
}
