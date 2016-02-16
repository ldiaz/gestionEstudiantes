package edu.ucc.gestionestudiantes.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numeroIdentificacion;
	
	@NotEmpty(message = "Por favor digite el nombre") 
	private String nombre;
	@NotEmpty(message = "Por favor digite el perfil profesional")
	private String perfilProfesional;
	@NotEmpty(message = "Por favor digite el perfil ocupacional")
	private String perfilOcupacional;
	@NotEmpty(message = "Por favor digite el proposito de la formación")
	private String propositoFormacion;
	@NotEmpty(message = "Por favor digite el área de formación")
	private String areaFormacion;
	@NotEmpty(message = "Por favor digite los requisitos")
	private String requisitos;
	@NotEmpty(message = "Por favor digite el contacto")
	private String contacto;
	
	private boolean habilitado;
	
	
	public Evento(){
		
	}

	public Evento(int numeroIdentificacion,String nombre, String perfilProfesional, String perfilOcupacional, String propositoFormacion, String areaFormacion, String requisitos, String contacto, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
		this.perfilProfesional = perfilProfesional;
		this.perfilOcupacional = perfilOcupacional;
		this.propositoFormacion = propositoFormacion;
		this.areaFormacion = areaFormacion;
		this.requisitos = requisitos;
		this.contacto = contacto;
		this.habilitado = habilitado;
	}
	

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPerfilProfesional() {
		return perfilProfesional;
	}
	public void setPerfilProfesional(String perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	}
	public String getPerfilOcupacional() {
		return perfilOcupacional;
	}
	public void setPerfilOcupacional(String perfilOcupacional) {
		this.perfilOcupacional = perfilOcupacional;
	}
	public String getPropositoFormacion() {
		return propositoFormacion;
	}
	public void setPropositoFormacion(String propositoFormacion) {
		this.propositoFormacion = propositoFormacion;
	}
	public String getAreaFormacion() {
		return areaFormacion;
	}
	public void setAreaFormacion(String areaFormacion) {
		this.areaFormacion = areaFormacion;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getContacto() {
		return contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}