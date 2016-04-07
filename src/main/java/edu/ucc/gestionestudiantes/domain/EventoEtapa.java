package edu.ucc.gestionestudiantes.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;



public class EventoEtapa {
	
	
	private int numeroIdentificacion;
	
	private String nombre;
	
	private String apellido;
	
	private String tipoDocumentoIdentificacion;
	
	private Date fechaNacimiento;
	
	private String email;
	
	private String estrato;
	
	private String Contrasena;
	
	private int Etapa;
	
	private int idEvento;
		
	public int getIdEvento() {
		return idEvento;
	}

	public void setIdPrograma(int idEvento) {
		this.idEvento = idEvento;
	}

	public EventoEtapa(){
		
	}

	public EventoEtapa(int numeroIdentificacion, String nombre, String apellido, String tipoDocumentoIdentificacion, Date fechaNacimiento, String Email, String estrato,  String Contrasena, int Etapa, int idEvento) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.email = Email;
		this.estrato= estrato;
		this.Contrasena = Contrasena;
		this.Etapa = Etapa;
		this.idEvento= idEvento;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getTipoDocumentoIdentificacion() {
		return tipoDocumentoIdentificacion;
	}
	public void setTipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String emails) {
		email = emails;
	}
	
	public String getEstrato() {
		return estrato;
	}

	public void setEstrato(String estratos) {
		estrato = estratos;
	}

	
	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public int getEtapa() {
		return Etapa;
	}

	public void setEtapa(int etapa) {
		Etapa = etapa;
	}
}
