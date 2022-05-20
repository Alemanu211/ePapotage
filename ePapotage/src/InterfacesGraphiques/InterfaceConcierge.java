package InterfacesGraphiques;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Objets.PapotageEvent;
import ePapotage.Notification;

public class InterfaceConcierge {
		
	
	
		public static void GestionConcierge() {
			
			JFrame frame = new JFrame("Concierge");

	        //Liste déroulante
			JTextArea message = new JTextArea();
			JComboBox<String> cb = new JComboBox<String>();
			JPanel panelCB = new JPanel();
			panelCB.setBounds(10,50,510,400);
			panelCB.setBackground(Color.lightGray);
			
			cb.addItem("-- Select message --");
			for (PapotageEvent PE: PapotageEvent.ListePapotages()) {
				cb.addItem(PE.getId());
			}
			JLabel labelliste = new JLabel("Selection du message");
			cb.setBounds(260,30,160,28);
			labelliste.setBounds(70,30,200,28);
			
			message.setBounds(70,70,350,250);
			message.setEditable(false);
			
			//Changement du textArea
			cb.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					String s1 = cb.getSelectedItem().toString();
					for (PapotageEvent PE : PapotageEvent.ListePapotages()) {
						if (s1.equals(PE.getId())) {
							String s2 = "Theme : " + PE.getSujet() + "\n\n" + PE.getCorps() + "\n\nAuteur : " + PE.getNomAuteur();
							message.setText(s2);
							break;
						}
					}
					
					
				}	
	        });
			
			//BoutonSubmit
			JButton sendMsg = new JButton("Envoyer le message");
			sendMsg.setBounds(70,330,350,28);
			sendMsg.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String ID = cb.getSelectedItem().toString();
					
					if (PapotageEvent.ListePapotages().size()>0) {
						
						for (PapotageEvent PE : PapotageEvent.ListePapotagesP()) {
							if (PE.getId().equals(ID)) {
								PapotageEvent.PapotageTrigger(PE);
								cb.removeItem(ID);
								cb.setSelectedIndex(0); 
								message.setText(" ");
								Notification.SendMessage();
							}
						}
						PapotageEvent.regularisation();
					}
				}
			});
			
			//Menu
			JPanel panelMenu = new JPanel();
			panelMenu.setBounds(10,0,510,40);
			panelMenu.setBackground(Color.lightGray);
			JButton btnMenu1 = new JButton("Batiment");
			JButton btnMenu2 = new JButton("Concierge");
			JButton btnMenu3 = new JButton("Bavard");
			btnMenu2.setBackground(Color.cyan);
			panelMenu.add(btnMenu1);
			panelMenu.add(btnMenu2);
			panelMenu.add(btnMenu3);
			
			//Listener menu
	        //2 concierge, 3 bavard, 1Batiment
	        btnMenu1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//frame.dispose();
					InterfaceBatiment.CreationBavards();
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
			panelCB.add(labelliste);
			panelCB.add(cb);
			panelCB.add(message);
			panelCB.setLayout(null);
			panelCB.add(sendMsg);
			frame.add(panelCB);
	        //menu
	        frame.add(panelMenu);
	        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
	        
	        frame.setResizable(false);
			frame.setSize(550, 500);
	        frame.setVisible(true);
	        
	      

	        //ici on centre notre fenetre 
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
			
		}

		
}
