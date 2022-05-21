package main;

public class Main {

	public static void main(String[] args) {

		Bavard B1 = new Bavard("Rachid74","123");
		Bavard B2 = new Bavard("Alex2000","234");
		
		Concierge Culture = new Concierge("Culture");
		Concierge Sport = new Concierge("Sport");
		Concierge Loisir = new Concierge("Loisir");
		// --> Automatiquement, un concierge est listener de tous les bavards
		
		
		//Le bavard B1 est abonn� aux th�mes Culture et sport (bouton)
		Culture.addListener(B1);
		Sport.addListener(B1);
		//Le bavard B2 est abonn� aux th�mes Culture et Loisir (bouton)
		Culture.addListener(B2);
		Loisir.addListener(B2);
		//Le bavard B2 se d�sabonne du th�me Culture
		Culture.removeListener(B2);
		
		//Bavard.sendmessage(Th�me, Contenu)
		B1.sendMessage("Culture", "Nappol�on est mort en 1821");
		B2.sendMessage("Loisir", "Hello !");
		
		B1.connexion();
		//Bavard.sendPrivateMessage(Contenu, Destinataire)
		B1.sendPrivateMessage("Salut", B2);
		B1.deconnexion();
		
		
	}

}
