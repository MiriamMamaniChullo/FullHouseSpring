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
@Table(name = "Universidad")
public class Universidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUniversidad;

	@Column(name ="fullNameUniversidad",length =48,nullable =false)
	private String fullNameUniversidad;
	
	@ManyToOne
	@JoinColumn(name="distrito")
	private District distrito;

	public Universidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Universidad(int idUniversidad, String fullNameUniversidad, District distrito) {
		super();
		this.idUniversidad = idUniversidad;
		this.fullNameUniversidad = fullNameUniversidad;
		this.distrito = distrito;
	}

	public int getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getFullNameUniversidad() {
		return fullNameUniversidad;
	}

	public void setFullNameUniversidad(String fullNameUniversidad) {
		this.fullNameUniversidad = fullNameUniversidad;
	}

	public District getDistrito() {
		return distrito;
	}

	public void setDistrito(District distrito) {
		this.distrito = distrito;
	}

	

}
