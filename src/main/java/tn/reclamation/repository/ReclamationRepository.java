package tn.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
