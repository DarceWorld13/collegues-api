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

	    	 Collegue dem = new Collegue(); 
		       dem.setNom("dem");
		       dem.setEmail("amadou@sfr.fr");
		       dem.setMatricule("a32");
		       dem.setDateDeNaissance(LocalDate.of(1998, Month.AUGUST, 03));
		       dem.setPhotoUrl("https://www.bjpenn.com/wp-content/uploads/2017/12/DCcry.jpg");
		       dem.setPrenoms("amadou");
		       
		       Collegue tonyFerguson = new Collegue(); 
		       tonyFerguson.setNom("dem");
		       tonyFerguson.setEmail("tony@sfr.fr");
		       tonyFerguson.setMatricule("a30");
		       tonyFerguson.setDateDeNaissance(LocalDate.of(2000, Month.DECEMBER, 28));
		       tonyFerguson.setPhotoUrl("http://tonyferguson.com");
		       tonyFerguson.setPrenoms("Tony");
		       
		       Collegue mcgregor = new Collegue(); 
		       mcgregor.setNom("mcgregor");
		       mcgregor.setEmail("mcgregor@sfr.fr");
		       mcgregor.setMatricule("a31");
		       mcgregor.setDateDeNaissance(LocalDate.of(1988, Month.DECEMBER, 20));
		       mcgregor.setPhotoUrl("http://mcgregor.com");
		       mcgregor.setPrenoms("Conor");
		       
		       Collegue dupont = new Collegue(); 
		       dupont.setMatricule("a33");
		       dupont.setNom("dupont");
		       dupont.setPrenoms("rené");
		       dupont.setEmail("dupont@sfr.fr");
		       dupont.setDateDeNaissance(LocalDate.of(1999, Month.JUNE, 3));
		       dupont.setPhotoUrl("http://tes.com");
		       
		       collegueRepo.save(dem); 
		       collegueRepo.save(tonyFerguson);
		       collegueRepo.save(dupont); 
		       collegueRepo.save(mcgregor); 
	    	
	    	
	    	
	    }
	
	
	

}
