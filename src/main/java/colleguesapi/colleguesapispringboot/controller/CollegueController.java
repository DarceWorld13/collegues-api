package colleguesapi.colleguesapispringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.entite.CollegueAModifier;
import colleguesapi.colleguesapispringboot.entite.CollegueService;
import colleguesapi.colleguesapispringboot.exception.CollegueInvalideException;

@RestController
@RequestMapping("/collegues")
public class CollegueController {
	
	//permet  de nous instancier notre objet CollegueService 
	@Autowired
	private CollegueService colService; 
	
	//1----API - Recherche de collègues par nom

	@RequestMapping(method = RequestMethod.GET)
	public List<String> trouverNom(@RequestParam("nom") String nomSaisiDansRequete) {
		
		//on crée une liste vide pour pouvoir stocker la liste de matricule, car notre methode renvoie une liste de String 
		 List<String> matriculeTrouve = new ArrayList<>(); 
		 
		 //on retrouve toute notre liste de collègues trouvée en instanciant collègue service via l'appel de méthode rechercherparNom en entrant en paramètre 
		List<Collegue> listeColleguesTrouves = colService.rechercherParNom(nomSaisiDansRequete);
		
		//on itère sur toute la liste pour pouvoir ajouter dans notre liste de matricule les matricules trouvées
		for (Collegue collegue : listeColleguesTrouves) {
			
			matriculeTrouve.add(collegue.getMatricule()); 
		}
		
		//on retrourne enfin notre liste de string de notre matricule trouvée
		return matriculeTrouve; 
				
    }
	
	
	// 2-----API - Informations d'un collègue
	
		//Récupérer une information dans le chemin de la requête avec le @pathvariable

	    @RequestMapping(path = "/{matricule}", method = RequestMethod.GET)
	    public Collegue trouverMatricule(@PathVariable String matricule) throws Exception {
	    	
	    	
	    	Collegue colleguefound = colService.rechercherParMatricule(matricule); 
	    	
			return colleguefound;	
	    
	    }
	    
	  // 3--------API - Création d'un collègue
	    
	 // Récupérer un objet Collègue au format JSON 
	    
	    @RequestMapping( method = RequestMethod.POST)
	    public Collegue create(@RequestBody Collegue collegueAjouter) {
	    	
	    	
	    	Collegue nouveau = colService.sauvegarderCollegue(collegueAjouter);
	    	
	    	return nouveau; 
	    
	    }
	    
	   /// 4------------API - Mise à jour d'un collègue
	    
	    
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
	  
	}

	
	
	

