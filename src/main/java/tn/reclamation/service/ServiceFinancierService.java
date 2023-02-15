package tn.reclamation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.reclamation.entities.ServiceFinancier;

import tn.reclamation.repository.ServiceFinancierRepository;

@Service
public class ServiceFinancierService {
	@Autowired
	ServiceFinancierRepository serviceFinancierRepository;

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
		return serviceFinancierRepository.getById(idServiceFinancier);
	}
}