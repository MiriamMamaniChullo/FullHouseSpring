package pe.edu.upc.fullhouse.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.fullhouse.entities.Usuarios;
import pe.edu.upc.fullhouse.repositories.UsuarioRepository;
import pe.edu.upc.fullhouse.serviceinterface.IUsuariosService;

@Service
public class UsuarioServiceImpl implements IUsuariosService {

	@Autowired
	private UsuarioRepository tR;

	@Override
	public void insert(Usuarios u) {
		// TODO Auto-generated method stub
		tR.save(u);
	}

	@Override
	public List<Usuarios> list() {
		// TODO Auto-generated method stub
		return tR.findAll();
	}

}
