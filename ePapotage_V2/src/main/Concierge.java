package main;

import java.util.ArrayList;

//Les concierges re�oivent des publications post�s par les bavards et les transmettent aux bavards ayant souscrit
//Ici on admettra que les concierges correspondent � des th�mes auxquels les bavards seraient abonn�s
public class Concierge implements PapotageListener {

	private String theme;
	private ArrayList<PapotageListener> listeners = new ArrayList<PapotageListener>();
	
	public Concierge(String theme) {
		this.setTheme(theme);
		Bavard.addListener(this); //Concierge est listener des bavards
	}
	
	//Pour mettre � jour la liste des �couteurs d'un concierge
	public void addListener(PapotageListener PL) {
		listeners.add(PL);
	}
	public void removeListener(PapotageListener PL) {
		listeners.remove(PL);
	}

	@Override
	public void getMessage(PapotageEvent newMsg) {
		
	
		if (this.getTheme().equalsIgnoreCase(newMsg.getTheme())) {
			
			//Message transmis aux bavards abonn�s au concierge si le th�me concierge correspond au th�me du msg
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
