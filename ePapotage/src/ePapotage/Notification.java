package ePapotage;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Objets.Bavard;

public class Notification {
	
	static JFrame Fenetre()
	  {
	    JFrame frame = new JFrame("Notification");
	    frame.setSize(350, 150);
	    frame.setVisible(true);
	    frame.setResizable(false);
	    

        //ici on centre notre fenetre 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	    return frame;
	  }
	
	public static void CreateBavardEvent(Bavard B) {
		JFrame frame = Fenetre();
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " a été créé !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/check.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void AlreadyCreateBavardEvent(Bavard B) {
		JFrame frame = Fenetre();
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " existe déjà !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/red_cross.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void OnLineBavardEvent(Bavard B) {
		JFrame frame = Fenetre();
		B.setStatus("Online");
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " s'est connecté !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/connected.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void OffLineBavardEvent(Bavard B) {
		JFrame frame = Fenetre();
		B.setStatus("Offline");
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " s'est déconnecté !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/disco.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void IssueConnect(Bavard B) {
		JFrame frame = Fenetre();
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " est déjà connecté !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/red_cross.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void IssueDisonnect(Bavard B) {
		JFrame frame = Fenetre();
        String str = "Le bavard " + B.getPrenom() + " " + B.getNom() + " est déjà hors ligne !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/red_cross.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}
	
	public static void SendMessage() {
		JFrame frame = Fenetre();
        String str = "Le message a bien été envoyé !";
        ImageIcon icone = new ImageIcon(new ImageIcon("src/Images/envoyer.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(str, icone, JLabel.CENTER);
		frame.add(label);
	}

}

