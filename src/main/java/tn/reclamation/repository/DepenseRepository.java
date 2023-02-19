package tn.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.Depenses;

@Repository
public interface DepenseRepository  extends JpaRepository<Depenses, Long>{

}
