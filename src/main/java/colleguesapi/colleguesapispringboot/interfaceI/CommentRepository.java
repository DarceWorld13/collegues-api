package colleguesapi.colleguesapispringboot.interfaceI;

import org.springframework.data.jpa.repository.JpaRepository;

import colleguesapi.colleguesapispringboot.entite.CommentsCollegue;

public interface CommentRepository extends JpaRepository<CommentsCollegue, String> {


}
