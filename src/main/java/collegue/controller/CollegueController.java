package collegue.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import collegue.api.entite.Collegue;
import collegue.api.entite.CollegueService;

@RestController
@RequestMapping("/collegues")
public class CollegueController {
	
	

	@RequestMapping(method = RequestMethod.GET)
	public List<String> trouverNom(@RequestParam("nom") String nomSaisiDansRequete) {
		
		 CollegueService colService = new CollegueService();
		 
		 List<String> matriculeTrouve = new ArrayList<>(); 
		 
		List<Collegue> listeColleguesTrouves = colService.rechercherParNom(nomSaisiDansRequete);
		
		for (Collegue collegue : listeColleguesTrouves) {
			
			matriculeTrouve.add(collegue.getMatricule()); 
		}
		
		return matriculeTrouve; 
				
    }
				
	
	   
	}
	
	
	

