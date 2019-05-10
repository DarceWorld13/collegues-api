package colleguesapi.colleguesapispringboot.entite;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import colleguesapi.colleguesapispringboot.interfaceI.CollegueRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	  private CollegueRepository utilisateurRepository;

	  public UserDetailsServiceImpl(CollegueRepository utilisateurRepository) {
	    this.utilisateurRepository = utilisateurRepository;
	  }

	  @Override
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	    // Recherche d'utilisateur par nom utilisateur
	    Collegue utilisateurTrouve = this.utilisateurRepository.findByEmail(email)
	      .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));


	    // Création d'un objet User (implémentant UserDetails)
	    return new User(utilisateurTrouve.getEmail(), utilisateurTrouve.getMotDePasse(),utilisateurTrouve.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

	  }
	  

}
