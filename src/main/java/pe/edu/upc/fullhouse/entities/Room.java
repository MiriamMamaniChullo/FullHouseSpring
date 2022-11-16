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
@Table(name = "Room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRoom;
	
	@Column(name = "descpRoom", nullable = false, length = 100)
	private String descpRoom;
	
	@Column(name = "adress", nullable =false , length = 40)
	private String adress;
	
	@ManyToOne
	@JoinColumn(name = "idArrendador")
	private Arrendador arrendador;
	
	@ManyToOne
	@JoinColumn(name = "idDistrict")
	private District distrito;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int idRoom, String descpRoom, String adress, Arrendador arrendador, District distrito) {
		super();
		this.idRoom = idRoom;
		this.descpRoom = descpRoom;
		this.adress = adress;
		this.arrendador = arrendador;
		this.distrito = distrito;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public String getDescpRoom() {
		return descpRoom;
	}

	public void setDescpRoom(String descpRoom) {
		this.descpRoom = descpRoom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public District getDistrito() {
		return distrito;
	}

	public void setDistrito(District distrito) {
		this.distrito = distrito;
	}
	
}

