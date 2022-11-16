package pe.edu.upc.fullhouse.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Interes")
public class Interes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInteres;

	@ManyToOne
	@JoinColumn(name = "idStudent")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "idDistrict")
	private District distrito;
	
	@Column(name = "medidaInteres", nullable = false)
	private String medidaInteres;
	
	@ManyToOne
	@JoinColumn(name = "idAviso")
	private Aviso aviso;
	
	public Interes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Interes(int idInteres, Student student, District distrito, String medidaInteres, Aviso aviso) {
		super();
		this.idInteres = idInteres;
		this.student = student;
		this.distrito = distrito;
		this.medidaInteres = medidaInteres;
		this.aviso = aviso;
	}

	public int getIdInteres() {
		return idInteres;
	}

	public void setIdInteres(int idInteres) {
		this.idInteres = idInteres;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public District getDistrito() {
		return distrito;
	}

	public void setDistrito(District distrito) {
		this.distrito = distrito;
	}

	public String getMedidaInteres() {
		return medidaInteres;
	}

	public void setMedidaInteres(String medidaInteres) {
		this.medidaInteres = medidaInteres;
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}

}
