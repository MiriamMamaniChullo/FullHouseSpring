package pe.edu.upc.fullhouse.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="District")
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDistrict;
	
	@Column(name="nomDistrict", length=48, nullable=false)
	private String nomDistrict;
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}
	public District(int idDistrict, String nomDistrict) {
		super();
		this.idDistrict = idDistrict;
		this.nomDistrict = nomDistrict;
	}
	public int getIdDistrict() {
		return idDistrict;
	}
	public void setIdDistrict(int idDistrict) {
		this.idDistrict = idDistrict;
	}
	public String getNomDistrict() {
		return nomDistrict;
	}
	public void setNomDistrict(String nomDistrict) {
		this.nomDistrict = nomDistrict;
	}

}
