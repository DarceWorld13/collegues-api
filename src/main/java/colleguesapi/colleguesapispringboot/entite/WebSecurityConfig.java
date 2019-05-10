package colleguesapi.colleguesapispringboot.entite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	  JWTAuthorizationFilter jwtAuthorizationFilter;
	
	 @Value("${jwt.cookie}")
	  private String TOKEN_COOKIE;
	
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	 
	 
	 
	 @Override
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {

	    // toutes les requêtes sont permises
	    // => aucune n'est soumise à authentification
	    http
	    .csrf().disable()
	    .cors().and()
	    .authorizeRequests()
	   /*autorisation d'accès à h2*/
	    .antMatchers("/h2-console/**").permitAll()
	    /*l'url /me où on se connecte pour accéder aux pages*/
	    .antMatchers(HttpMethod.POST, "/auth").permitAll()
	    .anyRequest().authenticated()
	   // .antMatchers(HttpMethod.GET, "/me").permitAll()
	    

	      // accès à la console h2 sans authentification
	      .and().headers().frameOptions().disable()
	      
	      .and()
	      .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
	    
	      .logout()
	      // en cas de succès un OK est envoyé (à la place d'une redirection vers /login)
	      .logoutSuccessHandler((req, resp, auth) -> resp.setStatus(HttpStatus.OK.value()))
	      // suppression du cookie d'authentification
	      .deleteCookies(TOKEN_COOKIE); // Gestion de la déconnexion
	  }
	

}
