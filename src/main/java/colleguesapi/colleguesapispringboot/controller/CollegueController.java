package colleguesapi.colleguesapispringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
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
	
	//1----API - Recherche de collègues par nom

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
	
	
	// 2-----API - Informations d'un collègue
	
		//Récupérer une information dans le chemin de la requête avec le @pathvariable

	    @RequestMapping(path = "/{matricule}", method = RequestMethod.GET)
	    public Collegue trouverMatricule(@PathVariable String matricule) throws Exception {
	    	
	    	
	    	Collegue matriculefound = colService.rechercherParMatricule(matricule); 
	    	
			return matriculefound;	
	    
	    }
	    
	    //3---------API - Création d'un collègue
	
	    public Collegue ajouterUnCollegue(Collegue collegueAAjouter) {
	    	
	    	
	    	//Collegue nouveauCollegue = new Collegue(matricule, nom, prenoms, email, dateDeNaissance, photoUrl);
			

	        // TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
	        // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
	        // TODO Vérifier que la photoUrl commence bien par `http`
	        // TODO Vérifier que la date de naissance correspond à un age >= 18
	        // TODO Si une des règles ci-dessus n'est pas valide, générer une exception :
	        // `CollegueInvalideException`.


	        // TODO générer un matricule pour ce collègue (`UUID.randomUUID().toString()`)

	        // TODO Sauvegarder le collègue
	    	
	    	
	    	
	    	return collegueAAjouter;
	    }
	
	  
	}

	
	
	

