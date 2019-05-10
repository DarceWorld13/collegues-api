package colleguesapi.colleguesapispringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.entite.CollegueAModifier;
import colleguesapi.colleguesapispringboot.entite.CollegueAModifier2;
import colleguesapi.colleguesapispringboot.entite.CollegueService;
import colleguesapi.colleguesapispringboot.exception.CollegueInvalideException;

@RestController
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueController {
	
	@Autowired
	private CollegueService colService; 
	

	
	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET)
	public List<String> trouverNom(@RequestParam("nom") String nomSaisiDansRequete) {
		
		 List<String> matriculeTrouve = new ArrayList<>(); 
		  
		List<Collegue> listeColleguesTrouves = colService.rechercherParNom(nomSaisiDansRequete);
		
	
		for (Collegue collegue : listeColleguesTrouves) {
			
			matriculeTrouve.add(collegue.getMatricule()); 
		}
	
		return matriculeTrouve; 
				
    }
	
		@Secured("ROLE_USER")
	    @RequestMapping(path = "/{matricule}", method = RequestMethod.GET)
	    public Collegue trouverMatricule(@PathVariable String matricule) throws Exception {
	    	
	    	Collegue colleguefound = colService.rechercherParMatricule(matricule); 
	    	
			return colleguefound;	
	    
	    }
	    
	 	
	@Secured("ROLE_ADMIN")
	    @RequestMapping(method = RequestMethod.POST)
	    public Collegue create(@RequestBody Collegue collegueAjouter) {
	    	
	    	
	    	Collegue nouveau = colService.sauvegarderCollegue(collegueAjouter);
	    	
	    	return nouveau; 
	    
	    }
	    
	@Secured("ROLE_ADMIN")
	   @RequestMapping(path = "/{matricule}", method = RequestMethod.PATCH)
	    public Collegue modifierEmailPhoto(@PathVariable String matricule, @RequestBody CollegueAModifier c) {
	    	
	   if( c.getEmail() != null) {
		   Collegue amadou =  colService.modifierEmail(matricule, c.getEmail()); 
		   return amadou;
	   }
	   
	  if(c.getPhotoUrl() !=null) {
	    	 Collegue amadou =  colService.modifierPhoto(matricule, c.getPhotoUrl());
	    	 return amadou;
	    }

	    throw new CollegueInvalideException("héé");
	     

	   }

	@Secured("ROLE_USER")
	@RequestMapping( path = "/verif", method = RequestMethod.GET)
    public boolean validationEmail(@RequestParam("email")  String email ) {
		
		 return colService.emailExistant(email); 
	   }
	
	@Secured("ROLE_USER")
	@RequestMapping( path = "/photos", method = RequestMethod.GET)
	public List<CollegueAModifier2> toutesLesPhotos() {
		
		return colService.touverPhoto(); 
	}
	
		   
}
	  
	

	
	
	

