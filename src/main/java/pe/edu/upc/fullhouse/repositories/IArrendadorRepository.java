package pe.edu.upc.fullhouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.fullhouse.entities.Arrendador;

@Repository
public interface IArrendadorRepository extends JpaRepository<Arrendador, Integer> {
	
	@Query(value="select a.nom_arrendador, count(r.descp_room) as Habitaciones, sum(av.pre_habitacion) as Monto from arrendador a join room r on a.id_arrendador=r.id_arrendador join aviso av on r.id_room = av.id_habitacion group by a.nom_arrendador", nativeQuery = true)
	public List<String[]> MontoArrendador();
	
	@Query(value = "SELECT a.nom_arrendador,count(r.id_room),d.nom_district FROM arrendador a JOIN room r ON a.id_arrendador=r.id_arrendador JOIN district d ON d.id_district=r.id_district GROUP BY a.nom_arrendador,d.nom_district", nativeQuery = true)
	public List<String[]> arrendadorDistrito();
	
	
	@Query(value="SELECT r.id_room as Codigo_HabitaciÃ³n,to_char(av.fecha_publicacion,'dd-mm-yyyy')AS Mes_Registro,a.nom_arrendador as nombre_arrendadores FROM arrendador a JOIN room r ON r.id_arrendador=a.id_arrendador JOIN aviso av ON av.id_habitacion=r.id_room WHERE av.fecha_publicacion BETWEEN '20220501' AND '20220531' GROUP BY r.id_room,av.fecha_publicacion,a.nom_arrendador", nativeQuery = true)
	public List<String[]> arrendadorFecha();
}
