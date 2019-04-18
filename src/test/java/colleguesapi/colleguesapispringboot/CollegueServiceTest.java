package colleguesapi.colleguesapispringboot;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.entite.CollegueService;
import colleguesapi.colleguesapispringboot.exception.CollegueInvalideException;

public class CollegueServiceTest {
	
	private static final  Logger LOG = LoggerFactory.getLogger(CollegueServiceTest.class); 
	
	
	@Test
	public void sauvegarderCollegue() {
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue");
		Collegue individuAjoute = new Collegue(x, "Durant", "Leonard", "durant@example.fr", LocalDate.of(1990, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
		
		Assert.assertTrue("le prenom", individuAjoute.getPrenoms().length() >2);	
	}
	
	@Test( expected = CollegueInvalideException.class)
	public void sauvegarderCollegueNomInvalide() {
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue avec un nom invalide");
		Collegue individuAjoute = new Collegue(x, "x", "Leonard", "durant@example.fr", LocalDate.of(1990, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
	}
	
	@Test( expected = CollegueInvalideException.class)
	public void sauvegarderCollegueEmailInvalide() {
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue avec un nom invalide");
		Collegue individuAjoute = new Collegue(x, "x", "Leonard", "durantexample.fr", LocalDate.of(1990, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
	}
	@Test( expected = CollegueInvalideException.class)
	public void sauvegarderCollegueDateIncorrecte() {
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue avec un nom invalide");
		Collegue individuAjoute = new Collegue(x, "x", "Leonard", "durantexample.fr", LocalDate.of(2015, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
	}
	
	

}
