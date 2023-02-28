package tn.reclamation.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.Prixinscriptions;


@Repository
public interface PrixinscriptionsRepository extends JpaRepository<Prixinscriptions, Long> {
	@Query("SELECT c FROM  Prixinscriptions c WHERE c.date between :d1 and :d2")
	public Prixinscriptions getPrixInscriptions(@Param("d1") Date fromDate, @Param("d2") Date toDate);
	
	
}
