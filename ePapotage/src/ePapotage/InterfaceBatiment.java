package ePapotage;

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

public class InterfaceBatiment {
	
	public static void CreationBavards()  {
		
		JFrame frame = new JFrame("Batiment");
		
		//Menu
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(10,0,510,40);
		panelMenu.setBackground(Color.lightGray);
		JButton btnMenu1 = new JButton("Batiment");
		JButton btnMenu2 = new JButton("Concierge");
		JButton btnMenu3 = new JButton("Bavard");
		btnMenu1.setBackground(Color.cyan);
		panelMenu.add(btnMenu1);
		panelMenu.add(btnMenu2);
		panelMenu.add(btnMenu3);
		
		//Panel pour ajouter le bavard
		JPanel panelAdd = new JPanel();
		panelAdd.setBounds(10,50,250,400);
		panelAdd.setBackground(Color.lightGray);
		
		//Panel de connexion/Deconnexion
		JPanel panelStatus = new JPanel();
		panelStatus.setBounds(270,50,250,400);
		panelStatus.setBackground(Color.lightGray);
		
		//TextFields de la creation bavard 
		JTextField textP = new JTextField("Prenom");
		JTextField textN = new JTextField("Nom");
		textP.setBounds(20,40,200,28);
		textN.setBounds(20,80,200,28);
		
		//TextFields du status bavard 
		JTextField textP2 = new JTextField("Prenom");
		JTextField textN2 = new JTextField("Nom");
		textP2.setBounds(20,40,220,28);
		textN2.setBounds(20,80,220,28);
		
        JButton btn1 = new JButton("Ajoutez le bavard");
        btn1.setBounds(20,120,200,40);
        
        JButton btn2 = new JButton("Connexion");
        btn2.setBounds(20,120,100,40);
        
        JButton btn3 = new JButton("Deconnexion");
        btn3.setBounds(130,120,110,40);
        
        btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String prenom = textP.getText();
				String nom = textN.getText();
				Batiment.CreateBavard(nom, prenom);
				System.out.println("Le bavard " + prenom + " " + nom + " � bien �t� ajout� !");
			}
        });
        
        btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String prenom = textP2.getText();
				String nom = textN2.getText();
				for (Bavard Bv : Batiment.getListeBavards()) {
					
					
					if ( (prenom.equalsIgnoreCase(Bv.getPrenom())) && (nom.equalsIgnoreCase(Bv.getNom())) ) {
						if (Bv.getStatus().equals("Offline")) {
							Batiment.OnLineBavardEvent(Bv);
						}
						else { Batiment.IssueConnect(Bv); }
					}
				}
			}
        });
        
        btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String prenom = textP2.getText();
				String nom = textN2.getText();
				for (Bavard Bv : Batiment.getListeBavards()) {
					
					
					if ( (prenom.equalsIgnoreCase(Bv.getPrenom())) && (nom.equalsIgnoreCase(Bv.getNom())) ) {
						if (Bv.getStatus().equals("Online")) {
							Batiment.OffLineBavardEvent(Bv);
						}
						else { Batiment.IssueDisonnect(Bv); }
					}
				}
			}
        });
        
        //Listener menu
        //2 concierge, 3 bavard, 1Batiment
        btnMenu2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InterfaceConcierge.GestionConcierge();
			}
        });
        btnMenu3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InterfaceBavard.GestionBavard();
			}
        });
        
        
        
        frame.setLayout(null);
        panelAdd.setLayout(null);
        panelStatus.setLayout(null);
        panelAdd.add(textP);
        panelAdd.add(textN);
        panelAdd.add(btn1);
        panelStatus.add(textP2);
        panelStatus.add(textN2);
        panelStatus.add(btn2);
        panelStatus.add(btn3);
        
        //menu
        frame.add(panelMenu);
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        frame.setResizable(false);
        frame.add(panelAdd);
        frame.add(panelStatus);
		frame.setSize(550, 500);
        frame.setVisible(true);
		
	}

}
