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
		for (PapotageEvent PE : PapotageEvent.ListePapotages()) {
			if (PE.getAuteur() instanceof Bavard) {
				
				PapotageEvent eX = new PapotageEvent(PE.getSujet(), PE.getCorps(), this);
				System.out.println(eX);
			}
			
		}
	}
	
	@Override
	public void getMessage(PapotageEvent msg) {
		
		if (msg.getAuteur() instanceof Bavard) {
			msg.setAuteur(this);
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
