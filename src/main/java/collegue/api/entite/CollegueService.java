package collegue.api.entite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class CollegueService {

	Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {

		String a = UUID.randomUUID().toString();
		String b = UUID.randomUUID().toString();
		String c = UUID.randomUUID().toString();
		data.put(a,
				new Collegue(a, "Dupont", "Vincent", "dupont@example.fr", "15/06/1990", "https://fakeimg.pl/250x100/"));
		data.put(b, new Collegue(b, "Delièvre", "Alex", "delievre@example.fr", "15/06/1995",
				"https://fakeimg.pl/250x100/"));
		data.put(c, new Collegue(c, "DEM", "Amadou", "dem@example.fr", "15/06/1990", "https://fakeimg.pl/250x100/"));

	}

	public List<Collegue> rechercherParNom(String nomRecherche) {


		//on crée une liste de collègue trouvée
		List<Collegue> listeColleguesTrouves = new ArrayList<Collegue>();
		
		//on trouve toute la liste 
		Collection<Collegue> listeCollegues = this.data.values();
		
		//on boucle sur toute la liste pour ajouter le collègue trouvé dans notre liste vide

		for (Collegue collegue : listeCollegues) {

			if(collegue.getNom().equals(nomRecherche)) {
				listeColleguesTrouves.add(collegue);
			}
			
		}
		//on retourne ensuite la liste alimentée
		return listeColleguesTrouves;

	}

}
