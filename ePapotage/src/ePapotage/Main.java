package ePapotage;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Bavard B1 = new Bavard("Faska","Rachid");
		Bavard B2 = new Bavard("Descomps","Alexandre");
		Concierge C1 = new Concierge("Monsieur", "Z");
		
		PapotageEvent e1 = new PapotageEvent("Histoire", "Napoléon 1er est mort en 1821", B1);
		PapotageEvent e2 = new PapotageEvent("Programmation", "Prolog est un langage de programmation utilisé dans l'IA", B1);
		

		//C1.getMessage(e1); //Le message passe par le concierge
		//C1.getMessage(e2);
		B2.getAllMessage(); //Le message est reçu du concierge
		
		
		//Avec la bonne gestion
		Batiment.CreateConcierge("Monsieur","Z");
		Batiment.CreateBavard("Descomps", "Alexandre");
		Batiment.CreateBavard("Faska", "Rachid");
		ArrayList<Bavard> L1 = Batiment.getListeBavards();
		
		//Batiment.Connexion(L1.get(1)); //Connexion du Bavard 0
		System.out.println("Bavard 1: " + L1.get(0).getStatus());
		System.out.println("Bavard 2: " + L1.get(1).getStatus());
		
		InterfaceBatiment.CreationBavards();
		
		ArrayList<String> test = new ArrayList<String>();
		test.add("salllut");
		test.add("1");
		test.add("3");
		test.add("4");
		test.remove("3");
		System.out.println(test);
		
	}

}
