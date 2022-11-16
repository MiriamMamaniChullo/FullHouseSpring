package pe.edu.upc.fullhouse.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Aviso")
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAviso;
	
	@Column(name = "preHabitacion", length=60, nullable=false)
	private double preHabitacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaPublicacion", nullable=false)
	private Date fechaPublicacion;
	
	@ManyToOne
	@JoinColumn(name = "idHabitacion")
	private Room room;

	public Aviso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aviso(int idAviso, double preHabitacion, Date fechaPublicacion, Room room) {
		super();
		this.idAviso = idAviso;
		this.preHabitacion = preHabitacion;
		this.fechaPublicacion = fechaPublicacion;
		this.room = room;
	}

	public int getIdAviso() {
		return idAviso;
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public double getPreHabitacion() {
		return preHabitacion;
	}

	public void setPreHabitacion(double preHabitacion) {
		this.preHabitacion = preHabitacion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
