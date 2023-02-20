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

import tn.reclamation.entities.Depenses;
import tn.reclamation.entities.Revenus;
import tn.reclamation.service.DepenseService;
import tn.reclamation.service.RevenueService;

@RestController
@RequestMapping("/revenus")
public class RevenueController {
	@Autowired
	RevenueService revenusService;

@PostMapping("/add-revenus")
@ResponseBody
public Revenus addRevenus(@RequestBody Revenus r)
{
	return  revenusService.ajouterRevenus(r);

}


@GetMapping("/listRevenus")
@ResponseBody
public List<Revenus> listRevenus(){
	return revenusService.ListRevenus();
}

@DeleteMapping("/deleteRevenus/{idRevenus}")
@ResponseBody
public void deleteRevenus(@PathVariable("idRevenus") Long idRevenus){
	revenusService.supprimerRevenus(idRevenus);
}


@PutMapping("/modifierRevenus/{idRevenus}")
@ResponseBody
public void modifierRevenus(@RequestBody Revenus r,@PathVariable("idRevenus") Long idRevenus){
	revenusService.updateRevenus(r,idRevenus);
}

@GetMapping("/getRevenus/{idRevenus}")
@ResponseBody
public Revenus getRevenusByiD(@PathVariable("idRevenus") Long idRevenus){
	return revenusService.getrevenusServiceById(idRevenus);
}	
	
	
}
