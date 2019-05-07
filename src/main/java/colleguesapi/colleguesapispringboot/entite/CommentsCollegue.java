package colleguesapi.colleguesapispringboot.entite;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
public class CommentsCollegue {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;  
	
	@Column(name = "comments")
	private String comments; 
	
	@Column(name= "heures")
	
	private LocalDateTime heure = LocalDateTime.now(); 
	
	//lien avec collegue
	@ManyToOne
	 @JoinColumn(name = "matricule_collegue")
     private Collegue col ;
	
	 
	 

	

	public LocalDateTime getHeure() {
			return heure;
		}

		public void setHeure(LocalDateTime heure) {
			this.heure = heure;
		}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public Collegue getCol() {
		return col;
	}

	public void setCol(Collegue col) {
		this.col = col;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setCol(Optional<Collegue> collegueTrouve) {
		
		
	}

	
    

	
}
