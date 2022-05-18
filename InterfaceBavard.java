package ePapotage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceBavard {

	public static void GestionBavard() {
		
		JFrame frame = new JFrame("Bavard");
		
		//Panel bavards en ligne
		JPanel panelOnline = new JPanel();
		panelOnline.setBounds(10,50,150,400);
		panelOnline.setBackground(Color.lightGray);
		
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
        frame.add(panelOnline);
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //menu
        frame.add(panelMenu);
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        frame.setResizable(false);
		frame.setSize(550, 500);
        frame.setVisible(true);
		
	}

}
