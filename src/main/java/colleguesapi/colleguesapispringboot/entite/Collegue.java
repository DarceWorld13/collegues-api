package colleguesapi.colleguesapispringboot.entite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Collegue")
public class Collegue {
	
	@Id
    private String matricule; 
	
    @Column(name = "nom")
    private String nom; 
    @Column(name = "prenoms")
    private String prenoms; 
    @Column(name = "email")
    private String email;
    @Column(name = "dateDeNaissance")
    private LocalDate dateDeNaissance;
    @Column(name = "photoUrl")
    private String photoUrl;
    
    //relation entre commentsCollegue et collegue
    @OneToMany(mappedBy="col")
    private List<CommentsCollegue> col ;
    
    
  
	public Collegue ()
    {
    	
    }
    
	public List<CommentsCollegue> getCol() {
		return col;
	}

	public void setCol(List<CommentsCollegue> col) {
		this.col = col;
	}

	public Collegue(String matricule, String nom, String prenoms, String email, LocalDate dateDeNaissance,
			String photoUrl) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenoms = prenoms;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	
    
    

	

}
