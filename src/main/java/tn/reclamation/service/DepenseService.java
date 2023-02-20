package tn.reclamation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.reclamation.entities.Depenses;
import tn.reclamation.entities.Reclamation;
import tn.reclamation.repository.DepenseRepository;

@Service
public class DepenseService {
@Autowired
DepenseRepository depenseRepository;


public Depenses ajouterDepenses(Depenses r) {
	
	return depenseRepository.save(r);
	
}

public List<Depenses> ListDepenses(){
	return depenseRepository.findAll();
}


public void supprimerDepenses(Long idDepenses) {
	Depenses r = depenseRepository.findById(idDepenses).orElse(null);
	
	depenseRepository.delete(r);
}
	
public void updateDepenses(Depenses depenses, Long idDepenses) {
	
	Depenses dep= depenseRepository.findById(idDepenses).orElse(null);	
	
	dep.setIdDepense(idDepenses);
	dep.setConsommationeau(depenses.getConsommationeau());
	dep.setConsommationelectricite(depenses.getConsommationelectricite());
	dep.setMaintenanceRestaurant(depenses.getMaintenanceRestaurant());
	dep.setSalaireProf(depenses.getSalaireProf());
	depenseRepository.save(dep);
	
}	


public Depenses getDepensesById(Long idDepenses) {
	return depenseRepository.findById(idDepenses).orElse(null);	
}







}
