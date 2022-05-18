package ePapotage;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Batiment {
	
	static ArrayList<Concierge> ListeConcierges = new ArrayList<Concierge>();
	static ArrayList<Bavard> ListeBavards = new ArrayList<Bavard>();
	
	public static void CreateConcierge(String nom, String prenom) {
		Concierge C = new Concierge(nom, prenom);
		ListeConcierges.add(C);
	}
	
	public static void CreateBavard(String nom, String prenom) {
		Bavard B = new Bavard(nom, prenom);
		ListeBavards.add(B);
	}
	
	public static void OnLineBavardEvent(Bavard B) {
		B.setStatus("Online");
		
		JFrame frame = new JFrame("Notification");
        frame.setSize(350, 150);
        frame.setVisible(true);
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " s'est connect� !";
		JLabel label = new JLabel(str, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void OffLineBavardEvent(Bavard B) {
		B.setStatus("Offline");
		
		JFrame frame = new JFrame("Notification");
        frame.setSize(350, 150);
        frame.setVisible(true);
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " s'est d�connect� !";
		JLabel label = new JLabel(str, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void IssueConnect(Bavard B) {
		
		JFrame frame = new JFrame("Notification");
        frame.setSize(350, 150);
        frame.setVisible(true);
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " est d�j� connect� !";
		JLabel label = new JLabel(str, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void IssueDisonnect(Bavard B) {
		
		JFrame frame = new JFrame("Notification");
        frame.setSize(350, 150);
        frame.setVisible(true);
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " est d�j� hors ligne !";
		JLabel label = new JLabel(str, JLabel.CENTER);
		frame.add(label);
	}
	
	public static ArrayList<Concierge> getListeConcierge() {
		return ListeConcierges;
	}
	
	public static ArrayList<Bavard> getListeBavards() {
		return ListeBavards;
	}
}
