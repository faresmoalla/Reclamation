package tn.reclamation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.reclamation.entities.Depenses;
import tn.reclamation.entities.Revenus;
import tn.reclamation.entities.ServiceFinancier;
import tn.reclamation.repository.DepenseRepository;
import tn.reclamation.repository.RevenueRepository;
import tn.reclamation.repository.ServiceFinancierRepository;

@Service
public class ServiceFinancierService {
	@Autowired
	ServiceFinancierRepository serviceFinancierRepository;
@Autowired
DepenseRepository depenseRepo;
@Autowired
RevenueRepository revenuRepo;


	public ServiceFinancier ajouterServiceFinancier(ServiceFinancier r) {
		return serviceFinancierRepository.save(r);
		
	}

	public List<ServiceFinancier> ListServiceFinancier(){
		return serviceFinancierRepository.findAll();
	}


	public void supprimerServiceFinancier(Long idServiceFinancier) {
		ServiceFinancier r = serviceFinancierRepository.findById(idServiceFinancier).orElse(null);
		
		serviceFinancierRepository.delete(r);
	}
	
	public void updateServiceFinancier(ServiceFinancier serviceFinancier, Long idServiceFinancier) {
		
		ServiceFinancier sf= serviceFinancierRepository.findById(idServiceFinancier).orElse(null);	
		
		sf.setIdF(idServiceFinancier);
		sf.setDepensesF(serviceFinancier.getDepensesF());
		sf.setConsommationF(serviceFinancier.getConsommationF());
		serviceFinancierRepository.save(sf);
		
	}	
	
	
	public ServiceFinancier getSFbyId(Long idServiceFinancier) {
		return serviceFinancierRepository.findById(idServiceFinancier).orElse(null);	
	}
	
	public float EtatFinance() {
		
		List<Depenses> listdepenses = depenseRepo.findAll();
		List<Revenus> listRevenus = revenuRepo.findAll();
		float sommeDepense=0;
		float sommeRevenus=0;
		
		for(Depenses d :listdepenses) {
			sommeDepense+= d.getConsommationeau()+d.getConsommationelectricite()+d.getMaintenanceRestaurant()+d.getSalaireProf();
	}
	System.out.println(sommeDepense);
		for(Revenus r :listRevenus) {
			sommeRevenus+= r.getAbonnementFoyer()+r.getAbonnementRestaurant()+r.getProjets()+r.getScolariteEtud();
	}
		System.out.println(sommeRevenus);

	return sommeRevenus-sommeDepense;
	
	
}
	
	
	
}