package main_classes;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"serial", "unused"})
public class Main extends JFrame implements ActionListener {
	
private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
private JPanel mainpain = new JPanel();
private ScreenT scrent;
private ScreenU screnu;
private LScreen lscreen;
private CardLayout cardsChris;
private Insets insets;
private PlayMusic musicPlayer;

//****CONSTRUCTION ZONE KEEP OUT****
	public Main() {
		
		try {
			musicPlayer = new PlayMusic();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//initial steps
		Dimension screenSize = new Dimension(1026,684);
		cardsChris = new CardLayout();
		setBounds(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
		setTitle("The Legend of Vyoma");
		setLocationRelativeTo(null);
		insets = this.getInsets();
		
		
		//main panel that everything else is on
		mainpain.setLayout(cardsChris);
		add(mainpain);
		
		/*
		 * OW Screens:
		 * 	C T D
		 *    U
		 * C = screnc
		 * T = scrent
		 * D = scrend
		 * U = screnu
		 */
		//scrent
		scrent = new ScreenT(insets);
		screnu = new ScreenU(insets);
		
		//loading screen because it's cool
		lscreen = new LScreen(getBounds(), musicPlayer);
		lscreen.setPreferredSize(screenSize);
	


		
		Timer move = new Timer(15,this);
		move.start();
		mainpain.add(lscreen, "lscreen");
		mainpain.add(scrent, "scrent");
		mainpain.add(screnu, "screnu");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//****CONSTRUCTION ZONE KEEP OUT****
	

//****MAIN ACTION LISTENER****
	public void actionPerformed(ActionEvent e) {
		lscreen.update();
		if (lscreen.destroy) {
			lscreen.destroy = false;
			cardsChris.show(mainpain, "screnu");
			
			
			
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
