package ePapotage;

public class Bavard implements PapotageListener{

	private String nom;
	private String prenom;
	
	public Bavard(String nom, String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	@Override
	public void getMessage(PapotageEvent msg) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void getAllMessage() {
		for (PapotageEvent PE : PapotageEvent.ListePapotages()) {
			if (PE.getAuteur() instanceof Concierge) {
				System.out.println("Message reçu :" + PE.getCorps());
			}
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



}
