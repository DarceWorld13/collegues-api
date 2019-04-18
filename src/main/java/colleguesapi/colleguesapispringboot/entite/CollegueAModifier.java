package colleguesapi.colleguesapispringboot.entite;

public class CollegueAModifier {
	
	private String email;
	private String photoUrl; 
	
	
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public CollegueAModifier() {
		
	}

	public CollegueAModifier(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	

	
}
