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
import tn.reclamation.entities.Reclamation;
import tn.reclamation.service.DepenseService;

@RestController
@RequestMapping("/depenses")
public class DepensesController {
@Autowired
DepenseService depensesService;


@PostMapping("/add-depenses")
@ResponseBody
public Depenses addDepenses(@RequestBody Depenses r)
{
	return  depensesService.ajouterDepenses(r);

}


@GetMapping("/listDepenses")
@ResponseBody
public List<Depenses> listDepenses(){
	return depensesService.ListDepenses();
}

@DeleteMapping("/deleteDepenses/{idDepenses}")
@ResponseBody
public void deleteDepenses(@PathVariable("idDepenses") Long idDepenses){
	depensesService.supprimerDepenses(idDepenses);
}


@PutMapping("/modifierDepenses/{idDepenses}")
@ResponseBody
public void modifierDepenses(@RequestBody Depenses r,@PathVariable("idDepenses") Long idDepenses){
	depensesService.updateDepenses(r,idDepenses);
}

@GetMapping("/getDepenses/{idDepenses}")
@ResponseBody
public Depenses getDepensesByiD(@PathVariable("idDepenses") Long idDepenses){
	return depensesService.getDepensesById(idDepenses);
}





}
