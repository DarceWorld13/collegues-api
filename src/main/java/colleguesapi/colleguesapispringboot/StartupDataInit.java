package colleguesapi.colleguesapispringboot;


import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.interfaceI.CollegueRepository;


@Component
public class StartupDataInit {
	


	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 
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
		       dem.setMotDePasse(passwordEncoder.encode("pass1"));
		       dem.setRoles( Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
		       
		       Collegue tonyFerguson = new Collegue(); 
		       tonyFerguson.setNom("johnny");
		       tonyFerguson.setEmail("jonjones@jones.fr");
		       tonyFerguson.setMatricule("a30");
		       tonyFerguson.setDateDeNaissance(LocalDate.of(2000, Month.DECEMBER, 28));
		       tonyFerguson.setPhotoUrl("https://i.ytimg.com/vi/bdxP2pKRCPI/hqdefault.jpg");
		       tonyFerguson.setPrenoms("Bones Jones");
		       tonyFerguson.setMotDePasse(passwordEncoder.encode("pass2"));
		       tonyFerguson.setRoles(Arrays.asList("ROLE_USER"));
		       
		       Collegue mcgregor = new Collegue(); 
		       mcgregor.setNom("mcgregor");
		       mcgregor.setEmail("mcgregor@sfr.fr");
		       mcgregor.setMatricule("a31");
		       mcgregor.setDateDeNaissance(LocalDate.of(1988, Month.DECEMBER, 20));
		       mcgregor.setPhotoUrl("https://i2-prod.mirror.co.uk/incoming/article7429038.ece/ALTERNATES/s1200/Conor-McGregor.jpg");
		       mcgregor.setPrenoms("Conor");
		       mcgregor.setMotDePasse(passwordEncoder.encode("pass3"));
		       mcgregor.setRoles(Arrays.asList("ROLE_USER"));
		       
		       Collegue dupont = new Collegue(); 
		       dupont.setMatricule("a33");
		       dupont.setNom("dupont");
		       dupont.setPrenoms("rené");
		       dupont.setEmail("dupont@sfr.fr");
		       dupont.setDateDeNaissance(LocalDate.of(1999, Month.JUNE, 3));
		       dupont.setPhotoUrl("https://c.stocksy.com/a/Nhm800/z9/2093825.jpg?1550271847");
		       dupont.setMotDePasse(passwordEncoder.encode("pass4"));
		       dupont.setRoles(Arrays.asList("ROLE_USER"));
		       
		       
		       collegueRepo.save(dem); 
		       collegueRepo.save(tonyFerguson);
		       collegueRepo.save(dupont); 
		       collegueRepo.save(mcgregor); 
	    	
	    	
	    	
	    }
	
	
	

}
