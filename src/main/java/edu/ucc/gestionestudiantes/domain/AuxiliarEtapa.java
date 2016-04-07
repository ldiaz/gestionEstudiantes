package edu.ucc.gestionestudiantes.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;


/*@NamedNativeQuery(name = "Prueba",
query="SELECT estudiante.numero_identificacion, "
		+ "estudiante.tipo_documento_identificacion, estudiante.nombre, "
		+ "estudiante.apellido, estudiante.fecha_nacimiento, estudiante.email, "
		+ "estudiante.contrasena, estudiante.estrato, "
		+ "estudiante_programa.etapa "+
"FROM estudiante,estudiante_programa "+ 
"WHERE  estudiante_programa.estudiante = estudiante.numero_identificacion "+
"AND estudiante_programa.programa=?",
resultClass = AuxiliarEtapa.class
)*/

public class AuxiliarEtapa {
	
	
	private int numeroIdentificacion;
	
	private String nombre;
	
	private String apellido;
	
	private String tipoDocumentoIdentificacion;
	
	private Date fechaNacimiento;
	
	private String email;
	
	private String estrato;
	
	private String Contrasena;
	
	private int Etapa;
	
	private int idPrograma;
		
	public int getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public AuxiliarEtapa(){
		
	}

	public AuxiliarEtapa(int numeroIdentificacion, String nombre, String apellido, String tipoDocumentoIdentificacion, Date fechaNacimiento, String Email, String estrato,  String Contrasena, int Etapa, int idPrograma) {
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
		this.idPrograma= idPrograma;
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
