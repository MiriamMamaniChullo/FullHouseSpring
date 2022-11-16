package pe.edu.upc.fullhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.fullhouse.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
