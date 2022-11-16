package pe.edu.upc.fullhouse.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.fullhouse.entities.Universidad;
import pe.edu.upc.fullhouse.repositories.IUniversidadRepository;
import pe.edu.upc.fullhouse.serviceinterface.IUniversidadService;

@Service
public class UniversidadServiceImpl implements IUniversidadService{

	@Autowired
	private IUniversidadRepository universidadRepository;
	
	@Override
	public void insert(Universidad universidad) {
		universidadRepository.save(universidad);
		
	}

	@Override
	public List<Universidad> list() {
		// TODO Auto-generated method stub
		return universidadRepository.findAll();
	}

	@Override
	public void delete(int idUniversidad) {
		// TODO Auto-generated method stub
		universidadRepository.deleteById(idUniversidad);
		
	}

	@Override
	public Optional<Universidad> listId(int idUniversidad) {
		// TODO Auto-generated method stub
		return universidadRepository.findById(idUniversidad) ;
	}

	@Override
	public void update(Universidad universidad) {
		// TODO Auto-generated method stub
		universidadRepository.save(universidad);
		
	}

}
