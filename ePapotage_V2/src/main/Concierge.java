package main;

import java.util.ArrayList;

//Les concierges reçoivent des publications postés par les bavards et les transmettent aux bavards ayant souscrit
//Ici on admettra que les concierges correspondent à des thèmes auxquels les bavards seraient abonnés
public class Concierge implements PapotageListener {

	private String theme;
	private ArrayList<PapotageListener> listeners = new ArrayList<PapotageListener>();
	
	public Concierge(String theme) {
		this.setTheme(theme);
		Bavard.addListener(this); //Concierge est listener des bavards
	}
	
	//Pour mettre à jour la liste des écouteurs d'un concierge
	public void addListener(PapotageListener PL) {
		listeners.add(PL);
	}
	public void removeListener(PapotageListener PL) {
		listeners.remove(PL);
	}

	@Override
	public void getMessage(PapotageEvent newMsg) {
		
	
		if (this.getTheme().equalsIgnoreCase(newMsg.getTheme())) {
			
			//Message transmis aux bavards abonnés au concierge si le thème concierge correspond au thème du msg
			for (PapotageListener PL : listeners) {
				PL.getMessage(newMsg);
			}
		}
		
		
	}

	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
