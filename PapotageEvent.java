package ePapotage;

import java.util.ArrayList;

public class PapotageEvent {
	private String sujet;
	private String corps;
	private Object auteur;
	public static ArrayList<PapotageEvent> Papotages = new ArrayList<>();
	
	public PapotageEvent(String sujet, String corps, Object auteur) {
		this.setSujet(sujet);
		this.setCorps(corps);
		this.setAuteur(auteur);
		Papotages.add(this);
	}
	
	public static ArrayList<PapotageEvent> ListePapotages () {
		return Papotages;
	}
	
	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public Object getAuteur() {
		return auteur;
	}

	public void setAuteur(Object auteur) {
		this.auteur = auteur;
	}
}
