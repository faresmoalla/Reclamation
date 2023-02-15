package tn.reclamation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.reclamation.entities.Reclamation;
import tn.reclamation.repository.ReclamationRepository;

@Service
public class ReclamationService {
@Autowired
ReclamationRepository reclamationRepository;


public Reclamation ajouterReclamation(Reclamation r) {
	return reclamationRepository.save(r);
	
}

public List<Reclamation> ListReclamations(){
	return reclamationRepository.findAll();
}


public void supprimerReclamation(Long idReclamation) {
	Reclamation r = reclamationRepository.findById(idReclamation).orElse(null);
	
	reclamationRepository.delete(r);
}
	
public void updateReclamation(Reclamation reclamation, Long idReclamation) {
	
	Reclamation rec= reclamationRepository.findById(idReclamation).orElse(null);	
	
	rec.setIdRec(idReclamation);
	rec.setContenuRec(reclamation.getContenuRec());
	rec.setType(reclamation.getType());
	rec.setSendingDate(reclamation.getSendingDate());
	reclamationRepository.save(rec);
	
}	


public Reclamation getReclamationById(Long idReclamation) {
	return reclamationRepository.getById(idReclamation);
}

	
}
