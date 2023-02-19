package tn.reclamation.service;

import java.util.ArrayList;
import java.util.Date;
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
	r.setEtat("non traitée");
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
	rec.setEtat("non traitée");
	rec.setIdRec(idReclamation);
	rec.setContenuRec(reclamation.getContenuRec());
	rec.setType(reclamation.getType());
	rec.setSendingDate(reclamation.getSendingDate());
	reclamationRepository.save(rec);
	
}	


public Reclamation getReclamationById(Long idReclamation) {
	return reclamationRepository.getById(idReclamation);
}


public List<Reclamation> reclamationAujourdhui(){
	Date currentSqlDate = new Date(System.currentTimeMillis());
	List<Reclamation> listrec = reclamationRepository.findAll();
	List<Reclamation> listrec2 = new ArrayList<>();

	for (Reclamation r : listrec) {

		if(r.getSendingDate().getYear()==(currentSqlDate.getYear())&& r.getSendingDate().getMonth()==(currentSqlDate.getMonth())
				&&r.getSendingDate().getDay()==(currentSqlDate.getDay()) ){
			listrec2.add(r);
		}
	}
	return listrec2;
	
}
public int nbrReclamationAujourdhui(){
	Date currentSqlDate = new Date(System.currentTimeMillis());
	List<Reclamation> listrec = reclamationRepository.findAll();
	List<Reclamation> listrec2 = new ArrayList<>();
int nombre = 0;
	for (Reclamation r : listrec) {

		if(r.getSendingDate().getYear()==(currentSqlDate.getYear())&& r.getSendingDate().getMonth()==(currentSqlDate.getMonth())
				&&r.getSendingDate().getDay()==(currentSqlDate.getDay()) ){
			nombre++;
		}
	}
	return nombre;
	
}


	
}
