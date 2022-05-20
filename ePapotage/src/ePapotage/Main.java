package ePapotage;

import InterfacesGraphiques.InterfaceBatiment;
import Objets.Batiment;
import Objets.PapotageEvent;

public class Main {

	public static void main(String[] args) {
		
		
		//Avec la bonne gestion
		Batiment.CreateConcierge("Monsieur","Z");
		Batiment.CreateBavard("Descomps", "Alexandre");
		Batiment.CreateBavard("Faska", "Rachid");
		PapotageEvent e1 = new PapotageEvent("Culture", "Napoléon 1er est mort en 1821", Batiment.getListeBavards().get(0));
		PapotageEvent e2 = new PapotageEvent("Divers", "Prolog est un langage de programmation utilisé dans l'IA", Batiment.getListeBavards().get(0));
		
		
		InterfaceBatiment.CreationBavards();
		
		
		
	}

}
