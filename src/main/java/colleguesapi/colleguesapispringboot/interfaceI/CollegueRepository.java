package colleguesapi.colleguesapispringboot.interfaceI;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import colleguesapi.colleguesapispringboot.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, String> {
	
	
	List<Collegue>findByNom(String nomRecherche);
	
	Optional<Collegue> findByMatricule(String matricule);
	
	
	
	
	 

}
