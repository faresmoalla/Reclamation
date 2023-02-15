package tn.reclamation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.reclamation.entities.Reclamation;
import tn.reclamation.entities.ServiceFinancier;
import tn.reclamation.service.ServiceFinancierService;

@RestController
@RequestMapping("/servicefinancier")
public class ServiceFinancierController {
	@Autowired
	ServiceFinancierService serviceFinancierService;


	@PostMapping("/add-servicefinancier")
	@ResponseBody
	public ServiceFinancier addServiceFinancier(@RequestBody ServiceFinancier sf)
	{
		return serviceFinancierService.ajouterServiceFinancier(sf);

	}


	@GetMapping("/listServiceFinancier")
	@ResponseBody
	public List<ServiceFinancier> listReclamations(){
		return serviceFinancierService.ListServiceFinancier();
	}

	@DeleteMapping("/deleteServiceFinancier/{idServiceFinancier}")
	@ResponseBody
	public void deleteServiceFinancier(@PathVariable("idServiceFinancier") Long idServiceFinancier){
		serviceFinancierService.supprimerServiceFinancier(idServiceFinancier);
	}
	@PutMapping("/updateServiceFinancier/{idServiceFinancier}")
	@ResponseBody
	public void updateServiceFinancier(@RequestBody ServiceFinancier sf,@PathVariable("idServiceFinancier") Long idServiceFinancier){
		serviceFinancierService.updateServiceFinancier(sf,idServiceFinancier);
	}
	@GetMapping("/getServiceFinancier/{idServiceFinancier}")
	@ResponseBody
	public ServiceFinancier getServiceFinancier(@PathVariable("idServiceFinancier") Long idServiceFinancier){
		return serviceFinancierService.getSFbyId(idServiceFinancier);
	}
}
