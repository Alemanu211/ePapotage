package Objets;

import java.util.ArrayList;

public class PapotageEvent {
	private String sujet;
	private String corps;
	private Object auteur;
	private String id;
	private String nomAuteur;
	public static ArrayList<PapotageEvent> PapotagesConcierge = new ArrayList<>();
	public static ArrayList<PapotageEvent> PapotagesBavards = new ArrayList<>();
	public static ArrayList<PapotageEvent> PapotagesParcours = new ArrayList<>();
	private static int indice = 0;
	
	public PapotageEvent(String sujet, String corps, Bavard auteur) {
		this.setSujet(sujet);
		this.setCorps(corps);
		this.setAuteur(auteur);
		this.setId(auteur.getNom() + "_" + auteur.getPrenom() + "_" + indice );
		indice += 1;
		this.setNomAuteur(auteur.getNom() + " " + auteur.getPrenom());
		PapotagesConcierge.add(this);
		PapotagesParcours.add(this);
	}
	
	public static void PapotageTrigger(PapotageEvent P) {
		PapotagesBavards.add(P);
		PapotagesConcierge.remove(P);
	}
	
	public static ArrayList<PapotageEvent> ListePapotagesP () {
		return PapotagesParcours;
	}
	
	public static ArrayList<PapotageEvent> ListePapotages () {
		return PapotagesConcierge;
	}
	
	public static ArrayList<PapotageEvent> ListePapotagesB () {
		return PapotagesBavards;
	}
	
	public static void regularisation() {
		PapotagesParcours.clear();
		for (PapotageEvent PE : PapotagesConcierge) {
			PapotagesParcours.add(PE);
		}
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
}