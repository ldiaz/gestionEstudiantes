package edu.ucc.gestionestudiantes.domain;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import edu.ucc.gestionestudiantes.domain.AuxiliarEtapa;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;


@NamedNativeQueries({
@NamedNativeQuery(name = "findByTitleIs",
query="SELECT estudiante.numero_identificacion, "
		+ "estudiante.tipo_documento_identificacion, estudiante.nombre, "
		+ "estudiante.apellido, estudiante.fecha_nacimiento, estudiante.email, "
		+ "estudiante.contrasena, estudiante.estrato, "
		+ "estudiante_programa.etapa "+
"FROM estudiante,estudiante_programa "+ 
"WHERE  estudiante_programa.estudiante = estudiante.numero_identificacion "+
"AND estudiante_programa.programa=? "+
"ORDER BY estudiante.numero_identificacion",
resultClass = Estudiante.class
),
@NamedNativeQuery(name = "queryevento",
query="SELECT estudiante.numero_identificacion, "
		+ "estudiante.tipo_documento_identificacion, estudiante.nombre, "
		+ "estudiante.apellido, estudiante.fecha_nacimiento, estudiante.email, "
		+ "estudiante.contrasena, estudiante.estrato, "
		+ "estudiante_evento.etapa "+
"FROM estudiante,estudiante_evento "+ 
"WHERE  estudiante_evento.estudiante = estudiante.numero_identificacion "+
"AND estudiante_evento.evento=? "+
"ORDER BY estudiante.numero_identificacion",
resultClass = Estudiante.class
)
})

@Entity
public class Estudiante {
	//AuxiliarEtapa ep;
	@Id
    @NotNull(message = "Por favor digite su numero de identificación")
	private int numeroIdentificacion;
	
	@NotEmpty(message = "Por favor digite su nombre")
	private String nombre;
	
	@NotEmpty(message = "Por favor digite su apellido")
	private String apellido;
	
	@NotEmpty(message = "Por favor digite su tipo de documento de identificación")
	private String tipoDocumentoIdentificacion;
	
	@NotNull(message = "Por favor digite su fecha de nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;
	
	@Column(unique=true, name="email")
	@Email	
	@NotEmpty(message = "Por favor digite su correo")
	private String email;
	
	@NotEmpty(message = "Por favor seleccione su estrato")
	private String estrato;
	
	@NotEmpty(message = "Por favor digite su contraseña")
	private String Contrasena;
		
	public Estudiante(){
		
	}

	public Estudiante(int numeroIdentificacion, String nombre, String apellido, String tipoDocumentoIdentificacion, Date fechaNacimiento, String Email, String estrato,  String Contrasena) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.email = Email;
		this.estrato= estrato;
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
	
	
	
	
	
}
