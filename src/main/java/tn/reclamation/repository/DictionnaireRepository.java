package tn.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.DictionnaireBadWords;


@Repository
public interface DictionnaireRepository extends JpaRepository<DictionnaireBadWords, Long> {

	
	
}