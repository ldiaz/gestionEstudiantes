package edu.ucc.gestionestudiantes.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Estudiante {
	
	@Id
    //GeneratedValue(strategy=GenerationType.AUTO)
	private int numeroIdentificacion;
	
	@NotEmpty(message = "Por favor digite su nombre")
	private String nombre;
	
	@NotEmpty(message = "Por favor digite su apellido")
	private String apellido;
	
	@NotEmpty(message = "Por favor digite su tipo de documento de identificación")
	private String tipoDocumentoIdentificacion;
	
	@NotEmpty(message = "Por favor digite su fecha de nacimiento")
	private Date fechaNacimiento;
	
	@NotEmpty(message = "Por favor digite su correo")
	private String Email;
	
	@NotEmpty(message = "Por favor digite su contraseña")
	private String Contrasena;
		
	public Estudiante(){
		
	}

	public Estudiante(int numeroIdentificacion, String nombre, String apellido, String tipoDocumentoIdentificacion, Date fechaNacimiento, String Email, String Contrasena) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.Email = Email;
		this.Contrasena = Contrasena;
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
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	
	
	
	
	
}
