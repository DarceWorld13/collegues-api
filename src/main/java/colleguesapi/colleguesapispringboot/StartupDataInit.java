package colleguesapi.colleguesapispringboot;


import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.interfaceI.CollegueRepository;


@Component
public class StartupDataInit {
	

	
	 @Autowired
	    CollegueRepository collegueRepo;
	 
	    // La méthode init va être invoquée au démarrage de l'application.
	    @EventListener(ContextRefreshedEvent.class)
	    public void init() {

	       Collegue collegue1 = new Collegue(); 
	       collegue1.setNom("dem");
	       collegue1.setEmail("amadou@sfr.fr");
	       collegue1.setMatricule("a32");
	       collegue1.setDateDeNaissance(LocalDate.of(1998, Month.AUGUST, 03));
	       collegue1.setPhotoUrl("http://facebook.com");
	       collegue1.setPrenoms("amadou");
	       
	       Collegue collegue2 = new Collegue(); 
	       collegue2.setMatricule("a34");
	       collegue2.setNom("dupont");
	       collegue2.setPrenoms("rené");
	       collegue2.setEmail("dupont@sfr.fr");
	       collegue2.setDateDeNaissance(LocalDate.of(1999, Month.JUNE, 3));
	       collegue2.setPhotoUrl("http://tes.com");
	       
	       collegueRepo.save(collegue1); 
	       collegueRepo.save(collegue2);
	    	
	    	
	    	
	    }
	
	
	

}
