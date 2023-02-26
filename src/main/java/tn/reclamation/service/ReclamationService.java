package tn.reclamation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.reclamation.entities.DictionnaireBadWords;
import tn.reclamation.entities.Reclamation;
import tn.reclamation.repository.DictionnaireRepository;
import tn.reclamation.repository.ReclamationRepository;

@Service
public class ReclamationService {
@Autowired
ReclamationRepository reclamationRepository;
@Autowired
DictionnaireRepository badwordsRepo;

public void ajouterReclamation(Reclamation r) {
	List<String> badwords1 = new ArrayList<String>();
	List<DictionnaireBadWords> badwords = badwordsRepo.findAll();
	for (DictionnaireBadWords bd : badwords) {
		badwords1.add(bd.getWord());
	}
	
	
	if (verif(r) == 1) {
		
	
	r.setEtat("non traitée");
	 reclamationRepository.save(r);
	}
	else if(verif(r) == 0) {
		r.setContenuRec("*******");
		 reclamationRepository.save(r);

	}

	
}
public int verif(Reclamation c) {

	for (DictionnaireBadWords d : badwordsRepo.findAll()) {

		if (c.getContenuRec().toLowerCase().contains(d.getWord().toLowerCase()) || c.getContenuRec() == null
				|| c.getContenuRec().length() == 0) {
			return 0;
		} else {
			return 1;
		}

	}
	return 2;

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
	return reclamationRepository.findById(idReclamation).orElse(null);	
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
