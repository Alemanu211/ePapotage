package ePapotage;

public class Bavard implements PapotageListener{

	private String nom;
	private String prenom;
	private String status;
	
	public Bavard(String nom, String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setStatus("Offline");
	}
	
	
	@Override
	public void getAllMessage() {
		for (PapotageEvent PE : PapotageEvent.ListePapotagesB()) {

			System.out.println("Message reçu :" + PE.getCorps());
			
		}
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public void getMessage(String ID) {
		// TODO Auto-generated method stub
		
	}



}
