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
import tn.reclamation.service.ReclamationService;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
@Autowired
ReclamationService reclamationService;


@PostMapping("/add-reclamation")
@ResponseBody
public Reclamation addReclamation(@RequestBody Reclamation r)
{
	return  reclamationService.ajouterReclamation(r);

}


@GetMapping("/listReclamations")
@ResponseBody
public List<Reclamation> listReclamations(){
	return reclamationService.ListReclamations();
}

@DeleteMapping("/deleteReclamation/{idReclamation}")
@ResponseBody
public void deleteReclamation(@PathVariable("idReclamation") Long idReclamation){
	 reclamationService.supprimerReclamation(idReclamation);
}
@PutMapping("/modifierReclamation/{idReclamation}")
@ResponseBody
public void modifierReclamation(@RequestBody Reclamation r,@PathVariable("idReclamation") Long idReclamation){
	 reclamationService.updateReclamation(r,idReclamation);
}

@GetMapping("/getReclamation/{idReclamation}")
@ResponseBody
public Reclamation getReclamationByiD(@PathVariable("idReclamation") Long idReclamation){
	return reclamationService.getReclamationById(idReclamation);
}


}
