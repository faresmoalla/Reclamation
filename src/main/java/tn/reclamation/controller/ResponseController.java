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
import tn.reclamation.entities.Response;
import tn.reclamation.service.ReclamationService;
import tn.reclamation.service.ResponseService;

@RestController
@RequestMapping("/response")

public class ResponseController {
	@Autowired
	ResponseService  responseService;

	@GetMapping("/listResponses")
	@ResponseBody
	public List<Response> listResponses(){
		return responseService.getAllResponses();
	}
	
	
	@PostMapping("/add-response/{idReclamation}")
	@ResponseBody
	public void addResponse(@RequestBody Response r,@PathVariable("idReclamation") Long idReclamation)
	{
		  responseService.addResponse(r,idReclamation);

	}
	
	
	@DeleteMapping("/deleteResponse/{idResponse}")
	@ResponseBody
	public void deleteReclamation(@PathVariable("idResponse") Long idResponse){
		responseService.supprimerResponse(idResponse);
	}

	
	@PutMapping("/modifierResponse/{idResponse}")
	@ResponseBody
	public void modifierResponse(@RequestBody Response r,@PathVariable("idResponse") Long idResponse){
		responseService.updateResponse(r,idResponse);
	}
	
	@PutMapping("/getResponsesByReclamation/{idReclamation}")
	@ResponseBody
	public List<Response> getResponsesByReclamation(@PathVariable("idReclamation") Long idReclamation){
		 return responseService.getResponsesByReclamation(idReclamation);
	}
	

}
