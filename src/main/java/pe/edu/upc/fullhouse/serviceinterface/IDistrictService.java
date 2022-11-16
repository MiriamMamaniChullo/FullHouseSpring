package pe.edu.upc.fullhouse.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.fullhouse.entities.District;

public interface IDistrictService {
	public void insert(District district);
	public List<District> list();
	public void delete(int idDistrict);
	Optional<District> listId(int idDistrict);
	public void update(District district);

}
