package tn.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.ServiceFinancier;


@Repository
public interface ServiceFinancierRepository extends JpaRepository<ServiceFinancier, Long> {

}
