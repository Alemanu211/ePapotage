package ePapotage;

public class Concierge implements PapotageListener {
	
	private String nom;
	private String prenom;
	
	public Concierge(String nom, String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	@Override
	public void getAllMessage() {
		
	}
	
	@Override
	public void getMessage(String ID) {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
