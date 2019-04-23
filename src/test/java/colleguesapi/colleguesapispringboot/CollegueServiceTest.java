package colleguesapi.colleguesapispringboot;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import colleguesapi.colleguesapispringboot.entite.Collegue;
import colleguesapi.colleguesapispringboot.entite.CollegueService;
import colleguesapi.colleguesapispringboot.exception.CollegueInvalideException;
import colleguesapi.colleguesapispringboot.exception.CollegueNonTrouveException;
import colleguesapi.colleguesapispringboot.interfaceI.CollegueRepository;

public class CollegueServiceTest {
	
	private static final  Logger LOG = LoggerFactory.getLogger(CollegueServiceTest.class); 
	
	//test pour sauvegarderCollegue
	
	//dans le cas où c'est passant
	@Test
	public void sauvegarderCollegue() {
		
		CollegueRepository colRepo = Mockito.mock(CollegueRepository.class); 
		
		Collegue col = new Collegue("hdjkdghe", "Trump", "Donald", "donaldTrump@trump.com", LocalDate.of(1800, Month.AUGUST, 20), "http://trump.com"); 
		
		CollegueService service = new CollegueService(colRepo); 
		
		service.sauvegarderCollegue(col); 
		
		Mockito.verify(colRepo).save(col); 
		
		
	}
	//Dans le cas où le test ne passe pas 
	@Test( expected = CollegueInvalideException.class)
	public void sauvegarderCollegueNomInvalide() {
		 
		CollegueRepository colRepo = Mockito.mock(CollegueRepository.class); 
		
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue avec un nom invalide");
		Collegue individuAjoute = new Collegue(x, "x", "Leonard", "durant@example.fr", LocalDate.of(1990, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(colRepo); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
	}
	
	@Test( expected = CollegueInvalideException.class)
	public void sauvegarderCollegueEmailInvalide() {
		
		CollegueRepository colRepo = Mockito.mock(CollegueRepository.class); 
		
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue avec un nom invalide");
		Collegue individuAjoute = new Collegue(x, "x", "Leonard", "durantexample.fr", LocalDate.of(1990, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(colRepo); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
	}
	@Test( expected = CollegueInvalideException.class)
	public void sauvegarderCollegueDateIncorrecte() {
		
		CollegueRepository colRepo = Mockito.mock(CollegueRepository.class); 
		String x = UUID.randomUUID().toString();
		
		LOG.info("étant donné, une instance de Collegue avec une date invalide");
		Collegue individuAjoute = new Collegue(x, "x", "Leonard", "durantexample.fr", LocalDate.of(2015, Month.AUGUST, 03), "http://google.fr"); 
		
		LOG.info("lorsqu'on ajoute une personne");
		
		CollegueService collegueAjoute = new CollegueService(colRepo); 
		
		collegueAjoute.sauvegarderCollegue(individuAjoute);
	}
	
	
	//TODO: test pour rechercherParNom()
	@Test
	public void rechercherParNom() {
		
		CollegueRepository colRepo = Mockito.mock(CollegueRepository.class); 
		CollegueService collegueAjoute = new CollegueService(colRepo); 
		
		
		String nomRecherche = "Dupont"; 
		
		List<Collegue> listeColleguesIssusDeLaBase = Arrays.asList(new Collegue("fff", "x", "Leonard", "durantexample.fr", LocalDate.of(2015, Month.AUGUST, 03), "http://google.fr"));
		
		
		Mockito.when(colRepo.findByNom(nomRecherche)).thenReturn(listeColleguesIssusDeLaBase);
		
		
		List<Collegue> resultats = collegueAjoute.rechercherParNom(nomRecherche);
		
		Mockito.verify(colRepo).findByNom(nomRecherche); 
		
		Assert.assertTrue(resultats.size() == 1);
	}
	
	//dans le cas où ça ne passe passe pas
	@Test(expected = CollegueNonTrouveException.class)
	public void rechercherParNomInvalide() {
		
		CollegueRepository colRepo = Mockito.mock(CollegueRepository.class); 
		
		String nomRecherche =""; 
		
		colRepo.findByNom(nomRecherche);
		
		
	}
	

}
