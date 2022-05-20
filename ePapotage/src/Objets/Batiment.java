package Objets;

import java.util.ArrayList;

public class Batiment {
	
	static ArrayList<Concierge> ListeConcierges = new ArrayList<Concierge>();
	public static ArrayList<Bavard> ListeBavards = new ArrayList<Bavard>();
	
	public static void CreateConcierge(String nom, String prenom) {
		Concierge C = new Concierge(nom, prenom);
		ListeConcierges.add(C);
	}
	
	public static void CreateBavard(String nom, String prenom) {
		Bavard B = new Bavard(nom, prenom);
		ListeBavards.add(B);
	}
	
	public static ArrayList<Concierge> getListeConcierge() {
		return ListeConcierges;
	}
	
	public static ArrayList<Bavard> getListeBavards() {
		return ListeBavards;
	}
}
