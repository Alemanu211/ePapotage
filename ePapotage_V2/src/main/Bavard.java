package main;

import java.util.*;

public class Bavard implements PapotageListener, StatusListener, PrivateMessageListener{
	
	private String identifiant;
	private String mdp;
	private boolean isOnline;
	static ArrayList<PapotageListener> listeners = new ArrayList<PapotageListener>(); //Tous les concierges sont ecouteurs
	static ArrayList<StatusListener> listenersStatut = new ArrayList<StatusListener>(); //Tous les bavards sont ecouteurs
	
	//init bavard
	public Bavard(String identifiant, String mdp) {
		this.setIdentifiant(identifiant);
		this.setMdp(mdp);
		this.setOnline(false);
		listenersStatut.add((StatusListener) this);
	}
	
	//Pour mettre � jour la liste des �couteurs d'un bavard
	public static void addListener(PapotageListener PL) {
		listeners.add(PL);
	}

	//Un bavard poste un message (il est source d'evenements Papotage)
	public void sendMessage(String theme, String corps) {
		PapotageEvent newMsg = new PapotageEvent(this,theme,corps);
		for (PapotageListener PL : listeners) {
			PL.getMessage(newMsg);
		}
	}

	//Un bavard re�oit un message (il est ecouteur d'�v�nements Papotage)
	@Override
	public void getMessage(PapotageEvent newMsg) {

		System.out.println(this.getIdentifiant() + " � re�u le post suivant : ");
		System.out.println(newMsg.getTheme() + ": " + newMsg.getCorps());
	}

	//Message priv� d'un bavard
	public void sendPrivateMessage(String contenu, PrivateMessageListener destinataire) {
		PrivateMessageEvent mp = new PrivateMessageEvent(this.getIdentifiant(),contenu);
		destinataire.getPrivateMessage(mp);
	}
	
	@Override
	public void getPrivateMessage(PrivateMessageEvent newMp) {
		System.out.println(this.getIdentifiant() + " � re�u un message priv� provenant de " + newMp.getSource());
		System.out.println("Message re�u : " + newMp.getContenu());
		
	}
	
	
	//Gestion du statut Online/Offline
	public void connexion() {
		this.setOnline(true);
		for (StatusListener SL : listenersStatut) {
			SL.OnlineEvent(this);
		}
	}
	public void deconnexion() {
		this.setOnline(false);
		for (StatusListener SL : listenersStatut) {
			SL.OfflineEvent(this);
		}
	}
	@Override
	public void OnlineEvent(Bavard B) {
		System.out.println("Notification pour "+ this.getIdentifiant() + ": Le bavard " + B.getIdentifiant() + " s'est connect�" );
	}
	@Override
	public void OfflineEvent(Bavard B) {
		System.out.println("Notification pour "+ this.getIdentifiant() + ": Le bavard " + B.getIdentifiant() + " s'est d�connect�" );
		
	}

	//Getter et setters
	public ArrayList<PapotageListener> getListeners() {
		return listeners;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	


}
