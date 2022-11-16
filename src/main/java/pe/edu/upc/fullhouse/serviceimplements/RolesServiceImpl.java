package pe.edu.upc.fullhouse.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.fullhouse.entities.Roles;
import pe.edu.upc.fullhouse.repositories.IRolesRepository;
import pe.edu.upc.fullhouse.serviceinterface.IRolesService;

@Service
public class RolesServiceImpl implements IRolesService {

	@Autowired
	private IRolesRepository rr;

	@Override
	public void insert(Roles r) {
		// TODO Auto-generated method stub
		rr.save(r);
	}

	@Override
	public List<Roles> list() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

}
