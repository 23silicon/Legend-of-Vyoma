package main_classes;
import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	
private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
private JPanel mainpain = new JPanel();
private LScreen lscreen;

//****CONSTRUCTION ZONE KEEP OUT****
	public Main() {
		
		//initial steps
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		CardLayout cardsChris = new CardLayout();
		setBounds(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
		setTitle("The Legend of Vyoma");
		setLocationRelativeTo(null);
		
		//main panel that everything else is on
		mainpain.setLayout(cardsChris);
		add(mainpain);
		
		//loading screen because it's cool
		lscreen = new LScreen(getBounds());
		lscreen.setPreferredSize(screenSize);
		
		
		
		
		Timer move = new Timer(15,this);
		move.start();
		mainpain.add(lscreen);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//****CONSTRUCTION ZONE KEEP OUT****
	

//****MAIN ACTION LISTENER****
	public void actionPerformed(ActionEvent e) {
		lscreen.update();
		if (lscreen.destroy) {
			mainpain.remove(lscreen);
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
