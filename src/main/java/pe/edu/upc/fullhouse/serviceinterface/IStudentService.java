package pe.edu.upc.fullhouse.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.fullhouse.entities.Student;

public interface IStudentService {
	public void insert(Student student);
	List<Student> list();
	public void delete(int idStudent);
	Optional<Student> listId(int idStudent);
	public void update(Student student);
}
