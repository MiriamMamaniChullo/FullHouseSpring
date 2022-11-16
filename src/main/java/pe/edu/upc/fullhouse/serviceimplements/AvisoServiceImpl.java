package pe.edu.upc.fullhouse.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.fullhouse.entities.Aviso;
import pe.edu.upc.fullhouse.repositories.IAvisoRepository;
import pe.edu.upc.fullhouse.serviceinterface.IAvisoService;

@Service
public class AvisoServiceImpl implements IAvisoService{

	@Autowired
	private IAvisoRepository avisoRepository;

	@Override
	public void insert(Aviso aviso) {
		// TODO Auto-generated method stub
		avisoRepository.save(aviso);
	}

	@Override
	public List<Aviso> list() {
		// TODO Auto-generated method stub
		return avisoRepository.findAll();
	}

	@Override
	public void delete(int idAviso) {
		// TODO Auto-generated method stub
		avisoRepository.deleteById(idAviso);
	}

	@Override
	public Optional<Aviso> listId(int idAviso) {
		// TODO Auto-generated method stub
		return avisoRepository.findById(idAviso);
	}

	@Override
	public void update(Aviso aviso) {
		// TODO Auto-generated method stub
		avisoRepository.save(aviso);
	}
	
	
	
}
