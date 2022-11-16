package pe.edu.upc.fullhouse.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.fullhouse.entities.Room;
import pe.edu.upc.fullhouse.repositories.IRoomRepository;
import pe.edu.upc.fullhouse.serviceinterface.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService{

	@Autowired
	private IRoomRepository roomRepository;
	
	@Override
	public void insert(Room room) {
		roomRepository.save(room);
		
	}

	@Override
	public List<Room> list() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	@Override
	public void delete(int idRoom) {
		// TODO Auto-generated method stub
		roomRepository.deleteById(idRoom);
	}

	@Override
	public Optional<Room> listId(int idRoom) {
		// TODO Auto-generated method stub
		return roomRepository.findById(idRoom);
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		roomRepository.save(room);
	}

}
