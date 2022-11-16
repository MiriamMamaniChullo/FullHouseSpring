package pe.edu.upc.fullhouse.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.fullhouse.entities.Room;

public interface IRoomService {

	public void insert(Room room);
	
	public List<Room> list();
	
	public void delete(int idRoom);
	
	Optional<Room> listId(int idRoom);
	
	public void update(Room room);
}
