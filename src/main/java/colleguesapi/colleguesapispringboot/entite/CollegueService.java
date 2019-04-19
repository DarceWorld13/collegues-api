package colleguesapi.colleguesapispringboot.entite;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.cfg.ExtendsQueueEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import colleguesapi.colleguesapispringboot.exception.CollegueInvalideException;
import colleguesapi.colleguesapispringboot.exception.CollegueNonTrouveException;
import colleguesapi.colleguesapispringboot.interfaceI.CollegueRepository;

//transformant en spring bean

@Service
public class CollegueService {


	// outils qui permet de communiquer avec une base de données relationnelle et les infos de la base se trouve dans application.properties
	CollegueRepository pRepo;
	
	

	public CollegueRepository getpRepo() {
		return pRepo;
	}

	public void setpRepo(CollegueRepository pRepo) {
		this.pRepo = pRepo;
	}

	@Autowired 
	public CollegueService(CollegueRepository pRepo) {
		super();
		this.pRepo = pRepo;
	}

	public List<Collegue> rechercherParNom(String nomRecherche) {
		
		List<Collegue> findByNom = pRepo.findByNom(nomRecherche); 
		
			return findByNom; 
				

	}

	public Collegue rechercherParMatricule(String matriculeRecherche) throws Exception {

		Optional<Collegue> one = pRepo.findByMatricule(matriculeRecherche);
		
		return one
				.orElseThrow( ()->new CollegueNonTrouveException() );
		
	}

	public Collegue sauvegarderCollegue(Collegue individu) {
		// je crée un matricule
		String f = UUID.randomUUID().toString();
		// j'ajoute ce matricule à mon individu
		individu.setMatricule(f);

		if (individu.getNom().length() > 2 && individu.getEmail().contains("@")
				&& individu.getPhotoUrl().startsWith("http")
				&& (LocalDate.now().getYear() - individu.getDateDeNaissance().getYear() > 18)) {
			// ici j'obtiens mon individu qui a son matricule à jour
				pRepo.save(individu); 
			// important
			return individu;
		} else {

			throw new CollegueInvalideException("Ce collègue ne peut être ajouter");
		}
	}

public Collegue modifierEmail(String matricule, String email) {
		
		Optional<Collegue> collegueTrouve = pRepo.findByMatricule(matricule);
	
		Collegue c = collegueTrouve.orElseThrow(()-> new CollegueNonTrouveException()); 		
		
		c.setEmail(email);
		return c;  	

	}
	
public Collegue modifierPhoto(String matricule, String photoUrl) {
		
	Optional<Collegue> collegueTrouv = pRepo.findByMatricule(matricule);
	
	Collegue col = collegueTrouv.orElseThrow(()-> new CollegueNonTrouveException()); 		
	
	col.setPhotoUrl(photoUrl);
	return col;  
	}



}
