package tn.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.Response;


@Repository
public interface ResponseRepository extends JpaRepository<Response, Long>{

}
