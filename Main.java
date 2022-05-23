package main_classes;
import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	
private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
private JPanel mainpain = new JPanel();
private JPanel gamepain = new JPanel();
private LScreen lscreen;
private Tile[][] t;
private CardLayout cardsChris;
private Insets insets;

//****CONSTRUCTION ZONE KEEP OUT****
	public Main() {
		
		//initial steps
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cardsChris = new CardLayout();
		setBounds(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
		setTitle("The Legend of Vyoma");
		setLocationRelativeTo(null);
		insets = this.getInsets();
		
		
		//main panel that everything else is on
		mainpain.setLayout(cardsChris);
		add(mainpain);
		
		//gamepain
		gamepain.setBackground(new Color(100,230,255));
		gamepain.setLayout(null);
		
		//loading screen because it's cool
		lscreen = new LScreen(getBounds());
		lscreen.setPreferredSize(screenSize);
		
		t = new Tile[6][9];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = new Tile(j,i, insets);
			}
		}


		
		Timer move = new Timer(15,this);
		move.start();
		mainpain.add(lscreen, "lscreen");
		mainpain.add(gamepain, "gamepain");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//****CONSTRUCTION ZONE KEEP OUT****
	

//****MAIN ACTION LISTENER****
	public void actionPerformed(ActionEvent e) {
		lscreen.update();
		if (lscreen.destroy) {
			cardsChris.show(mainpain, "gamepain");
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[i].length; j++) {
					gamepain.add(t[i][j]);
				}
			}
		}
		
		for(Enemy i:enemies) {
			i.pathfind();
			i.update();
		}
	}
	

	
//MAIN METHOD
	public static void main(String[] args) {
		new Main();
	}

}
