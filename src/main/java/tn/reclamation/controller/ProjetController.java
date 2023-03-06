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
import tn.reclamation.entities.Projet;
import tn.reclamation.service.ProjetService;

@RestController
@RequestMapping("/projets")
public class ProjetController {
@Autowired
ProjetService projetService;
	

@PostMapping("/add-Projet")
@ResponseBody
public Projet addProjet(@RequestBody Projet r)
{
	return  projetService.ajouterProjet(r);

}


@GetMapping("/listProjet")
@ResponseBody
public List<Projet> listProjet(){
	return projetService.ListProjet();
}

@DeleteMapping("/deleteProjet/{idProjet}")
@ResponseBody
public void deleteProjet(@PathVariable("idProjet") Long idProjet){
	projetService.supprimerProjet(idProjet);
}


@PutMapping("/modifierProjet/{idProjet}")
@ResponseBody
public void modifierProjet(@RequestBody Projet r,@PathVariable("idProjet") Long idProjet){
	projetService.updateProjet(r,idProjet);
}	
	
}
