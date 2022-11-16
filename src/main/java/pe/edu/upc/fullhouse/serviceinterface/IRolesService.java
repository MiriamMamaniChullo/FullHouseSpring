package pe.edu.upc.fullhouse.serviceinterface;

import java.util.List;

import pe.edu.upc.fullhouse.entities.Roles;

public interface IRolesService {
	public void insert(Roles r);
	
	List<Roles> list();

}