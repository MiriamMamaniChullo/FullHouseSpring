package pe.edu.upc.fullhouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.fullhouse.entities.Interes;

@Repository
public interface IInteresRepository extends JpaRepository<Interes, Integer> {
	
	@Query(value="SELECT s.nombre_student, i.medida_interes, r.pre_habitacion from interes AS i INNER JOIN aviso AS r ON i.id_aviso = r.id_aviso INNER JOIN student AS s ON i.id_student = s.id_student", nativeQuery = true)
	public List<String[]>interesCategory();
}
