package main_classes;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

@SuppressWarnings({"serial", "unused"})
public class Main extends JFrame implements ActionListener {
	
	
//John Field (inventor of the nocturne)
private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
private JPanel mainpain = new JPanel();
private ScreenT scrent;
private ScreenU screnu;
private ScreenN screnn;
private LScreen lscreen;
private CardLayout cardsChris;
private Insets insets;
private Player player;
private boolean mvtEnabled;
static boolean debug; //debug screen popup - press T during runtime to activate
private int currentScreen;
private boolean rmove,lmove,umove,dmove;

//****CONSTRUCTION ZONE KEEP OUT****
	public Main() {
		
		mvtEnabled = false;
		rmove = true;
		lmove = true;
		umove = true;
		dmove = true;
		currentScreen = 0;
		
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
		
		//troubleshoot statement for screen setup
		System.out.println(new Tile(0,0,insets));
		
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
		//screnu
		screnu = new ScreenU(insets);
		//screnn
		screnn = new ScreenN(insets);
		
		//player
		player = new Player(4, 3, insets);
		
		//loading screen because it's cool
		lscreen = new LScreen(getBounds());
		
		
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			@SuppressWarnings("static-access")
			
			public void keyPressed(KeyEvent e) {
				if (mvtEnabled) {
					if(e.getKeyCode() == e.VK_W && umove) {player.setDy(-4); };
					if(e.getKeyCode() == e.VK_S && dmove) player.setDy(4);
					if(e.getKeyCode() == e.VK_A && lmove) player.setDx(-4);
					if(e.getKeyCode() == e.VK_D && rmove) player.setDx(4);
					if(e.getKeyCode() == e.VK_T) 
						if (debug) debug = false;
						else debug = true;
				}
			}
			@SuppressWarnings("static-access")
			public void keyReleased(KeyEvent e) {
				if (mvtEnabled) { 
					if(e.getKeyCode() == e.VK_W) player.setDy(0);
					if(e.getKeyCode() == e.VK_S) player.setDy(0);
					if(e.getKeyCode() == e.VK_A) player.setDx(0);
					if(e.getKeyCode() == e.VK_D) player.setDx(0);
				}
			}
		});
		
		
		

		
		Timer move = new Timer(15,this);
		move.start();
		mainpain.add(lscreen, "lscreen");
		mainpain.add(scrent, "scrent");
		mainpain.add(screnu, "screnu");
		mainpain.add(screnn, "screnn");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//****CONSTRUCTION ZONE KEEP OUT****
	

//****MAIN ACTION LISTENER****
	public void actionPerformed(ActionEvent e) {
		lscreen.update();
		player.update();
		lscreen.destroy = true; //skips loading screen
		
		
		//screen switchers
		if (lscreen.destroy && currentScreen == 0) { //sets screen to cave scene
			cardsChris.show(mainpain, "screnu");
			currentScreen = 1;
			screnu.remv();
			screnu.add(player);
			screnu.readd();
			lscreen.destroy = false;
			mvtEnabled = true;
		}
		if (currentScreen == 1) { 
			if (!player.enrec.intersects(screnu.switcheruu)) { //sets screen from cave scene to grass scene
				screnu.remove(player);
				player.setLocationByTile(5,5);
				cardsChris.show(mainpain, "scrent");
				currentScreen = 2;
				scrent.remv();
				scrent.add(player);
				scrent.readd();
			}
		}
		if (currentScreen == 2) { 
			if (player.enrec.intersects(scrent.switchertt)) { //sets screen from grass screen to cave screen
				scrent.remove(player);
				player.setLocationByTile(4,0);
				cardsChris.show(mainpain, "screnu");
				currentScreen = 1;
				screnu.remv();
				screnu.add(player);
				screnu.readd();
			}
		}
		
		//obstacle collisions
		boolean isHitting = false;
		if (currentScreen == 1) {
			isHitting = screnu.compareAgainstTiles(player.enrec);
			System.out.println("a");
		}
		if (currentScreen == 2) {
			isHitting = scrent.compareAgainstTiles(player.enrec);
			System.out.println("b");
		}
		if (currentScreen == 3) {
			isHitting = screnn.compareAgainstTiles(player.enrec);
			System.out.println("c");
		}
		
		if (isHitting) {
			if (player.getDirect().equals("up")) {
				umove = false;
				player.setDy(0);
			}
			if (player.getDirect().equals("down")) {
				dmove = false;
				player.setDy(0);
			}
			if (player.getDirect().equals("left")) {
				lmove = false;
				player.setDx(0);
			}
			if (player.getDirect().equals("right")) {
				rmove = false;
				player.setDx(0);
			}
		}
		else {
			umove = true;
			dmove = true;
			lmove = true;
			rmove = true;
		}
	
	
	
		
		for(Enemy i:enemies) {
			i.pathfind();
			i.update();
		}
		repaint();
		screnu.update();
		scrent.update();
		screnn.update();
	}
	

	
//MAIN METHOD
	public static void main(String[] args) {
		new Main();
	}
	
	public boolean anyMvtDisabled() {
		if (!umove || !lmove || !dmove || !rmove) return true;
		return false;
	}

}
