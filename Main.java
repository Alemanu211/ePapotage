package ePapotage;

public class Main {

	public static void main(String[] args) {
		
		Bavard B1 = new Bavard("Faska","Rachid");
		Bavard B2 = new Bavard("Descomps","Alexandre");
		Concierge C1 = new Concierge("Monsieur", "Z");
		
		PapotageEvent e1 = new PapotageEvent("Salutations", "Je vous salue", B1);
		PapotageEvent e2 = new PapotageEvent("Adieu", "Au revoir", B1);
		

		C1.getMessage(e1); //Le message passe par le concierge
		C1.getMessage(e2);
		B2.getAllMessage(); //Le message est reçu du concierge
	}

}
