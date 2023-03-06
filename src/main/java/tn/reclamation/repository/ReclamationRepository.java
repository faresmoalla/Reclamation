package tn.reclamation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
	
	
	@Query("SELECT c FROM Reclamation c WHERE c.sendingDate = :d1 ")
	public List<Reclamation> getReclamationBYdate(@Param("d1") Date d1);
}
