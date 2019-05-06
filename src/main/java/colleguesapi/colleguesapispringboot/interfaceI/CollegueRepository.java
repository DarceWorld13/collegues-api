package colleguesapi.colleguesapispringboot.interfaceI;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import colleguesapi.colleguesapispringboot.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, String> {
	
	
	List<Collegue>findByNom(String nomRecherche);
	
	Optional<Collegue> findByMatricule(String matricule);
	
	@Query("select c from Collegue c where c.email = :email")
	Collegue findByEmail(@Param("email") String email); 
	
	

	
	
	 

}
