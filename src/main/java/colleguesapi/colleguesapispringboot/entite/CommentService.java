package colleguesapi.colleguesapispringboot.entite;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import colleguesapi.colleguesapispringboot.interfaceI.CommentRepository;

@Service
public class CommentService {

	CommentRepository cRepo; 
	

	@Autowired
	public CommentService(CommentRepository cRepo) {
		super();
		this.cRepo = cRepo;
	}
	
	
	
	
	public CommentRepository getcRepo() {
		return cRepo;
	}

	public void setcRepo(CommentRepository cRepo) {
		this.cRepo = cRepo;
	}

	
	
	/*
pour ajouter des commentaires en base de données 
	public CommentsCollegue ajouterCommentaire(String matricule, String s) {
		
		Optional<Collegue> collegueTrouve = cRepo.findByMatricule(matricule);
		
		CommentsCollegue cc = new CommentsCollegue(); 
		cc.setComments(s);
		cc.setCol(collegueTrouve); 
		
		return cRepo.save(cc); 
		
	}
	
	*/
	
}
