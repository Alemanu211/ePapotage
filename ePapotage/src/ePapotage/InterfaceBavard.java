package ePapotage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class InterfaceBavard {

	
	public static void ListenerCheckbox (JCheckBox C, JComboBox<String> J) {
		
		J.removeAllItems();
		J.addItem("Boite de reception");
		for (PapotageEvent PE: PapotageEvent.ListePapotagesB()) {
			if (C.isSelected() && PE.getSujet().equals("Loisir")) { 
				J.addItem(PE.getId());
			}
			else if (C.isSelected() && PE.getSujet().equals("Sport")) { 
				J.addItem(PE.getId());
			}
			else if (C.isSelected() && PE.getSujet().equals("Culture")) { 
				J.addItem(PE.getId());
			}
			else if (C.isSelected() && PE.getSujet().equals("Divers")) { 
				J.addItem(PE.getId());
			}
			
		}
	}
	
	public static void GestionBavard() {
		
		JFrame frame = new JFrame("Bavard");
		
		//Panel bavards en ligne
		JPanel panelOnline = new JPanel();
		panelOnline.setBounds(10,50,150,450);
		panelOnline.setBackground(Color.lightGray);
		
		//Panel selection du bavard
		JPanel selectBavard = new JPanel();
		selectBavard.setBounds(170,50,350,40);
		selectBavard.setBackground(Color.lightGray);
		
		//Panel envoi message
		JPanel sendMessage = new JPanel();
		sendMessage.setBounds(170,100,350,180);
		sendMessage.setBackground(Color.lightGray);
		
		//Panel lecture message
		JPanel readMessage = new JPanel();
		readMessage.setBounds(170,290,350,210);
		readMessage.setBackground(Color.lightGray);

		//Bavards en ligne
		JLabel Online = new JLabel("Membres en ligne :");
		Online.setForeground(Color.blue); 
		panelOnline.add(Online);
		for (Bavard B : Batiment.ListeBavards) {
			if (B.getStatus().equals("Online")) {
				String str = B.getPrenom() + " " + B.getNom();
				JLabel label = new JLabel(str);
				label.setForeground(Color.BLUE);
				panelOnline.add(label);
			}
		}
		ArrayList<PapotageEvent> L1 = PapotageEvent.ListePapotages();
		Object[] array = L1.toArray();
		System.out.println( Arrays.toString(array) );
		
		//Selection du bavard
		JComboBox<String> cb = new JComboBox<String>();
		
		for (Bavard B : Batiment.getListeBavards()) {
			String str = B.getPrenom() + " " + B.getNom(); 
			cb.addItem(str);
		}
		
		JLabel labelSelect = new JLabel("Selection du bavard");
		cb.setBounds(5,30,160,28);
		labelSelect.setBounds(70,30,210,28);
		selectBavard.add(labelSelect);
		selectBavard.add(cb);
		
		
		
		//Liste de thèmes
		JRadioButton Loisir = new JRadioButton("Loisir"); 
		JRadioButton Sport = new JRadioButton("Sport"); 
		JRadioButton Culture = new JRadioButton("Culture");
		JRadioButton Divers = new JRadioButton("Divers"); 
		ButtonGroup bg = new ButtonGroup();
		bg.add(Loisir);
		bg.add(Sport);
		bg.add(Culture);
		bg.add(Divers);
		Loisir.setBounds(20,0,70,25);
		Sport.setBounds(100,0,70,25);
		Culture.setBounds(180,0,70,25);
		Divers.setBounds(260,0,70,25);
		Loisir.setBackground(Color.LIGHT_GRAY);
		Culture.setBackground(Color.LIGHT_GRAY);
		Sport.setBackground(Color.LIGHT_GRAY);
		Divers.setBackground(Color.LIGHT_GRAY);
		sendMessage.add(Loisir);
		sendMessage.add(Sport);
		sendMessage.add(Culture);
		sendMessage.add(Divers);
		
		//Ecrire un message
		JTextArea EcritureMsg = new JTextArea();
		EcritureMsg.setBounds(25,30,300,100);
		sendMessage.add(EcritureMsg);
		
		//Envoyer message
		JButton sendBtn = new JButton("Poster le message");
		sendBtn.setBounds(100,140,160,25);
		sendMessage.add(sendBtn);
		
		//Menu
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(10,0,510,40);
		panelMenu.setBackground(Color.lightGray);
		JButton btnMenu1 = new JButton("Batiment");
		JButton btnMenu2 = new JButton("Concierge");
		JButton btnMenu3 = new JButton("Bavard");
		btnMenu3.setBackground(Color.cyan);
		panelMenu.add(btnMenu1);
		panelMenu.add(btnMenu2);
		panelMenu.add(btnMenu3);
		
		//CheckBox readMsg
		JCheckBox checkLoisir = new JCheckBox("Loisir");
		JCheckBox checkSport = new JCheckBox("Sport");
		JCheckBox checkCulture = new JCheckBox("Culture");
		JCheckBox checkDivers = new JCheckBox("Divers");
		checkLoisir.setBounds(20,0,70,25);
		checkSport.setBounds(100,0,70,25);
		checkCulture.setBounds(180,0,70,25);
		checkDivers.setBounds(260,0,70,25);
		readMessage.add(checkLoisir);
		readMessage.add(checkSport);
		readMessage.add(checkCulture);
		readMessage.add(checkDivers);
		checkLoisir.setBackground(Color.LIGHT_GRAY);
		checkCulture.setBackground(Color.LIGHT_GRAY);
		checkSport.setBackground(Color.LIGHT_GRAY);
		checkDivers.setBackground(Color.LIGHT_GRAY);
		JButton actualiser = new JButton("Actualiser");
		actualiser.setBounds(225,30,100,25);
		readMessage.add(actualiser);
		
		
		//Selecteur de message
		JComboBox<String> cb2 = new JComboBox<String>();
		cb2.addItem("Boite de reception");
		
		cb2.setBounds(20,30,150,25);
		readMessage.add(cb2);
		
		//TextArea ReadMsg
		JTextArea LectureMsg = new JTextArea();
		LectureMsg.setEditable(false);
		LectureMsg.setBounds(25,70,300,130);
		readMessage.add(LectureMsg);
				
		
		//Listener radiobutton read msg
		actualiser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> Lthemes = new ArrayList<String>();
				if (checkLoisir.isSelected()) {
					Lthemes.add("Loisir");
					cb2.removeAllItems();
				}
				else if (checkSport.isSelected()) {
					Lthemes.add("Sport");
				}
				else if (checkCulture.isSelected()) {
					Lthemes.add("Culture");
				}
				else if (checkDivers.isSelected()) {
					Lthemes.add("Divers");
				}
				
				System.out.println(cb2.getItemCount());
				
				for (PapotageEvent PE : PapotageEvent.ListePapotagesB()) {
					if (Lthemes.contains(PE.getSujet())){
						int exist = 0;
						String str = PE.getId();
						for (int i=0; i>cb2.getItemCount(); i++) {
							System.out.println(cb2.getItemAt(i));
							if(cb2.getItemAt(i).equalsIgnoreCase(str)) {
								exist = 1;
							}
						}
						
						
						if (exist == 0) {
							cb2.addItem(str);
						}
						
						
					} else { cb2.removeItem(PE.getId());}
				}
			}
		});
		
		
		
		
		//Listener Combobox reading 
		cb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				
				String s1 = cb2.getSelectedItem().toString();
				for (PapotageEvent PE : PapotageEvent.ListePapotagesB()) {
					if (s1.equals(PE.getId())) {
						String s2 = "Theme : " + PE.getSujet() + "\n\n" + PE.getCorps() + "\n\nAuteur : " + PE.getNomAuteur();
						LectureMsg.setText(s2);
						break;
					}
				}
				
				
			}	
        });
		
		//Listener radiobutton send msg
		sendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String theme = null;
				String contenu = EcritureMsg.getText();
				String auteur = cb.getSelectedItem().toString();
				
				if(Loisir.isSelected()){  
				       theme = Loisir.getText();
				}  
				else if(Sport.isSelected()){  
				       theme = Sport.getText();
				}
				else if(Culture.isSelected()){  
				       theme = Culture.getText();
				}
				else if(Divers.isSelected()){  
				       theme = Divers.getText();
				}
				
				if (theme == null) {
					System.out.println("Veuillez choisir un thème");
					//A FAIRE : NOTIF POUR DIRE VEUILLEZ CHOISIR UN THEME
				}
				
				else {
					for (Bavard B : Batiment.getListeBavards()) {
						String str = B.getPrenom() + " " + B.getNom();
						if (str.equalsIgnoreCase(auteur)) {
							PapotageEvent E = new PapotageEvent(theme, contenu, B);
							//A FAIRE : NOTIF POUR DIRE MESSAGE ENVOYE AU CONCIERGE
							EcritureMsg.setText("");
							break;
						}
					}
				}
			}
		});
		
		
		//Listener menu
        //2 concierge, 3 bavard, 1Batiment
        btnMenu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InterfaceBatiment.CreationBavards();
			}
        });
        btnMenu2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InterfaceConcierge.GestionConcierge();
			}
        });
		
		
        frame.setLayout(null);
        readMessage.setLayout(null);
        selectBavard.setLayout(new FlowLayout(FlowLayout.CENTER));
        sendMessage.setLayout(null);
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(panelOnline);
        frame.add(selectBavard);
        frame.add(sendMessage);
        frame.add(readMessage);
        //menu
        frame.add(panelMenu);
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        frame.setResizable(false);
		frame.setSize(550, 550);
        frame.setVisible(true);
        
        //récuperer la taille de l'écran
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;

        //ici on centre notre fenetre 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
	}

}