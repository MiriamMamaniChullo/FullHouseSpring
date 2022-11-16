package pe.edu.upc.fullhouse.serviceinterface;

import java.util.List;

import pe.edu.upc.fullhouse.entities.Usuarios;

public interface IUsuariosService {
	public void insert(Usuarios u);
	
	List<Usuarios> list();
}
