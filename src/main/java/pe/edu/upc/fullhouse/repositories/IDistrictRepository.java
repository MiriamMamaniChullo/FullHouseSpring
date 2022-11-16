package pe.edu.upc.fullhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.fullhouse.entities.District;

@Repository
public interface IDistrictRepository extends JpaRepository<District, Integer> {

	
}
