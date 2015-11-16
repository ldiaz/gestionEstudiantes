package edu.ucc.gestionestudiantes.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Programa {
	@Id
    //GeneratedValue(strategy=GenerationType.AUTO)
	private int numeroIdentificacion;
	private String nombre;
	private String perfilProfesional;
	private String perfilOcupacional;
	private String propositoFormacion;
	private String areaFormacion;
	private String requisitos;
	private String contacto;
	private boolean habilitado;
	
	public Programa(){
		
	}

	public Programa(int numeroIdentificacion,String nombre, String perfilProfesional, String perfilOcupacional, String propositoFormacion, String areaFormacion, String requisitos, String contacto, boolean habilitado) {
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
