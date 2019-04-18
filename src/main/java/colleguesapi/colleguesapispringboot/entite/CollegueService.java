package colleguesapi.colleguesapispringboot.entite;

import java.time.LocalDate;
import java.time.Month;
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

import colleguesapi.colleguesapispringboot.exception.CollegueInvalideException;
import colleguesapi.colleguesapispringboot.exception.CollegueNonTrouveException;

public class CollegueService {

	Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {

		String a = UUID.randomUUID().toString();
		String b = UUID.randomUUID().toString();
		String c = UUID.randomUUID().toString();
		String d = UUID.randomUUID().toString();
		
		data.put(a,new Collegue(a, "Dupont", "Vincent", "dupont@example.fr", LocalDate.of(1990, Month.JANUARY, 03), "https://fakeimg.pl/250x100/"));
		data.put(b, new Collegue(b, "Delièvre", "Alex", "delievre@example.fr", LocalDate.of(1996, Month.DECEMBER, 03),"https://fakeimg.pl/250x100/"));
		data.put(c, new Collegue(c, "DEM", "Amadou", "dem@example.fr", LocalDate.of(1993, Month.FEBRUARY, 05), "https://fakeimg.pl/250x100/"));
		
	//	this.sauvegarderCollegue(new Collegue(d, "Mcgregor", "Conor", "conormcgregor@mcgregor.com", LocalDate.of(1989, Month.APRIL, 03), "http://google.fr"));

	}

	public List<Collegue> rechercherParNom(String nomRecherche) {

		// on crée une liste de collègue trouvée
		List<Collegue> listeColleguesTrouves = new ArrayList<Collegue>();

		// on trouve toute la liste
		Collection<Collegue> listeCollegues = this.data.values();

		// on boucle sur toute la liste pour ajouter le collègue trouvé dans notre liste
		// vide

		for (Collegue collegue : listeCollegues) {

			if (collegue.getNom().equals(nomRecherche)) {
				listeColleguesTrouves.add(collegue);
			}

		}
		// on retourne ensuite la liste alimentée
		return listeColleguesTrouves;

	}

	public Collegue rechercherParMatricule(String matriculeRecherche) throws Exception {
		
		//on va simplement récupérer le matricule du collègue directement à travers le get 

		Collegue collegue1 = this.data.get(matriculeRecherche);
		//lorsque le matricule est trouvé, on retourne notre collègue, sinon on génère une exception

		if (collegue1 == null) {

			throw new CollegueNonTrouveException("ce matricule n'existe pas");
		} else {

			return collegue1;
		}

	}
	
	public Collegue sauvegarderCollegue(Collegue individu) {
		//je crée un matricule 
		String f = UUID.randomUUID().toString();
		//j'ajoute ce matricule à mon individu
		individu.setMatricule(f);
		
		if(individu.getNom().length()> 2 &&individu.getEmail().contains("@") && individu.getPhotoUrl().startsWith("http") && (LocalDate.now().getYear()-individu.getDateDeNaissance().getYear()>18)) {
			//ici j'obtiens mon individu qui a son matricule à jour
			data.put(individu.getMatricule(), individu);
			//important 
			return individu;
		}else {
			
			throw new CollegueInvalideException("Ce collègue ne peut être ajouter"); 
		}
	}
	

}
