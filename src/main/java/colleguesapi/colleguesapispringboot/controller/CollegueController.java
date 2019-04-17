package colleguesapi.colleguesapispringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.entite.CollegueService;

@RestController
@RequestMapping("/collegues")
public class CollegueController {
	
	private CollegueService colService = new CollegueService();

	@RequestMapping(method = RequestMethod.GET)
	public List<String> trouverNom(@RequestParam("nom") String nomSaisiDansRequete) {
		
		//on crée une liste vide pour pouvoir stocker la liste de matricule, car notre methode renvoie une liste de String 
		 List<String> matriculeTrouve = new ArrayList<>(); 
		 
		 //on retrouve toute notre liste de collègues trouvée en instanciant collègue serve via l'appel de méthode rechercherparNom en entrant en paramètre notre variable qu'on met en paramètre
		List<Collegue> listeColleguesTrouves = colService.rechercherParNom(nomSaisiDansRequete);
		
		//on intère sur toute la liste pour pouvoir ajouter dans notre liste de matricule les matricules trouvées
		for (Collegue collegue : listeColleguesTrouves) {
			
			matriculeTrouve.add(collegue.getMatricule()); 
		}
		
		//on retrourne enfin notre liste de string de notre matricule trouvée
		return matriculeTrouve; 
				
    }
				
	
	   
	}
	
	
	

