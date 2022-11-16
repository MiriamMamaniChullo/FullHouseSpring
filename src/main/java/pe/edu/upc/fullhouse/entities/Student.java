package pe.edu.upc.fullhouse.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudent;
	
	@Column(name = "nombreStudent")
	private String nombreStudent;
	
	@Column(name = "dniStudent", nullable = false, unique = true)
	private String dniStudent;
	
	@Column(name = "edadStudent", nullable = false)
	private String edadStudent;
	
	@Column(name = "numStudent", nullable = false)
	private String numStudent;

	@Column(name = "correoStudent", nullable = false, length = 47)
	private String correoStudent;
	
	@Column(name = "userStudent", nullable = false, length = 47)
	private String userStudent;
	
	@Column(name = "passStudent", nullable = false, length = 47)
	private String passStudent;
	
	@ManyToOne
	@JoinColumn(name = "idUniversidad")
	private Universidad universidad;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int idStudent, String nombreStudent, String dniStudent, String edadStudent, String numStudent,
			String correoStudent, String userStudent, String passStudent, Universidad universidad) {
		super();
		this.idStudent = idStudent;
		this.nombreStudent = nombreStudent;
		this.dniStudent = dniStudent;
		this.edadStudent = edadStudent;
		this.numStudent = numStudent;
		this.correoStudent = correoStudent;
		this.userStudent = userStudent;
		this.passStudent = passStudent;
		this.universidad = universidad;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNombreStudent() {
		return nombreStudent;
	}

	public void setNombreStudent(String nombreStudent) {
		this.nombreStudent = nombreStudent;
	}

	public String getDniStudent() {
		return dniStudent;
	}

	public void setDniStudent(String dniStudent) {
		this.dniStudent = dniStudent;
	}

	public String getEdadStudent() {
		return edadStudent;
	}

	public void setEdadStudent(String edadStudent) {
		this.edadStudent = edadStudent;
	}

	public String getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(String numStudent) {
		this.numStudent = numStudent;
	}

	public String getCorreoStudent() {
		return correoStudent;
	}

	public void setCorreoStudent(String correoStudent) {
		this.correoStudent = correoStudent;
	}

	public String getUserStudent() {
		return userStudent;
	}

	public void setUserStudent(String userStudent) {
		this.userStudent = userStudent;
	}

	public String getPassStudent() {
		return passStudent;
	}

	public void setPassStudent(String passStudent) {
		this.passStudent = passStudent;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

}
