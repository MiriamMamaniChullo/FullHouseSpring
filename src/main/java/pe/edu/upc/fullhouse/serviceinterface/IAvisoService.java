package pe.edu.upc.fullhouse.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.fullhouse.entities.Aviso;

public interface IAvisoService {

	public void insert(Aviso aviso);
	
	public List<Aviso> list();
	
	public void delete(int idAviso);
	
	Optional<Aviso> listId(int idAviso);
	
	public void update(Aviso aviso);
}
