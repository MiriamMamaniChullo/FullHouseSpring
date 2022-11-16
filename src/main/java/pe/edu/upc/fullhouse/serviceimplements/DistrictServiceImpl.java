package pe.edu.upc.fullhouse.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.fullhouse.entities.District;
import pe.edu.upc.fullhouse.repositories.IDistrictRepository;
import pe.edu.upc.fullhouse.serviceinterface.IDistrictService;

@Service
public class DistrictServiceImpl  implements IDistrictService{

	@Autowired
	private IDistrictRepository districtRepository;
	
	@Override
	public void insert(District district) {
		districtRepository.save(district);
		
	}

	@Override
	public List<District> list() {
		// TODO Auto-generated method stub
		return districtRepository.findAll();
	}

	@Override
	public void delete(int idDistrict) {
		// TODO Auto-generated method stub
		districtRepository.deleteById(idDistrict);
	}

	@Override
	public Optional<District> listId(int idDistrict) {
		// TODO Auto-generated method stub
		return districtRepository.findById(idDistrict);
	}

	@Override
	public void update(District district) {
		// TODO Auto-generated method stub
		districtRepository.save(district);
	}

}
